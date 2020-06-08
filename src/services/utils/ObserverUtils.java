package services.utils;

import profiles.Pedido;
import services.manager.observer.PedidosObservable;
import services.manager.observer.PedidosObserver;

public class ObserverUtils {
    private static ObserverUtils instance = null;
    
    public static ObserverUtils getInstance() {
        if (instance == null) {
            instance = new ObserverUtils();
        }
        return instance;
    }

    public Pedido setState(int state, Pedido pedido) {
        PedidosObservable observavel = new PedidosObservable();
        PedidosObserver observador = new PedidosObserver();

        observavel.addObserver(observador);
        observavel.setState(state);
        pedido.setState(state);
        System.out.println("O estado do pedido #"+pedido.getId()+" é: "+ PedidosUtils.getInstance().getPedidoState(observavel.getState()));
        return pedido;
    }
}