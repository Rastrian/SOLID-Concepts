package decorator;

public class PedidoMedio implements Pedido{

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "Ramen Medio";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 12.90;
	}

}
