package cursoDAgil.dao.cliente;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todos los clientes");
		try{
			List<Cliente> lista = clienteDao.listarTodosClientes();
			reg = lista.size();
			assertEquals(lista.size(),reg);
		} catch(Exception ex){
			System.out.println("Error " + ex);
		}
	}
}
