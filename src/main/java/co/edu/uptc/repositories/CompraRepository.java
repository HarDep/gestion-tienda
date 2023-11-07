package co.edu.uptc.repositories;

import co.edu.uptc.models.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer> {
}
