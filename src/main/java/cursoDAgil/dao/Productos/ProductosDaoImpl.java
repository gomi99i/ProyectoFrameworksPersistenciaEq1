package cursoDAgil.dao.Productos;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.mappers.ProductosMapper;

@Named
public class ProductosDaoImpl implements ProductosDao{
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public Integer nuevoProductoMarca(Productos producto) {
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("producto creada con éxito");			
			return productoMapper.nuevoProductoMarca(producto);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
	@Override
	public Integer eliminarProductoPorId(Map<String, Integer> mapDireccion) {
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("producto Eliminado con éxito");			
			return productoMapper.eliminarProductoPorId(mapDireccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Integer cambiarProductoPorId(Productos producto, Integer id){
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			System.out.println("producto cambiado con éxito");	
			producto.setIdProducto(id); // en el caso de que se cambio el ID
			return productoMapper.cambiarProductoPorId(producto);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
	@Override
	public Productos obtenerProductoPorId(Map<String, Integer> mapDireccion)
	{
		try{
			ProductosMapper direccionMapper = sqlSession.getMapper(ProductosMapper.class);
			return direccionMapper.obtenerProductoPorId(mapDireccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public List<Productos> obtenerProductos() {
		try{
			ProductosMapper ProductoMapper = sqlSession.getMapper(ProductosMapper.class);
			return ProductoMapper.obtenerProductos();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	return null;
	}
}
