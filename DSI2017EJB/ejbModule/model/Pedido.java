package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PedidoId")
	private List<ItemPedido> colItensPedido =
			new ArrayList<ItemPedido>();
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	private Cliente cliente;
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getColItensPedido() {
		return colItensPedido;
	}

	public void setColItensPedido(List<ItemPedido> colItensPedido) {
		this.colItensPedido = colItensPedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
