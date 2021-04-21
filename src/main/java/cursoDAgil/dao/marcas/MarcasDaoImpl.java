package cursoDAgil.dao.marcas;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.bd.mappers.MarcasMapper;

@Named
public class MarcasDaoImpl implements MarcasDao {
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Marcas> listarTodasMarcas() {
		try {
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			return marcasMapper.listarTodasMarcas();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaMarca(Marcas marca) {
		try {
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			System.out.println("Marca creada con éxito");
			return marcasMapper.nuevaMarca(marca);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Marcas obtenerMarcaPorId(Map<String, Integer> mapMarcas) {
		try {
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			return marcasMapper.obtenerMarcaPorId(mapMarcas);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Integer actualizarMarca(Marcas marca) {
		try {
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			System.out.println("Marca actualizada con éxito");
			return marcasMapper.actualizarMarca(marca);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarMarca(Map<String, Integer> mapMarca) {
		try {
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			System.out.println("Marca eliminada con éxito");
			return marcasMapper.eliminarMarca(mapMarca);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

}