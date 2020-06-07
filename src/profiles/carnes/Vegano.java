package profiles.carnes;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class Vegano extends PedidoDecorator{

	public Vegano(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + Vegana";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 3.9;
	}

	@Override
	public int getId() {
		return decoratedPedido.getId();
	}

	@Override
	public void setId(int id) {
		decoratedPedido.setId(id);
	}
	
	@Override
	public int getState() {
		return decoratedPedido.getState();
	}

	@Override
	public void setState(int id) {
		decoratedPedido.setState(id);		
	}
}
