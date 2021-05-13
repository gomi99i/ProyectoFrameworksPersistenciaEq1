package cursoDAgil.dao.detalleventas;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Detalleventas;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DetalleventasDaoImplTest {
	
	@Inject
	DetalleventasDao detalleventasDao;
	
	@Test
	public void mostrarDetallesVenta(){
		Map<String, Integer> mapDetalleVentas = new HashMap<>();
		mapDetalleVentas.put("ventaId", 2);
		int reg;
		try{
			System.out.println("Test mostrar detalles de la venta.");
			List<Detalleventas> lista = detalleventasDao.mostrarDetallesVenta(mapDetalleVentas);
			for(Detalleventas detalleventas:lista){
				System.out.println("\n# de venta: " + detalleventas.getVentaId());
				System.out.println("Nombre del producto: " + detalleventas.getProductos().getNombre());
				System.out.println("Cantidad:  " + detalleventas.getCantidad());
			}	
			reg=lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\n Registros de los productos de la consulta: " + reg);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void nuevoDetalleVenta(){
		Detalleventas detalleventas = new Detalleventas();
		try{
			detalleventas.setVentaId(3);
			detalleventas.setProductoId(4);
			detalleventas.setCantidad(3);
			detalleventasDao.nuevoDetalleVenta(detalleventas);
			System.out.println("Inserción correcta.\n");
		}catch(Exception e){
			System.out.println("Error: " + e);			
		}
	}
}
