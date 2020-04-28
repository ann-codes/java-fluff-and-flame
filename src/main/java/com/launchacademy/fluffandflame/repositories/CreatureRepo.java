package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.Creature;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CreatureRepo extends PagingAndSortingRepository<Creature, Integer> {

  public List<Creature> findAll();

//  @Query("SELECT a FROM AdoptablePet a JOIN PetType p ON a.typeId = p.id WHERE p.type = :type")
//  public List<AdoptablePet> findAllBytype(@Param("type") String type);

  @Query("SELECT c FROM Creature c JOIN CreatureType t on c.creatureType = t.id WHERE t.type = :type")
  public List<Creature> findAllByCreatureType(@Param("type") String type);



}
