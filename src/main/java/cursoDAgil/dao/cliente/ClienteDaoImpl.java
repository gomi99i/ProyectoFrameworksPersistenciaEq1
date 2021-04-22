package cursoDAgil.dao.cliente;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.ClienteMapper;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2258246685723751527L;	
	SqlSession sqlSession;	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> list = null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			for(Cliente c:list){
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				//System.out.println("Direccion: " + c.getDireccion());
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
	@Override
	public Integer nuevoCliente(Cliente cliente) {
		try {
			ClienteMapper  clienteMapper = sqlSession.getMapper(ClienteMapper .class);

			System.out.println("cliente creado con éxito");
			return clienteMapper.nuevoCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Cliente obtenerClientePorId(Map<String, Integer> mapCliente) {

		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);

			return clienteMapper.obtenerClientePorId(mapCliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
	@Override
	public Integer eliminarClientePorId(Map<String, Integer> mapCliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente Eliminado con éxito");			
			return clienteMapper.eliminarClientePorId(mapCliente);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Integer cambiarClientePorId(Cliente cliente, Integer id){
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente cambiado con éxito");	
			cliente.setId(id);
			return clienteMapper.cambiarClientePorId(cliente);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	
}
