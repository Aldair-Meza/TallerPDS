package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.Backlog;

import java.util.List;

public interface BackLogService {

    List<Backlog> findAll();
    void create(Backlog backlog);
}
