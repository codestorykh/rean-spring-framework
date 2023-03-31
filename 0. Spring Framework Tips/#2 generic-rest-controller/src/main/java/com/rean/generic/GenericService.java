package com.rean.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

public abstract class GenericService <T extends GenericEntity<T>>{

    private final GenericRepository<T> genericRepository;

    protected GenericService(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public Page<T> getPage(Pageable pageable) {
        return genericRepository.findAll(pageable);
    }

    public T get(Long id) {
        return genericRepository.findById(id).orElse(null);
    }

    @Transactional
    public T create(T createNewRecord) {
        T dao = createNewRecord.createNewInstance();
        return genericRepository.save(dao);
    }

    @Transactional
    public T update(T updateRecord) {
        T dao = get(updateRecord.getId());
        dao.update(updateRecord);
        return genericRepository.save(dao);
    }

    @Transactional
    public void delete(Long id) {
        get(id);
        genericRepository.deleteById(id);
    }
}
