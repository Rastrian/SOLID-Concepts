package decorator;

public class PedidoGrande implements Pedido{
	int id;

	@Override
	public String getDesc() {
		return "Ramen Grande";
	}

	@Override
	public double getPreco() {
		return 15.90;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

}
