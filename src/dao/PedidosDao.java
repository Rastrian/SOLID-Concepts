package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import profiles.Pedido;

public class PedidosDao implements Dao<Pedido, Integer> {
	private String filename = "pedidos.bin";
	private File file = new File(filename);
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	private static PedidosDao instance = null;
	private static ArrayList<Pedido> fila = null;
	public String value;

	// Singlelton
	private PedidosDao() throws IOException {
		if (!file.exists()) {
			fos = new FileOutputStream(file, false);
			outputFile = new ObjectOutputStream(fos);
			fila = new ArrayList<Pedido>();
		}
		readFromFile();
    }
    
    public static PedidosDao getInstance() throws IOException {
        if (instance == null) {
            instance = new PedidosDao();
			fila = new ArrayList<Pedido>();
		}
        return instance;
    }
    
    @Override
	public Pedido get(Integer id) {
		for (Pedido usu : fila) {
			if (usu.getId() == id) {
				return usu;
			}
		}
		return null;
	}

    @Override
	public void add(Pedido p) {
		fila.add(p);
	}

	@Override
	public void update(Pedido Pedido) {
		int index = fila.indexOf(Pedido);
		if (index != -1) {
			fila.set(index, Pedido);
		}
		saveToFile();
	}

	@Override
	public void remove(Pedido Pedido) {
		int index = fila.indexOf(Pedido);
		if (index != -1) {
			fila.remove(index);
		}
		saveToFile();

	}

	@Override
    public ArrayList<Pedido> getAll() {
        return fila;
	}

	private void saveToFile() {
		try {
			fos = new FileOutputStream(file, false);
			outputFile = new ObjectOutputStream(fos);

			for (Pedido Pedido : fila) {
				outputFile.writeObject(Pedido);
			}
			outputFile.flush();
			readFromFile();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Pedidos no disco!");
			e.printStackTrace();
		}
	}

	private ArrayList<Pedido> readFromFile() {
		fila = new ArrayList<Pedido>();
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {
			while (fis.available() > 0) {
				Pedido pedido = (Pedido) inputFile.readObject();
				fila.add(pedido);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Pedidos no disco!");
			e.printStackTrace();
		}
		return fila;
	}


	public int count() {
		return readFromFile().size();
	}
	
	private void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}
}
