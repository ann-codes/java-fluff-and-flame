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
    newCreature.setType("Testasaurus");
    newCreature.setDescription("This is just a test.");
    newCreature.setImgUrl("https://i.imgur.com/Vvh2s1y.png");

    List<CreatureType> findType = repo.findAllByType(newCreature.getType());
    if (findType.size() == 0) {
      System.out.println("NOT FOUND ADDING " + newCreature.getType());
      repo.save(newCreature);
    }

  }
}

// curl -X POST localhost:8080/api/v1/creature/types -H 'Content-type:application/json' -d
// '{"type": "Testing2", "description": "Another Test", "imgUrl":"https://via.placeholder.com/150"}'