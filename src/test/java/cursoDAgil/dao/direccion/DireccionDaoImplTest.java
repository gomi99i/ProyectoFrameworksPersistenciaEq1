package cursoDAgil.dao.direccion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Direccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DireccionDaoImplTest {
	@Inject
	DireccionDao direccionDao;

	@Ignore
	public void consultarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>(); 
		mapDireccion.put("idDireccion", 2);
		try {
			direccion = direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id:" + direccion.getIdDireccion());
			System.out.println("calle:" + direccion.getCalle());
			System.out.println("Numero:" + direccion.getNumero());
			System.out.println("Colonia:" + direccion.getColonia());
			System.out.println("Ciudad:" + direccion.getCiudad());
			System.out.println("Estado:" + direccion.getEstado());
			System.out.println("Pais:" + direccion.getPais());
			System.out.println("Codigo Postal:" + direccion.getCodigoPostal());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las direcciones");
		try {
			List<Direccion> lista = direccionDao.obtenerDirecciones();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
			for(Direccion direccion : lista){
				System.out.println("id:" + direccion.getIdDireccion());
				System.out.println("calle:" + direccion.getCalle());
				System.out.println("Numero:" + direccion.getNumero());
				System.out.println("Colonia:" + direccion.getColonia());
				System.out.println("Ciudad:" + direccion.getCiudad());
				System.out.println("Estado:" + direccion.getEstado());
				System.out.println("Pais:" + direccion.getPais());
				System.out.println("Codigo Postal:" + direccion.getCodigoPostal());
				System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}

	@Ignore
	public void nuevoRegistro() {
		Direccion direccion = new Direccion();
		System.out.println("Test nuevo registro");
		try {
			direccion.setCalle("Micaela Galindo");
			direccion.setNumero(3);
			direccion.setColonia("Centro");
			direccion.setCiudad("Huajuapan");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(69000);
			direccionDao.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void eliminarDireccion(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 11);
		try{
			direccion = direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion); 
			direccionDao.eliminarDireccion(mapDireccion);
		}catch (Exception e){
			System.out.println("Error:" + e);
		}
	}

	@Ignore
	public void cambiarDireccion(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		Integer CambiarId = 6; 
		try{
			mapDireccion.put("idDireccion",CambiarId);
			direccion=direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			direccion.setCalle("6 de mayo");
			direccionDao.cambiarDireccion(direccion, CambiarId);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}