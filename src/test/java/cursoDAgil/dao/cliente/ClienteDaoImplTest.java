package cursoDAgil.dao.cliente;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	int reg;
	
	@Test
	public void pruebaConsultarTodo(){
		System.out.println("----------------Test consultar todos los clientes-----------------------");
		try{
			List<Cliente> lista = clienteDao.listarTodosClientes();
			reg =lista.size();
			assertEquals(lista.size(),reg);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	
	@Ignore
	public void nuevoRegistro() {
		Cliente cliente = new Cliente();
		System.out.println("----------------Test Nuevo Cliente -----------------------");
		try {
			cliente.setNombre("ivan");
			cliente.setApellido("peña");
			cliente.setEmail("ivan.peñalosa@gmail.com");
			cliente.setSexo("hombre");
			cliente.setIddireccion(3);
			clienteDao.nuevoCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void consultarClientePorId() {
		Cliente cliente = new Cliente();
		System.out.println("----------------Consultar Cliente por Id  -----------------------");
		Map<String, Integer> mapCliente= new HashMap<>();
		mapCliente.put("id", 1);
		try {
			cliente = clienteDao.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Id:  " + cliente.getId());
			System.out.println("Nombre:  " + cliente.getNombre() );
			System.out.println("Direccion:  " + cliente.getDireccion().getCalle() );
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void modificarCliente(){
		Cliente cliente= new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		Integer CambiarIdDireccion = 1; //Id del producto que quieres cambiar
		System.out.println("----------------Test cambiar Cliente -----------------------");
		try{
			mapCliente.put("id",CambiarIdDireccion);
			cliente=clienteDao.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			
			//datos que quieres cambiar al producto
			cliente.setNombre("Paco");
			clienteDao.cambiarClientePorId(cliente, CambiarIdDireccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarRegistro(){
		Map<String, Integer> mapCliente= new HashMap<>();
		mapCliente.put("id",5);
		System.out.println("----------------Test Eliminar Cliente -----------------------");
		try{
			clienteDao.eliminarClientePorId(mapCliente);
			System.out.println("Cliente eliminado correctamente");
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}
