package cursoDAgil.dao.productos;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.dao.productos.ProductosDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ProductoDaoImplTest {

	@Inject
	ProductosDao productosDao;
	
	@Ignore
	public void consultarProductoPorId(){
		System.out.println("----------------Teste consultar por ID -----------------------");
		Productos productos = new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto",1);
		try{
			productos=productosDao.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			System.out.println("id:" + productos.getIdProducto());
			System.out.println("nombre del producto:" + productos.getNombre());
			System.out.println("Precio: $" + productos.getPrecio());
			System.out.println("PrecioVta: $" + productos.getPrecioVta());
			System.out.println("cantidad:" + productos.getCantidad());
			System.out.println("marca: " + productos.getMarcas().getNombreMarca());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void pruebaConsultarTodo(){
		System.out.println("----------------Test consultar todo -----------------------");
		int reg;
		System.out.println("Test consultar todas los productos");
		try{
			List<Productos> lista = productosDao.obtenerProductos();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nNumero de Registros en la tabla: " + reg);
			for(Productos productos : lista){
				System.out.println("id:" + productos.getIdProducto());
				System.out.println("nombre del producto:" + productos.getNombre());
				System.out.println("Precio: $" + productos.getPrecio());
				System.out.println("PrecioVta: $" + productos.getPrecioVta());
				System.out.println("cantidad:" + productos.getCantidad());
				System.out.println("marca: " + productos.getMarcas().getNombreMarca());
				System.out.println();
			}
		}catch(Exception ex){
			System.out.println("error" + ex);

		}
	}
	
	@Ignore
	public void CambiarProducto(){
		Productos productos= new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		Integer CambiarId = 3; //Id del producto que quieres cambiar
		System.out.println("----------------Test cambiar Producto -----------------------");
		try{
			mapProducto.put("idProducto",CambiarId);
			productos=productosDao.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			
			//datos que quieres cambiar al producto
			productos.setNombre("Crema");
			productosDao.cambiarProductoPorId(productos, CambiarId);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void nuevoRegistro(){
		Productos productos= new Productos();
		System.out.println("----------------Test Nuevo Producto -----------------------");
		try{
			productos.setNombre("manteca");
			productos.setPrecio(30.0);
			productos.setPrecioVta(33.0);
			productos.setCantidad(1);
			productos.setMarcaId(3);
			productosDao.nuevoProductoMarca(productos);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarRegistro(){
		Productos productos = new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		mapProducto.put("idProducto",15);
		System.out.println("----------------Test Eliminar Producto -----------------------");
		try{
			productos=productosDao.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			productosDao.eliminarProductoPorId(mapProducto);
			System.out.println("Producto eliminado correctamente");
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}















