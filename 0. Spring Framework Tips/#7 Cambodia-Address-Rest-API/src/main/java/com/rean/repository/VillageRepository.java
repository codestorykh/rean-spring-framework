package com.rean.repository;

import com.rean.model.Village;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends PagingAndSortingRepository<Village, Long> {

}
