package profiles.extras;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class Shitake extends PedidoDecorator{

	public Shitake(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + Shitake";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 6.9;
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
