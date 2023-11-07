package co.edu.uptc.repositories;

import co.edu.uptc.models.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {
}
