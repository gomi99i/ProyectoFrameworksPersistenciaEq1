package cursoDAgil.dao.detalleventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Detalleventas;

public interface DetalleventasDao {

	List<Detalleventas> mostrarDetallesVenta(Map<String, Integer> mapDetalleVentas);

	Integer nuevoDetalleVenta(Detalleventas detalleventas);

}
