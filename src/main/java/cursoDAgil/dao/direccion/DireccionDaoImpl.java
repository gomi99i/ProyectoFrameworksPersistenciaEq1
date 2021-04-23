package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class DireccionDaoImpl implements DireccionDao {

	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Direccion creada con éxito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Direccion> obtenerDirecciones() {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);

			return direccionMapper.obtenerDirecciones();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarDireccion(Map<String, Integer> mapDireccion) {
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Registro eliminado");
			return direccionMapper.eliminarDireccion(mapDireccion);
		}catch (Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer cambiarDireccion(Direccion direccion, Integer id) {
		try{
			DireccionMapper direccionMapper =sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Registro actualizado");
			direccion.setIdDireccion(id);
			return direccionMapper.cambiarDireccion(direccion);
		}catch (Exception e){
			System.out.println("Error" + e);
		}
		return null;
	}

	
	
}
