package co.edu.uptc.repositories;

import co.edu.uptc.models.Sujeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SujetoRepository extends CrudRepository<Sujeto, Integer> {

    @Query(value = "SELECT * FROM sujetos WHERE tipo_sujeto LIKE 'PER'", nativeQuery = true)
    List<Sujeto> findEmployees();
}
