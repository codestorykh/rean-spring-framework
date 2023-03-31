package com.rean.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> genericService;

    protected GenericController(GenericRepository<T> genericRepository) {
        this.genericService = new GenericService<T>(genericRepository) {};
    }

    @GetMapping("")
    public ResponseEntity<Page<T>> getPage(Pageable pageable) {
        return ResponseEntity.ok(genericService.getPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(genericService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<T> create(@RequestBody T createNewRecord) {
        return ResponseEntity.ok(genericService.create(createNewRecord));
    }

    @PutMapping("")
    public ResponseEntity<T> update(@RequestBody T updateRecord) {
        return ResponseEntity.ok(genericService.update(updateRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        genericService.delete(id);
        return ResponseEntity.ok("Record deleted!");
    }
}
