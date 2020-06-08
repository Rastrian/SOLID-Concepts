package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import dao.PedidosDao;

import profiles.Pedido;
import services.utils.ObserverUtils;
import services.utils.PedidosUtils;
import services.utils.UsuarioUtils;

public class CriarPedido implements Runnable{
	private volatile boolean closeThread;
	
	private static PedidosDao repository;
	private static ArrayList<Pedido> fila;

	private static PedidosUtils utils;
	private static UsuarioUtils utilsUsuario;
	private static ObserverUtils utilsOB;
	
	private Pedido pedido;

	@Override
	public void run() {
		while (!closeThread) {
			try {
				utilsUsuario = UsuarioUtils.getInstance();
				utilsOB = ObserverUtils.getInstance();
				repository = PedidosDao.getInstance();
			} catch (IOException e) {
				e.printStackTrace();
			}
			utils = PedidosUtils.getInstance();
            fila = repository.getAll();
            this.start();
        }		
	}
	
	public void start() {
		Integer output = null;
		
        System.out.println("Opções de tamanho: \n\n0 → Pequeno.\n1 → Medio.\n2 → Grande \n\nSelecione o tamanho do Ramen: ");
        while(output == null || (output != 0 && output != 1 && output != 2)) {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e ) {
                System.out.println("Insira um formato valido");
            }
        }
        pedido = utils.selecionaTamanho(output);
        
        System.out.println("Opções de carne: \n\n0 → Vegano.\n1 → Porco.\n2 → Boi \n\nSelecione a carne do Ramen: ");
        output = null;
        while(output == null || (output != 0 && output != 1 && output != 2)) {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e ) {
                System.out.println("Insira um formato valido");
            }
        }        
        pedido = utils.selecionaCarne(pedido, output);
        
        output = null;        
        while(output == null || output != 10) {
        	System.out.println("Extras: \n\n0 → Carne extra.\n1 → Creme Alho.\n2 → Chilli \n3 → Croutons"+
                    "\n4 → Shitake \n5 → Tofu \n\nSelecione a opção de extras ou INSIRA 10 PARA CONTINUAR: ");
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
                if(output != 10) {
                	pedido = utils.selecionaExtra(pedido, output);
                }
            } catch (NumberFormatException | IOException e ) {
                System.out.println("Insira um formato valido");
            }
        }
        
		output = null;
		while(output == null || output != 10) {
			System.out.println("Bebida: \n\n0 → Refrigerante.\n1 → O-Cha(Verde).\n2 → KO-Cha(Preto) \n\nSelecione a opção de extras ou INSIRA 10 PARA CONTINUAR: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				output = Integer.parseInt(br.readLine());
	            if(output != 10) {
	            	pedido = utils.selecionaBebida(pedido, output);
	            }
			 } catch (NumberFormatException | IOException e ) {
			    System.out.println("Insira um formato valido");
			 }
		}
		
		if(fila.isEmpty()) {
			pedido.setId(1);
		}else {
			Pedido lastInserted = fila.get(fila.size()-1);
			pedido.setId(lastInserted.getId()+1);
		}
		
		utilsOB.setState(0, pedido);

		repository.add(pedido);
		utilsUsuario.addPedido(pedido);
		System.out.println("\nInformações sobre o pedido:\nID: " + pedido.getId() + "\nDescricao: " + pedido.getDesc()+ "\nValor: R$" + pedido.getPreco());
        shutdown();
	}
	
	public void shutdown() {
        closeThread = true;
    }
}
