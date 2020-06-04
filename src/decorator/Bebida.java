package decorator;

public class Bebida extends PedidoDecorator{
	String bebida_descricao[] = {"Refrigerante", "O-cha(Verde)", "KO-cha(Preto)"};
	double bebida_preco[] = {5.90, 3.90, 0};

	public Bebida(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPreco(int tipo) {
		// TODO Auto-generated method stub
		return bebida_preco[tipo];
	}

	@Override
	public String getDescricao(int tipo) {
		// TODO Auto-generated method stub
		return bebida_descricao[tipo];
	}
}
