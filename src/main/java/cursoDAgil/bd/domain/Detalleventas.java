package cursoDAgil.bd.domain;

public class Detalleventas {
	private Integer ventaId;
	private Integer productoId;
	private Integer cantidad;
	
	public Detalleventas(){
		this.setProductos(new Productos());
	}
	
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

	private Productos productos;
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
}
