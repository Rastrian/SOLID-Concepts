package enums;

public enum EstadoPedidos {
    CANCELADO(-1), AGUARDANDO(0), PREPARANDO(1), PRONTO (2), ENTREGUE(3);

    private Integer value;

    EstadoPedidos(Integer opt) {
        value = opt;
    }

    public Integer getValue(){
        return value;
    }

	public String getEstado(int opt) {
        value = opt;
		return this.name();
	}
}