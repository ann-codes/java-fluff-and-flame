package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.Creature;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreatureSeeder {

  private CreatureRepo creatureRepo;
  private CreatureTypeRepo creatureTypeRepo;

  public CreatureSeeder(CreatureRepo creatureRepo, CreatureTypeRepo creatureTypeRepo) {
    this.creatureRepo = creatureRepo;
    this.creatureTypeRepo = creatureTypeRepo;
  }

  public void seed() {

    Creature newCreature = new Creature();
    newCreature.setName("Test Thing1");
    newCreature.setCreatureImg("https://i.imgur.com/Vvh2s1y.png");
    newCreature.setAge(2);
    newCreature.setVaccinationStatus(false);
    newCreature.setAdoptionStory("A testy mc testing tester doodle");
    newCreature.setAdoptionStatus("adopted");
    newCreature.setCreatureType(creatureTypeRepo.findByType("Testasaurus"));

    Creature newCreature2 = new Creature();
    newCreature2.setName("Test Thing2");
    newCreature2.setCreatureImg("https://i.imgur.com/Vvh2s1y.png");
    newCreature2.setAge(22);
    newCreature2.setVaccinationStatus(true);
    newCreature2.setAdoptionStory("A testy mc testing tester doodlely doo doo");
    newCreature2.setAdoptionStatus("available");
    newCreature2.setCreatureType(creatureTypeRepo.findByType("Testasaurus"));

    List<Creature> findCreature = creatureRepo.findAll();
    if (findCreature.size() == 0) {
      System.out.println("NOT FOUND ADDING " + newCreature.getName() + " and "
          + newCreature2.getName());
      creatureRepo.save(newCreature);
      creatureRepo.save(newCreature2);
    }

  }
}
