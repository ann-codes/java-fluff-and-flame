package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.Creature;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreatureSeeder {

  private CreatureRepo creatureRepo;
  private CreatureTypeRepo creatureTypeRepo;

  @Autowired
  public CreatureSeeder(CreatureRepo creatureRepo, CreatureTypeRepo creatureTypeRepo) {
    this.creatureRepo = creatureRepo;
    this.creatureTypeRepo = creatureTypeRepo;
  }

  public void seed() {

    Creature newCreature = new Creature();
    newCreature.setName("Nyan Nyan");
    newCreature.setCreatureImg("https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG");
    newCreature.setAge(2);
    newCreature.setVaccinationStatus(false);
    newCreature.setAdoptionStory("Was found at the end of a rainbow and is looking for a new sky home");
    newCreature.setAdoptionStatus("available");
    newCreature.setCreatureType(creatureTypeRepo.findByType("Nyan Cat"));

    Creature newCreature2 = new Creature();
    newCreature2.setName("Bob Nyanley");
    newCreature2.setCreatureImg("https://s3.amazonaws.com/colorslive/jpg_512x512/377224-lglLt_mui26xjl6y.jpg");
    newCreature2.setAge(22);
    newCreature2.setVaccinationStatus(false);
    newCreature2.setAdoptionStory("A Nyan cat in the shape of a burger.");
    newCreature2.setAdoptionStatus("available");
    newCreature2.setCreatureType(creatureTypeRepo.findByType("Nyan Cat"));

    Creature newCreature3 = new Creature();
    newCreature3.setName("Galakrond");
    newCreature3.setCreatureImg("https://gamepedia.cursecdn.com/wowpedia/thumb/e/e5/Galakrond%2C_the_Wretched.jpg/1032px-Galakrond%2C_the_Wretched.jpg");
    newCreature3.setAge(7950);
    newCreature3.setVaccinationStatus(true);
    newCreature3.setAdoptionStory("A massive proto-dragon who is known as the progenitor of dragonkind.");
    newCreature3.setAdoptionStatus("available");
    newCreature3.setCreatureType(creatureTypeRepo.findByType("Dragon"));

    List<Creature> findCreature = creatureRepo.findAll();
    if (findCreature.size() == 0) {
      creatureRepo.save(newCreature);
      creatureRepo.save(newCreature2);
      creatureRepo.save(newCreature3);
    }

  }
}
