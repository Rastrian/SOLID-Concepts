package services.manager.balanco;

import java.io.IOException;
import java.util.ArrayList;

import dao.PedidosDao;
import profiles.Pedido;
import services.utils.UsuarioUtils;

public class SaldoBalanco implements Runnable {
	private volatile boolean closeThread;

    private Integer userId;
    private Double balanco;

    private UsuarioUtils utils;
    private static PedidosDao repository;
	private static ArrayList<Pedido> pedidos;

    @Override
    public void run() {
		while (!closeThread) {
            try {
            	utils = UsuarioUtils.getInstance();
                repository = PedidosDao.getInstance();
			} catch (IOException e) {
				e.printStackTrace();
			}
            this.start();
        }	
    }

    private void start() {
        userId = utils.getUserId();
        if (userId == null){
            balanco = 0.00;
            pedidos = repository.getAll();
            pedidos.forEach(p -> {
                if (p.getState() == 2 || p.getState() == 3){
                    balanco += p.getPreco();
                }
            });
            System.out.println("O seu balanço é de "+balanco+" R$.");
        }
        shutdown();
    }

    public void shutdown() {
        closeThread = true;
    }


}