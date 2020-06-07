package profiles.extras;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class Chilli extends PedidoDecorator{

	public Chilli(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + Chilli";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 2.5;
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
