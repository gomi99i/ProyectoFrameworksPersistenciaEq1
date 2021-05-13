package cursoDAgil.dao.ventas;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.detalleventas.DetalleventasDao;
import cursoDAgil.dao.ganancias.GananciasDao;
import cursoDAgil.dao.productos.ProductosDao;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"/applicationContext.xml"})

public class VentasDaoImplTest {
	
	@Inject
	VentasDao ventasDao;
	@Inject
	DetalleventasDao detalleventasDao;
	@Inject
	ProductosDao productosDao;
	@Inject
	GananciasDao gananciasDao;
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void consultarVentaPorCliente(){
		Map<String, Integer> mapVentas = new HashMap<>();
		mapVentas.put("id", 1);
		try{
			List<Ventas> lista = ventasDao.consultarVentaPorCliente(mapVentas);
			for(Ventas ventas:lista){
				System.out.println("\nNombre: " + ventas.getCliente().getNombre());
				System.out.println("Apellido: " + ventas.getCliente().getApellido());
				System.out.println("Id Venta: " + ventas.getIdVenta());
				System.out.println("Total de Venta: " + ventas.getTotalVenta());
			}
			assertNotNull(lista);
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void consultarTodasVentas(){
		int reg;
		System.out.println("\nTest Consultar Todas las Ventas\n");
		try{
			List<Ventas> lista = ventasDao.consultarTodasVentas();
			for(Ventas c:lista){
                System.out.println("\nId venta: " + c.getIdVenta());
                System.out.println("Cliente: " + c.getCliente().getNombre() + " " + c.getCliente().getApellido());
                System.out.println("Total Venta: "+ c.getTotalVenta());
                System.out.println("Fecha: "+ c.getFecha());
    			System.out.println("Dirección calle: " + c.getCliente().getDireccion().getCalle());
    			System.out.println("Dirección ciudad: " + c.getCliente().getDireccion().getCiudad());
            }  
			reg=lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\n Registros de la tabla Ventas: " + reg);
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	
	@Ignore
	public void nuevaVenta(){
		Ventas venta = new Ventas();
		List<Productos> bolsa = new ArrayList<Productos>();
		Cliente cliente = new Cliente();
		Double totalvta = 0.0;
		System.out.println("Venta nueva.");
		try{
			Map<String, Integer> mapCliente = new HashMap<>();
			mapCliente.put("id", 4);
			cliente=clienteDao.obtenerClientePorId(mapCliente);
			venta.setClienteId(cliente.getId());
			Productos producto = new Productos();
			Map<String, Integer> mapProducto = new HashMap<>();
			mapProducto.put("idProducto", 5);
			producto=productosDao.obtenerProductoPorId(mapProducto);
			assertNotNull(producto);
			producto.setCantidad(4);
			totalvta+=producto.getPrecioVta()*producto.getCantidad();
			bolsa.add(producto);
			
			mapProducto.put("idProducto", 6);
			producto=productosDao.obtenerProductoPorId(mapProducto);
			assertNotNull(producto);
			producto.setCantidad(4);
			totalvta+=producto.getPrecioVta()*producto.getCantidad();
			bolsa.add(producto);
			
			venta.setTotalVenta(totalvta);
			venta.setProductos(bolsa);
			venta.setFecha("2021/04/22");
			ventasDao.nuevaVenta(venta);
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void actualizaVenta(){
		Ventas venta = new Ventas();
		try{
			venta.setIdVenta(5);
			venta.setTotalVenta(456.88);
			venta.setFecha("2021/04/23");
			ventasDao.actualizaVenta(venta);
			System.out.println("Modificación correcta.\n");
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
}
