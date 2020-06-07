package profiles.bebidas;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class Refrigerante extends PedidoDecorator{

	public Refrigerante(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + Refrigerante";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 5.9;
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
