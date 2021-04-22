package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionDao {
	List<Direccion> obtenerDirecciones(); //listar las direcciones
	Integer nuevaDireccionCliente(Direccion direccion); //crea una direccion
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion); //obtiene una direccion por id
	Integer eliminarDireccion(Map<String, Integer> mapDireccion); // Eliminar una direccion
	Integer cambiarDireccion(Direccion direccion, Integer id);//Cambiar direccion
}
