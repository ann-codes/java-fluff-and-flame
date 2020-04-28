package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.Creature;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreatureSeeder implements CommandLineRunner {

  private CreatureRepo creatureRepo;
  private CreatureTypeRepo creatureTypeRepo;

  public CreatureSeeder(CreatureRepo creatureRepo, CreatureTypeRepo creatureTypeRepo) {
    this.creatureRepo = creatureRepo;
    this.creatureTypeRepo = creatureTypeRepo;
  }

  @Override
  public void run(String... args) throws Exception {

    Creature newCreature = new Creature();
    newCreature.setName("Test Thing");
    newCreature.setCreatureImg("https://i.imgur.com/Vvh2s1y.png");
    newCreature.setAge(2);
    newCreature.setVaccinationStatus(false);
    newCreature.setAdoptionStory("A testy mc testing tester doodle");
    newCreature.setAdoptionStatus("available");
    newCreature.setCreatureType(creatureTypeRepo.findByType("Testasaurus"));

    List<Creature> findCreature = creatureRepo.findAll();
    if(findCreature.size() == 0) {
      System.out.println("NOT FOUND ADDING " + newCreature.getName());
      creatureRepo.save(newCreature);
    }

  }
}
