package cursoDAgil.bd.mappers;

import java.util.List;

import java.util.Map;
import cursoDAgil.bd.domain.Detalleventas;

public interface DetalleventasMapper {
	List<Detalleventas> mostrarDetallesVentas(Map<String, Integer> mapDetalleVentas);
	Integer nuevoDetalleVenta(Detalleventas detalleventas);
}
