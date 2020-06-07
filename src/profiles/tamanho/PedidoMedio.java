package profiles.tamanho;

import profiles.Pedido;

public class PedidoMedio implements Pedido{
	int id;

	@Override
	public String getDesc() {
		return "Ramen Medio";
	}

	@Override
	public double getPreco() {
		return 12.90;
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
