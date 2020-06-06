package decorator;

public class KOCha extends PedidoDecorator{

	public KOCha(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPedido.getDesc() + " + KO-Cha";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
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
}
