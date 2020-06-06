package decorator;

public class Tofu extends PedidoDecorator{

	public Tofu(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPedido.getDesc() + " + Tofu";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
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
