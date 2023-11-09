package co.edu.uptc.repositories;

import co.edu.uptc.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote,Integer> {
}
