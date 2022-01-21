package co.com.poli.TallerPDS.service;

import co.com.poli.TallerPDS.entitys.Backlog;
import co.com.poli.TallerPDS.repository.BackLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BackLogServiceImpl implements BackLogService{
    @Autowired
    private BackLogRepository repository;

    @Override
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Backlog backlog) {
        repository.save(backlog);

    }
}
