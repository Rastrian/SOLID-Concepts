package services.utils;

import java.util.ArrayList;

import profiles.Pedido;

public class UsuarioUtils {
    private static Integer lastUserId;
    private static ArrayList<Pedido> pedidos; 
    private static UsuarioUtils instance = null;

    private UsuarioUtils() {
        pedidos = new ArrayList<Pedido>();
        generateUserId();
    }
    
    public static UsuarioUtils getInstance() {
        if (instance == null) {
            instance = new UsuarioUtils();
        }
        return instance;
    }

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    private void generateUserId() {
        if (lastUserId == null)
            lastUserId = (int)(Math.random() * (Integer.MAX_VALUE + 1));
    }

    public void setUserId(Object i){
        lastUserId = (Integer) i;
    }

    public Integer getUserId(){
        return lastUserId;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
}