package profiles;

public abstract class PedidoDecorator implements Pedido{
	protected Pedido decoratedPedido;
    public PedidoDecorator(Pedido decoratedPedido) {
          super();
          this.decoratedPedido = decoratedPedido;
    }
}
