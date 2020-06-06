package services.manager.pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import dao.PedidosDao;
import decorator.*;

public class CriarPedido implements Runnable{
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
	
	@SuppressWarnings("null")
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
        pedido = this.selecionaTamanho(output);
        
        //Carne
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
        pedido = selecionaCarne(pedido, output);
        
        //Extras
        output = null;        
        while(output == null || output != 10) {
        	System.out.println("Extras: \n\n0 → Carne extra.\n1 → Creme Alho.\n2 → Chilli \n3 → Croutons"+
                    "\n5 → Shitake \n5 → Tofu \n\nSelecione a opção de extras ou 10 para sair: ");
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                output = Integer.parseInt(br.readLine());
                if(output != 10) {
                	pedido = selecionaExtra(pedido, output);
                }
            } catch (NumberFormatException | IOException e ) {
                System.out.println("Insira um formato valido");
            }
        }
        
        //Refrigerante
		output = null;
		while(output == null || output != 10) {
			System.out.println("Bebida: \n\n0 → Refrigerante.\n1 → O-Cha(Verde).\n2 → KO-Cha(Preto) \n\nSelecione a opção de extras ou 10 para sair: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				output = Integer.parseInt(br.readLine());
	            if(output != 10) {
	            	pedido = selecionaBebida(pedido, output);
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
		
		repository.add(pedido);
		System.out.println("\nInformações sobre o curso:\nID: " + pedido.getId() + "\nDescricao: " + pedido.getDesc()+ "\nValor: R$" + pedido.getPreco());
        shutdown();
	}
	
	public Pedido selecionaCarne(Pedido pedido, int carne) {
		switch (carne) {
		case 0:
			return new Vegano(pedido);
		case 1:
			return new Porco(pedido);
		case 2:
			return new Boi(pedido);
		default:
			return null;			
		}
	}
	
	public Pedido selecionaBebida(Pedido pedido, int bebida) {
		switch (bebida) {
		case 0:
			return new Refrigerante(pedido);
		case 1:
			return new OCha(pedido);
		case 2:
			return new KOCha(pedido);
		default:
			return null;			
		}
	}
	
	public Pedido selecionaExtra(Pedido pedido, int extra) {
		switch (extra) {
		case 0:
			return new CarneExtra(pedido);
		case 1:
			return new CremeAlho(pedido);
		case 2:
			return new Chilli(pedido);
		case 3:
			return new Croutons(pedido);
		case 4:
			return new Shitake(pedido);
		case 5:
			return new Tofu(pedido);
		default:
			return null;
			
		}
	}
	
	public Pedido selecionaTamanho(int tamanho) {
		switch (tamanho) {
		case 0:
			return new PedidoPequeno();
		case 1:
			return new PedidoMedio();
		case 2:
			return new PedidoGrande();
		default:
			return null;
			
		}
	}
	
	public void shutdown() {
        closeThread = true;
    }
}
