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
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
                System.out.println("ID: "+ p.getId() +
                "- Descrição: " + p.getDesc() +
                "- Preço: "+ p.getPreco() +
                "- "+ utilsPedido.getPedidoState(p.getState()));
            });
            return;
        }
        pedidos = utils.getPedidos();
        pedidos.forEach(p -> {
            System.out.println("ID: "+ p.getId() +
            "- Descrição: " + p.getDesc() +
            "- Preço: "+ p.getPreco() +
            "- "+ utilsPedido.getPedidoState(p.getState()));
        });
        shutdown();
    }
    public void shutdown() {
        closeThread = true;
    }


}