package decorator;

public class Vegano extends PedidoDecorator{

	public Vegano(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPedido.getDesc() + " + Vegana";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
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
}
