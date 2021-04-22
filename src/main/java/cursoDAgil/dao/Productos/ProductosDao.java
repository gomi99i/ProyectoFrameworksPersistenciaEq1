package cursoDAgil.dao.Productos;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Productos;

public interface ProductosDao {
	Integer nuevoProductoMarca(Productos producto); // crea un producto
	Integer eliminarProductoPorId(Map<String, Integer> mapProducto); //Elimina un producto
	Integer cambiarProductoPorId(Productos producto, Integer id); //actualiza el producto
	Productos obtenerProductoPorId(Map<String, Integer> mapProducto); // imprime un producto
	List<Productos> obtenerProductos(); // imprime todos los productos
}
