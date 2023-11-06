package co.edu.uptc.repositories;

import co.edu.uptc.models.Sujeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetoRepository extends CrudRepository<Sujeto, Integer> {
}
