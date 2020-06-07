package services.utils;

import java.util.ArrayList;
import java.util.EnumSet;

import enums.EstadoPedidos;
import profiles.Pedido;

import profiles.bebidas.KOCha;
import profiles.bebidas.OCha;
import profiles.bebidas.Refrigerante;

import profiles.carnes.Boi;
import profiles.carnes.Porco;
import profiles.carnes.Vegano;

import profiles.extras.Chilli;
import profiles.extras.CarneExtra;
import profiles.extras.CremeAlho;
import profiles.extras.Croutons;
import profiles.extras.Shitake;
import profiles.extras.Tofu;

import profiles.tamanho.PedidoGrande;
import profiles.tamanho.PedidoMedio;
import profiles.tamanho.PedidoPequeno;

public class PedidosUtils {
    public Pedido selecionaCarne(Pedido pedido, int carne) {
		switch (carne) {
		case 0:
			return new Vegano(pedido);
		case 1:
			return new Porco(pedido);
		case 2:
			return new Boi(pedido);
		default:
			return null;			
		}
	}
	
	public Pedido selecionaBebida(Pedido pedido, int bebida) {
		switch (bebida) {
		case 0:
			return new Refrigerante(pedido);
		case 1:
			return new OCha(pedido);
		case 2:
			return new KOCha(pedido);
		default:
			return null;			
		}
	}
	
	public Pedido selecionaExtra(Pedido pedido, int extra) {
		switch (extra) {
		case 0:
			return new CarneExtra(pedido);
		case 1:
			return new CremeAlho(pedido);
		case 2:
			return new Chilli(pedido);
		case 3:
			return new Croutons(pedido);
		case 4:
			return new Shitake(pedido);
		case 5:
			return new Tofu(pedido);
		default:
			return null;
		}
	}
	
	public Pedido selecionaTamanho(int tamanho) {
		switch (tamanho) {
		case 0:
			return new PedidoPequeno();
		case 1:
			return new PedidoMedio();
		case 2:
			return new PedidoGrande();
		default:
			return null;	
		}
	}

	public String getPedidoState(int id){
		ArrayList<EstadoPedidos> states = new ArrayList<EstadoPedidos>(EnumSet.allOf(EstadoPedidos.class));
		for (EstadoPedidos state : states){
			if (state.getValue().equals(id)){
				return state.getEstado(id);
			}
		}
		return null;
	}
}