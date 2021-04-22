package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionMapper {
	List<Direccion> obtenerDirecciones(); //listar las direcciones
	Integer nuevaDireccionCliente(Direccion direccion); //Insertar direccion
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion); // Direccion por Id
	Integer eliminarDireccion(Map<String, Integer> mapDireccion); // Eliminar una direccion
	Integer cambiarDireccion(Direccion direccion);//Cambiar direccion
}
