package services.usuario.administrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.MainService;
import services.manager.pedido.AceitarPedido;
import services.manager.pedido.CriarPedido;
import services.manager.pedido.FinalizarPedido;
import services.manager.pedido.NegarPedido;
import services.utils.UsuarioUtils;

public class MenuAdministrador extends MainService{
	private volatile boolean closeThread;
    private static boolean inUse;
    
	@Override
	public void run() {
		 while (!closeThread) {
            this.start();
         }
	}
	
	public void start() {		
		UsuarioUtils instance = UsuarioUtils.getInstance();
		instance.setUserId(null);

		System.out.println("\nOpções:\n\n0 → Sair.\n1 → Aceitar pedido.\n2 → Finalizar pedido.\n3 → Negar pedido.\n4 → Acessar balanço."
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
        	AceitarPedido aceitarPedido = new AceitarPedido();
        	t = new Thread(aceitarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
        
        if(output == 2) {
        	FinalizarPedido finalizarPedido = new FinalizarPedido();
        	t = new Thread(finalizarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
        
        if(output == 3) {
        	NegarPedido negarPedido = new NegarPedido();
        	t = new Thread(negarPedido);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
        
        if(output == 4) {
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
