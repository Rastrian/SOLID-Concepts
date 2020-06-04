package decorator;

public class Tamanho extends Pedido{
	String tamanho_descricao[] = {"Ramen Pequeno", "Ramen Medio", "Ramen Grande"};
	double tamanho_preco[] = {9.90, 12.90, 15.90};
	
	public Tamanho(int tipo) {
		pedido = tamanho_descricao[tipo];
	}

	@Override
	public double getPreco(int tipo) {
		// TODO Auto-generated method stub
		return tamanho_preco[tipo];
	}

}
