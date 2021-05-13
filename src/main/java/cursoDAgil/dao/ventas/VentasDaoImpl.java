package cursoDAgil.dao.ventas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cursoDAgil.bd.domain.Detalleventas;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.bd.mappers.VentasMapper;
import cursoDAgil.dao.detalleventas.DetalleventasDao;
import cursoDAgil.dao.ganancias.GananciasDao;
import cursoDAgil.dao.productos.ProductosDao;

@Named

public class VentasDaoImpl implements VentasDao {
	
	@Inject
	DetalleventasDao detalleventasDao;
	@Inject
	ProductosDao productosDao;
	@Inject
	GananciasDao gananciasDao;
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Ventas> consultarVentaPorCliente(Map<String,Integer> mapVentas){
		List<Ventas> list = null;
		try{
			VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			list = ventasMapper.consultarVentaPorCliente(mapVentas);
            System.out.println("Consulta de Venta por Cliente. ");
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	 @Override
		public List<Ventas> consultarTodasVentas() {
			// TODO Auto-generated method stub
		 List<Ventas> list = null;
			try{
				VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
	            list = ventasMapper.consultarTodasVentas();
	            System.out.println("Consulta de Todas las ventas exitosa. ");
	            return list;
			}catch(Exception e){
				System.out.println("Error: " + e );
			}
			return null;
		} 

	 @Transactional
	 @Override
	 public Integer nuevaVenta(Ventas venta){
		 try{
			 Double gananciaTotal = 0.0;
			 Double totalvta = 0.0;
			 VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			 ventasMapper.nuevaVenta(venta);
			 
			 Integer idVenta = venta.getIdVenta();
			 
			 List<Productos> productos = venta.getProducto();
			 Ganancias ganancias = new Ganancias();
			 ganancias.setVentaId(idVenta);
			 for(Productos productovta:productos){
				 Detalleventas detalleventa = new Detalleventas();
				 detalleventa.setVentaId(idVenta);
				 detalleventa.setProductoId(productovta.getIdProducto());
				 detalleventa.setCantidad(productovta.getCantidad());
				 
				 Productos productoinv = new Productos();

				 Map<String, Integer> mapProducto = new HashMap<>();
				 mapProducto.put("idProducto", productovta.getIdProducto());
				 productoinv = productosDao.obtenerProductoPorId(mapProducto);
				 productoinv.setCantidad(productoinv.getCantidad()-productovta.getCantidad());
				 if(productoinv.getCantidad() >=0){
					 productosDao.cambiarProductoPorId(productoinv, productoinv.getIdProducto());
					 gananciaTotal+=productovta.getCantidad()*(productovta.getPrecioVta()-productovta.getPrecio());
					 totalvta+=productovta.getCantidad()*productovta.getPrecioVta();
					 detalleventasDao.nuevoDetalleVenta(detalleventa);
				 }else{
					System.out.println("No hay suficiente inventario."); 
				 }	
			 }
			 venta.setTotalVenta(totalvta);
			 ventasMapper.actualizaVenta(venta); 
			 ganancias.setTotalGanancia(gananciaTotal);
			 ganancias.setFecha(venta.getFecha());
			 gananciasDao.nuevaGanancia(ganancias);
			 return 1;
		 }catch(Exception e){
			 System.out.println("Error: " + e);
		 }
		 return null;
	 }

	 

	 @Override
	 public Integer actualizaVenta(Ventas venta){
		 try{
			 VentasMapper ventasMapper = sqlSession.getMapper(VentasMapper.class);
			 return ventasMapper.actualizaVenta(venta);
		 }catch(Exception e){
			 System.out.println("Error: " + e);
		 }
		 return null;
	 }
}
