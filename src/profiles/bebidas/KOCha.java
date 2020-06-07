package profiles.bebidas;

import profiles.PedidoDecorator;
import profiles.Pedido;

public class KOCha extends PedidoDecorator{

	public KOCha(Pedido decoratedPedido) {
		super(decoratedPedido);
	}

	@Override
	public String getDesc() {
		return decoratedPedido.getDesc() + " + KO-Cha";
	}

	@Override
	public double getPreco() {
		return decoratedPedido.getPreco() + 0;
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
