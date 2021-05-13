package cursoDAgil.dao.detalleventas;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Detalleventas;
import cursoDAgil.bd.mappers.DetalleventasMapper;

@Named

public class DetalleventasDaoImpl implements DetalleventasDao {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Detalleventas> mostrarDetallesVenta(Map<String, Integer> mapDetalleVentas){
		List<Detalleventas> list = null;
		try{
			DetalleventasMapper detalleventaMapper = sqlSession.getMapper(DetalleventasMapper.class);
			list = detalleventaMapper.mostrarDetallesVentas(mapDetalleVentas);
			System.out.println("Detalles de la venta.\n");
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override 
	public Integer nuevoDetalleVenta(Detalleventas detalleventas){
		try{
			DetalleventasMapper detalleventaMapper = sqlSession.getMapper(DetalleventasMapper.class);
			return detalleventaMapper.nuevoDetalleVenta(detalleventas);
			
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}	
		return null;
	}

	
}
