package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.CreatureType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CreatureTypeRepo extends PagingAndSortingRepository<CreatureType, Integer> {

  public List<CreatureType> findAll();
  public List<CreatureType> findAllByType(String type);
  public CreatureType findByType(String type);

}
