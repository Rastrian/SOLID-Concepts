package decorator;

public class PedidoGrande implements Pedido{

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "Ramen Grande";
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 15.90;
	}

}
