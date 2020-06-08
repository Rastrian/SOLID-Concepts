package services.manager.observer;

import java.util.Observable;
import java.util.Observer;

public class PedidosObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        this.setState((int) arg);
    }

    private void setState(int state) {}
}