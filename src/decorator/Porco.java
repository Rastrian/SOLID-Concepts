package decorator;

public class Porco extends PedidoDecorator{

	public Porco(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPedido.getDesc() + " + de Porco";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
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

}
