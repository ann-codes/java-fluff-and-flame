package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.CreatureType;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatureTypeSeeder {

  private CreatureTypeRepo repo;

  @Autowired
  public CreatureTypeSeeder(CreatureTypeRepo repo) {
    this.repo = repo;
  }

  public void seed() {
    CreatureType newCreature = new CreatureType();
    newCreature.setType("Nyan Cat");
    newCreature.setDescription("A mystical flying space feline in the shape of a pop tart.");
    newCreature.setImgUrl("https://i.pinimg.com/originals/93/e4/cd/93e4cd939da891cba51e740039b4f4d2.png");

    CreatureType newCreature2 = new CreatureType();
    newCreature2.setType("Dragon");
    newCreature2.setDescription("A powerful reptile in varied sizes with magical abilities.");
    newCreature2.setImgUrl("https://i.imgur.com/0Z6wZmr.jpg");

    List<CreatureType> findType = repo.findAllByType(newCreature.getType());
    if (findType.size() == 0) {
      repo.save(newCreature);
      repo.save(newCreature2);
    }
  }
}