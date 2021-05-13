package cursoDAgil.bd.domain;

import java.util.ArrayList;
import java.util.List;

public class Ventas {
	private Integer idVenta;
	private Integer clienteId;
	private Double totalVenta;
	private String  fecha;
	
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clietneId) {
		this.clienteId = clietneId;
	}
	public Double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	private Cliente cliente;
	private List<Productos> productos;
	
	public Ventas(){
		setCliente(new Cliente());
		setProductos(new ArrayList<Productos>());
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Productos> getProducto() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	
}
