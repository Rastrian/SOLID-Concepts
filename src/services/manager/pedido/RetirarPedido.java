package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.PedidosDao;
import profiles.Pedido;
import services.utils.UsuarioUtils;

public class RetirarPedido implements Runnable{
	private volatile boolean closeThread;
    
    private static PedidosDao repository;
	private static UsuarioUtils utils;
	
	@Override
	public void run() {
		while (!closeThread) {
            try {
                repository = PedidosDao.getInstance();
                utils = UsuarioUtils.getInstance();
			} catch (IOException e) {
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

        boolean exists = utils.getPedidos().contains(pedido);
        if (!exists){
            System.out.println("Este pedido não existe");
            shutdown();
            return;
        }

        if(pedido != null && pedido.getState() == 2) {
            repository.remove(pedido);
            pedido.setState(3);
            repository.add(pedido);
        }else {
        	System.out.println("Apenas é possível retirar pedido PRONTO");
        }
        shutdown();        
	}
	
	public void shutdown() {
        closeThread = true;
    }
}
