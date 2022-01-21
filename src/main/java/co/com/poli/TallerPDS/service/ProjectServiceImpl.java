package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.Project;
import co.com.poli.TallerPDS.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return repository.findAll();

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Project create(Project project) {
        return repository.save(project);
    }
}
