package services.utils;

import java.util.ArrayList;

import profiles.Pedido;

public class UsuarioUtils {
    private static Integer lastUserId;
    private static ArrayList<Pedido> pedidos;
	private static UsuarioUtils instance = null;

    private UsuarioUtils() {}
    
    public static UsuarioUtils getInstance() {
        if (instance == null) {
            instance = new UsuarioUtils();
            generateUserId();
        }
        return instance;
    }

    public void addPedido(Pedido pedido){
        if (pedido != null)
            pedidos.add(pedido);
    }

    private static void generateUserId() {
        if (lastUserId.equals(null))
            lastUserId = (int)(Math.random() * (Integer.MAX_VALUE + 1));
    }

    public static void setUserId(Object i){
        lastUserId = (Integer) i;
    }

    public Integer getUserId(){
        return lastUserId;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
}