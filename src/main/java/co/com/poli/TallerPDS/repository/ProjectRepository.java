package co.com.poli.TallerPDS.repository;

import co.com.poli.TallerPDS.entitys.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
