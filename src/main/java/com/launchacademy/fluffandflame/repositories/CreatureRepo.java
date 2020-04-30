package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.Creature;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CreatureRepo extends PagingAndSortingRepository<Creature, Integer> {

  public Creature findByName(String name);

  public List<Creature> findAll();
  public List<Creature> findAllByAdoptionStatus(String status);

  @Query("SELECT c FROM Creature c JOIN CreatureType t on c.creatureType = t.id WHERE t.type = :type AND c.adoptionStatus = 'available'")
  public List<Creature> findAllByCreatureType(@Param("type") String type);


}
