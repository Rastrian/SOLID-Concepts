package profiles;

import profiles.Pedido;

public class Pedidos implements Pedido{
	int id;
	int state;

	@Override
	public String getDesc() {
		return "";
	}

	@Override
	public double getPreco() {
		return 0.00;
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
