package profiles.tamanho;

import profiles.Pedido;

public class PedidoPequeno implements Pedido{
	int id;
	int state;
	
	@Override
	public String getDesc() {
		return "Ramen Pequeno";
	}

	@Override
	public double getPreco() {
		return 9.90;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getState() {
		return state;
	}

	@Override
	public void setState(int id) {
		this.state = id;		
	}
}
