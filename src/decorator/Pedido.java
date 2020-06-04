package decorator;

public abstract class Pedido {
	protected String pedido;

    protected Pedido(){
        pedido = "";
    }
    
    abstract public double getPreco(int tipo);
}
