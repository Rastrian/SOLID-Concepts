package decorator;

public abstract class PedidoDecorator extends Pedido{
	protected Pedido decoratedPedido;
    public PedidoDecorator(Pedido decoratedPedido) {
          super();
          this.decoratedPedido = decoratedPedido;
    }
    
    abstract public String getDescricao(int tipo);
}
