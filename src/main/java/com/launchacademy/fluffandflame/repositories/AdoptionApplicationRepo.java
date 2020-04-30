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

  @Modifying
  @Query("UPDATE AdoptionApplication a SET a.applicationStatus = 'denied' WHERE a.id = :id")
  public AdoptionApplication ApplicationRequestDenied(@Param("id") Integer id);

  @Modifying
  @Query("UPDATE AdoptionApplication a SET a.applicationStatus = 'approved' WHERE a.id = :id")
  public Object ApplicationRequestApproved(@Param("id") Integer id);

//  @Modifying
//  @Query("update User u set u.active = false where u.lastLoginDate < :date")
//  void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);

//  @Query("SELECT c FROM Creature c JOIN CreatureType t on c.creatureType = t.id WHERE t.type = :type AND c.adoptionStatus = 'available'")
//  public List<Creature> findAllByCreatureType(@Param("type") String type);
  
}
