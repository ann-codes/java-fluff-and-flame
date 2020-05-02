package com.launchacademy.fluffandflame.repositories;

import com.launchacademy.fluffandflame.models.AdoptionApplication;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AdoptionApplicationRepo extends
    PagingAndSortingRepository<AdoptionApplication, Integer> {

  public List<AdoptionApplication> findAll();
  public Optional<AdoptionApplication> findById(Integer id);

  @Query("SELECT a FROM AdoptionApplication a JOIN Creature c on a.creature = c.id WHERE c.adoptionStatus = 'available'")
  public List<AdoptionApplication> findAllByAvailableCreature();

  @Modifying
  @Query("UPDATE AdoptionApplication a SET a.applicationStatus = 'denied' WHERE a.id = :id")
  public AdoptionApplication ApplicationRequestDenied(@Param("id") Integer id);

  @Modifying
  @Query("UPDATE AdoptionApplication a SET a.applicationStatus = 'approved' WHERE a.id = :id")
  public Object ApplicationRequestApproved(@Param("id") Integer id);

}
