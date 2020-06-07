package profiles.tamanho;

import profiles.Pedido;

public class PedidoGrande implements Pedido{
	int id;
	
	int state;

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

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public void setState(int id) {
		this.state = id;		
	}

}
