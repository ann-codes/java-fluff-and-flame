package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.CreatureType;
import com.launchacademy.fluffandflame.models.SurrenderApplication;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurrenderApplicationRepo extends
    PagingAndSortingRepository<SurrenderApplication, Integer> {

  public List<SurrenderApplication> findAll();

}
