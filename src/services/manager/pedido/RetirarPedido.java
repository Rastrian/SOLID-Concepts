package services.manager.pedido;

import java.util.ArrayList;

import dao.PedidosDao;
import profiles.Pedido;

public class RetirarPedido implements Runnable{
	private volatile boolean closeThread;
	
	private static PedidosDao repository;
	private static ArrayList<Pedido> fila;
	
	private Pedido pedido;
	
	@Override
	public void run() {
		while (!closeThread) {
            repository = PedidosDao.getInstance();
            fila = repository.getAll();
            this.start();
        }
	}
	
	public void start() {
		
	}
	
	public void shutdown() {
        closeThread = true;
    }
}
