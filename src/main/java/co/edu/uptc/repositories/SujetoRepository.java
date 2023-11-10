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
    @Query(value = "SELECT * FROM sujetos WHERE id_sujeto IN (SELECT id_empleado FROM empleados_roles " +
            "WHERE id_empleado IN (SELECT id_empleado FROM empleados_horarios WHERE id_horario IN (" +
            "SELECT id_horario FROM horarios WHERE dia_semana_horario = :dia AND hora_inicio_horario " +
            "<= CONVERT(TIME, :hora) AND DATEADD(HOUR, numero_horas_horario, hora_inicio_horario) >= " +
            "CONVERT(TIME, :hora)) AND es_activo_empleado_horario = 1) AND id_rol_empleado IN (SELECT " +
            "id_rol_empleado FROM roles_empleado WHERE nombre_rol_empleado LIKE 'vendedor') AND " +
            "es_activo_empleado_rol = 1)", nativeQuery = true)
    List<Sujeto> findSellers(@Param("hora") String hora,@Param("dia") String dia);

    //query para obtener proveedores
    @Query(value = "SELECT * FROM sujetos WHERE id_sujeto IN (SELECT id_proveedor FROM productos_proveedores)", nativeQuery = true)
    List<Sujeto> findSuppliers();
}
