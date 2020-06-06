package fila;

import java.util.ArrayList;

import decorator.Pedido;

public class PedidosFila{
	private static PedidosFila instance = null;
    private static ArrayList<Pedido> fila = null;
    public String value;
    
    //Singlelton
    private PedidosFila() {
    	fila = new ArrayList<Pedido>();
    }
    
    public static PedidosFila getInstance() {
        if (instance == null) {
            instance = new PedidosFila();
            fila = new ArrayList<Pedido>();
        }
        return instance;
    }

	public Pedido get(Integer id) {
		for (Pedido usu : fila) {
			if (usu.getId() == id) {
				return usu;
			}
		}
		return null;
	}

	public void add(Pedido p) {
		fila.add(p);
	}

	public void remove(Pedido p) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Pedido> getFila(){
		return fila;
	}
}
