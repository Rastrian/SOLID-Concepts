package decorator;

public class PedidoPequeno implements Pedido{

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "Ramen Pequeno";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 9.90;
	}

}
