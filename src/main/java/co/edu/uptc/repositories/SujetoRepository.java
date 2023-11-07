package co.edu.uptc.repositories;

import co.edu.uptc.models.Sujeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SujetoRepository extends CrudRepository<Sujeto, Integer> {

    //query para obtener empleados
    @Query(value = "SELECT ...", nativeQuery = true)
    List<Sujeto> findEmployees();

    //query para obtener proveedores
    @Query(value = "SELECT ...", nativeQuery = true)
    List<Sujeto> findSuppliers();
}
