package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteMapper {
	List<Cliente> listarTodosClientes();//Muestra todos los clientes
	Integer nuevoCliente(Cliente cliente);//Nuevo cliente 
	Cliente obtenerClientePorId(Map<String, Integer> mapCliente);//Busca un cliente por id
	Integer eliminarClientePorId(Map<String, Integer> mapCliente); //Elimina un producto
	Integer cambiarClientePorId(Cliente cliente); //actualiza el producto
}
