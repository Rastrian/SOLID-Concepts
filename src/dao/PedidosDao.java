package dao;

import java.util.ArrayList;
import java.util.List;

import decorator.Pedido;

public class PedidosDao implements PedidosDaoInterface<Pedido, Integer>{
	private static PedidosDao instance;
    public String value;
    private ArrayList<Pedido> lista;
    
    //Singlelton
    private PedidosDao() {
    	lista = new ArrayList<Pedido>();
    }
    
    public static PedidosDao getInstance(String value) {
        if (instance == null) {
            instance = new PedidosDao();
        }
        return instance;
    }

	@Override
	public Pedido get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Pedido p) {
		// TODO Auto-generated method stub
		return false;
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
}
