package profiles.bebidas;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class OCha extends PedidoDecorator{
	public OCha(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + O-Cha(Verde)";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 3.90;
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
