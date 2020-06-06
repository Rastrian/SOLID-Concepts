package dao;

import java.util.ArrayList;
import java.util.List;

import decorator.Pedido;

public class PedidosDao implements PedidosDaoInterface<Pedido, Integer>{
	private static PedidosDao instance = null;
    private static ArrayList<Pedido> fila = null;
    public String value;
    
    //Singlelton
    private PedidosDao() {
    	fila = new ArrayList<Pedido>();
    }
    
    public static PedidosDao getInstance() {
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
	public void remove(Pedido p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Pedido> getFila(){
		return fila;
	}
}
