package services.manager.observer;

import java.util.Observable;

import profiles.Pedido;

public class PedidosObservable extends Observable implements Pedido {
    int id;
    int state;

	@Override
	public String getDesc() {
		return "Ramen Grande";
	}

	@Override
	public double getPreco() {
		return 15.90;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getState() {
		return state;
	}

	@Override
	public void setState(int id) {
        this.state = id;
        notifyObservers("changeState");
    }
    
}