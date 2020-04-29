package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.AdoptionApplication;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdoptionApplicationRepo extends
    PagingAndSortingRepository<AdoptionApplication, Integer> {

  public List<AdoptionApplication> findAll();
}
