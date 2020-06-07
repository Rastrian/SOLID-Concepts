package services.usuario.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.MainService;
import services.manager.pedido.CancelarPedido;
import services.manager.pedido.CriarPedido;
import services.manager.pedido.ListarPedidos;
import services.manager.pedido.RetirarPedido;
import services.utils.UsuarioUtils;

public class MenuCliente extends MainService{
	private volatile boolean closeThread;
    private static boolean inUse;
    
    @Override
    public void run() {
        while (!closeThread) {
            this.start();
        }
    }

    public void start() {
        UsuarioUtils.getInstance();
		System.out.println("\nOpções:\n\n0 → Sair.\n1 → Fazer pedido.\n2 → Retirar pedido.\n3 → Listar pedidos.\n4 → Cancelar pedido."
                + "\n\nInsira a opção desejada:");
        Integer output = null;
        while (output == null) {
            if (!inUse) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    output = Integer.parseInt(br.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Insira um formato valido");
                }
            }
        }
        Thread t = null;
        if (output == 0) {
            shutdown();
            return;
        }
        
        if (output != null){
            inUse();
        } 
        
        if(output == 1) {
        	CriarPedido criarPedido = new CriarPedido();
        	t = new Thread(criarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
        
        if(output == 2) {
        	RetirarPedido rPedido = new RetirarPedido();
        	t = new Thread(rPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
        
        if(output == 3) {
        	ListarPedidos listarPedido = new ListarPedidos();
        	t = new Thread(listarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }

        if(output == 4) {
        	CancelarPedido cancelarPedido = new CancelarPedido();
        	t = new Thread(cancelarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
	}
	
	public void inUse(){
        if (inUse){
            inUse = false;
            return;
        }
        inUse = true;
    }
	
	public void shutdown() {
        closeThread = true;
    }
	
}
