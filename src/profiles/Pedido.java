package profiles;

public interface Pedido {
	public int getId();
	public int getState();
	public void setId(int id);
	public void setState(int id);
	public String getDesc();
	public double getPreco();
}
