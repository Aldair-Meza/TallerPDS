package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    ProjectTask create(ProjectTask projectTask);

    List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier);
}
