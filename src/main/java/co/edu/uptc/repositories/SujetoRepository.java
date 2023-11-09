package co.edu.uptc.repositories;

import co.edu.uptc.models.Sujeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SujetoRepository extends JpaRepository<Sujeto, Integer> {

    //query para obtener empleados que son vendedores y que atienden en la hora y día especificado
    @Query(value = "SELECT ... WHERE ... :hora ... :dia", nativeQuery = true)
    List<Sujeto> findSellers(@Param("hora") String hora,@Param("dia") String dia);

    //query para obtener proveedores
    @Query(value = "SELECT ...", nativeQuery = true)
    List<Sujeto> findSuppliers();
}
