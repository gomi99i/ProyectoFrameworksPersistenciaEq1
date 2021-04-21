package cursoDAgil.dao.cliente;

import java.util.List;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteDao {
	List <Cliente> listarTodosClientes();
}
