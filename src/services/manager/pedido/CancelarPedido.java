package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.PedidosDao;
import profiles.Pedido;
import services.utils.ObserverUtils;
import services.utils.UsuarioUtils;

public class CancelarPedido implements Runnable {
	private volatile boolean closeThread;
    
    private static PedidosDao repository;
    private static UsuarioUtils utils;
    private static Integer userId;
	private static ObserverUtils utilsOB;
	
	@Override
	public void run() {
		while (!closeThread) {
            try {
                repository = PedidosDao.getInstance();
                utils = UsuarioUtils.getInstance();
                utilsOB = ObserverUtils.getInstance();
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

        userId = utils.getUserId();
        Pedido pedido = repository.get(output); 

        if (userId != null){
            boolean exists = utils.getPedidos().contains(pedido);
            if (!exists){
                System.out.println("Este pedido não existe");
                shutdown();
                return;
            }
        }

        if (pedido != null && pedido.getState() == 0) {
            repository.remove(pedido);
            utilsOB.setState(-1, pedido);
            repository.add(pedido);
        }else {
        	System.out.println("Apenas é possível negar pedido em análise");
        }
        shutdown();        
	}
	
	public void shutdown() {
        closeThread = true;
    }

}
