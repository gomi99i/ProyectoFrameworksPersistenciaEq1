package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Productos;


public interface ProductosMapper {
	
	Integer nuevoProductoMarca(Productos producto); // crea un producto
	Integer eliminarProductoPorId(Map<String, Integer> mapProducto); //Elimina un producto
	Integer cambiarProductoPorId(Productos producto); //actualiza el producto
	Productos obtenerProductoPorId(Map<String, Integer> mapProducto); // imprime un producto
	List<Productos> obtenerProductos(); // imprime todos los productos
}
