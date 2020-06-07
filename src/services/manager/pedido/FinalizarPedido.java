package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.PedidosDao;
import profiles.Pedido;

public class FinalizarPedido implements Runnable{
	private volatile boolean closeThread;
    
    private static PedidosDao repository;
	
	
	@Override
	public void run() {
		while (!closeThread) {
            try {
				repository = PedidosDao.getInstance();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.start();
        }		
	}
	
	public void start() {
		Thread t = null;
		ListarPedidos listarPedido = new ListarPedidos();
    	t = new Thread(listarPedido);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nDigite o código do pedido");
        Integer output = null;
        while(output == null) {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Insira um formato valido");
            }
        }
        Pedido pedido = repository.get(output); 
        if(pedido != null && pedido.getState() == 1) {
        	pedido.setState(1);
        }else {
        	System.out.println("Apenas é possível finalizar um pedido PREPARANDO");
        }
        repository.update(pedido);
        System.out.println(pedido.getState());
        shutdown();        
	}
	
	public void shutdown() {
        closeThread = true;
    }

}
