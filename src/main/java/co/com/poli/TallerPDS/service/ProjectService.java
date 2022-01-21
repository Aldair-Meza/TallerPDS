package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project create(Project project);
}
