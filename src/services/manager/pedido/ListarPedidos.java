package services.manager.pedido;

import java.io.IOException;
import java.util.ArrayList;

import dao.PedidosDao;
import profiles.Pedido;
import services.utils.PedidosUtils;
import services.utils.UsuarioUtils;

public class ListarPedidos implements Runnable{
	private volatile boolean closeThread;

    private Integer userId;

    private UsuarioUtils utils;
    private PedidosUtils utilsPedido;
    private static PedidosDao repository;
	private static ArrayList<Pedido> pedidos;

    @Override
    public void run() {
		while (!closeThread) {
            try {
            	utils = UsuarioUtils.getInstance();
                repository = PedidosDao.getInstance();
                utilsPedido = PedidosUtils.getInstance();
			} catch (IOException e) {
				e.printStackTrace();
			}
            this.start();
        }	
    }

    private void start() {
        userId = utils.getUserId();
        if (userId == null){
            pedidos = repository.getAll();
            pedidos.forEach(p -> {
                System.out.println("\nID: "+ p.getId() + "\n" +
                "Descrição: " + p.getDesc() + "\n" +
                "Preço: "+ p.getPreco() + "\n" +
                "Estado: "+ utilsPedido.getPedidoState(p.getState()));
            });
            shutdown();
            return;
        }
        pedidos = utils.getPedidos();
        pedidos.forEach(p -> {
            System.out.println("\nID: "+ p.getId() + "\n" +
            "Descrição: " + p.getDesc() + "\n" +
            "Preço: "+ p.getPreco() + "\n" +
            "Estado: "+ utilsPedido.getPedidoState(p.getState()));
        });
        shutdown();
    }
    public void shutdown() {
        closeThread = true;
    }


}