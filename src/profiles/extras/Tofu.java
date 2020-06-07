package profiles.extras;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class Tofu extends PedidoDecorator{

	public Tofu(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + Tofu";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 2.70;
	}
	
	@Override
	public int getId() {
		return decoratedPedido.getId();
	}

	@Override
	public void setId(int id) {
		decoratedPedido.setId(id);
	}

}
