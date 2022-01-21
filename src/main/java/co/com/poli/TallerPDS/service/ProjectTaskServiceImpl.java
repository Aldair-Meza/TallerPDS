package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.ProjectTask;
import co.com.poli.TallerPDS.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService{


    @Autowired
    private ProjectTaskRepository repository;

    @Override
    public ProjectTask create(ProjectTask projectTask) {
        return repository.save(projectTask);
    }
}
