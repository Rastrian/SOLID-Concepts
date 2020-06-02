package main_service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.usuario.cliente.MenuCliente;
import services.usuario.administrador.MenuAdministrador;


public class MainService implements Runnable{
	private volatile boolean closeThread;
    private static boolean inUse;
    
	@Override
	public void run() {
		while (!closeThread) {
            this.InitDAO();
            this.start();
        }
		
	}

	private void start() {
		System.out.println("\nOpções:\n\n0 → Sair\n1 → Entrar como Cliente\n2 → Entrar como Administrador\n\nInsira a opção desejada:");
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
		if (output == 1) {
            inUse();
            System.out.println("Bem vindo, ao menu de Cliente.");
            MenuCliente menuAlunos = new MenuCliente();
            t = new Thread(menuAlunos);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
		if (output == 2) {
            inUse();
            System.out.println("Bem vindo, ao menu de Administrador.");
            MenuAdministrador menuAlunos = new MenuAdministrador();
            t = new Thread(menuAlunos);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inUse();
        }
	}

	private void InitDAO() {
		// TODO Auto-generated method stub
		
	}
	
	public void shutdown() {
        closeThread = true;
    }
	
	public void inUse(){
        if (inUse){
            inUse = false;
            return;
        }
        inUse = true;
    }
	
}
