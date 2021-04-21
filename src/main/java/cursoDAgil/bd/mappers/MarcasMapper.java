package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marcas;

public interface MarcasMapper {
	//obtenerMarcas()
	//nuevaMarca(marca)
	//obtenerMarcaPorId(idMarca)
	//actualizarMarca(marca)
	//eliminarMarca(id)
	
	List <Marcas> listarTodasMarcas();
	Integer nuevaMarca(Marcas marca);
	Marcas obtenerMarcaPorId(Map<String, Integer> mapMarcas);
	Integer eliminarMarca(Map<String, Integer> mapMarca);
	Integer actualizarMarca(Marcas marca);
	
}