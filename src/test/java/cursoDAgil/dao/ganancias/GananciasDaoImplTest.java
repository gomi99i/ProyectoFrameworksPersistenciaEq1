package cursoDAgil.dao.ganancias;

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

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.dao.ganancias.GananciasDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciasDaoImplTest {

	@Inject
	GananciasDao gananciasDao;

	@Test
	public void consultarGananciaPorFecha() {
		int reg;		
		System.out.println("----------------Test consultar Ganancias por fecha-----------------------");
		Map<String, String> mapGanancias = new HashMap<>();
		mapGanancias.put("fecha","2021-04-15");		
		try {
			List<Ganancias> lista = gananciasDao.obtenerGananciaPorFecha(mapGanancias);
			reg = lista.size();
			assertEquals(lista.size(), reg);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("----------------Test consultar todas las ganancias-----------------------");
		try {
			List<Ganancias> lista = gananciasDao.obtenerGanancias();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}

	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancias = new Ganancias();
		System.out.println("Test nueva Ganancia");
		try {
			ganancias.setTotalGanancia(234.8);
			ganancias.setVentaId(1);
			ganancias.setFecha("2021-05-08");
			gananciasDao.nuevaGanancia(ganancias);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
