package co.com.poli.TallerPDS.repository;

import co.com.poli.TallerPDS.entitys.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackLogRepository extends JpaRepository<Backlog,Long> {
}
