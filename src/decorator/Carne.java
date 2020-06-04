package decorator;

public class Carne extends PedidoDecorator{
	String carne_descricao[] = {"Vegano", "Porco", "Boi"};
	double carne_preco[] = {3.90, 5.90, 7.90};

	public Carne(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double getPreco(int tipo) {
		// TODO Auto-generated method stub
		return carne_preco[tipo];
	}

	@Override
	public String getDescricao(int tipo) {
		// TODO Auto-generated method stub
		return carne_descricao[tipo];
	}

}
