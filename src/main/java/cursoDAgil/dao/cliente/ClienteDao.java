package cursoDAgil.dao.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;


public interface ClienteDao {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Cliente obtenerClientePorId(Map<String, Integer> mapCliente);
	Integer eliminarClientePorId(Map<String, Integer> mapCliente); //Elimina un producto
	Integer cambiarClientePorId(Cliente cliente, Integer id); //actualiza el producto
}
