package co.com.poli.TallerPDS.repository;

import co.com.poli.TallerPDS.entitys.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier);
}
