package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.PedidosDao;
import decorator.Pedido;
import decorator.Tamanho;

public class CriarPedido implements Runnable{
	private volatile boolean closeThread;
	
	private static PedidosDao repository;
	private Pedido pedido;

	@Override
	public void run() {
		while (!closeThread) {
            repository = PedidosDao.getInstance();
            this.start();
        }		
	}
	
	public void start() {
		Integer id = null;
		Integer output = null;
        System.out.println("Opções de tamanho: \\n\\n0 → Pequeno.\\n1 → Medio.\\n2 → Grande \n\nSelecione o tamanho do Ramen: ");
        while(output == null) {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e ) {
                System.out.println("Insira um formato valido");
            }
        }
        
        pedido = new Tamanho(0);
        
	}
	
	public void shutdown() {
        closeThread = true;
    }
}
