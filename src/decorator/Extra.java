package decorator;

public class Extra extends PedidoDecorator{
	String extra_descricao[] = {"Carne Extra", "Creme Alho", "Chilli", "Croutons", "Shitake"};
	double extra_preco[] = {4, 1.5, 2.5, 2, 6.90, 2.7};
	
	public Extra(Pedido decoratedPedido) {
		super(decoratedPedido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescricao(int tipo) {
		// TODO Auto-generated method stub
		return extra_descricao[tipo];
	}

	@Override
	public double getPreco(int tipo) {
		// TODO Auto-generated method stub
		return extra_preco[tipo];
	}

}
