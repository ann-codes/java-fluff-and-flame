package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.SurrenderApplication;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import com.launchacademy.fluffandflame.repositories.SurrenderApplicationRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurrenderApplicationSeeder {

  private SurrenderApplicationRepo surrenderApplicationRepo;
  private CreatureTypeRepo creatureTypeRepo;

  @Autowired
  public SurrenderApplicationSeeder(SurrenderApplicationRepo surrenderApplicationRepo,
      CreatureTypeRepo creatureTypeRepo) {
    this.surrenderApplicationRepo = surrenderApplicationRepo;
    this.creatureTypeRepo = creatureTypeRepo;
  }

  public void seed() {

    SurrenderApplication newSurApp = new SurrenderApplication();
    newSurApp.setName("Joey NotAPetOwner");
    newSurApp.setPhoneNumber("666-666-6666");
    newSurApp.setEmail("email@email.com");
    newSurApp.setPetName("Abandoned Jimmy");
    newSurApp.setPetAge(666);
    newSurApp.setPetImageUrl("https://i.imgur.com/Vvh2s1y.png");
    newSurApp.setVaccinationStatus(true);
    newSurApp.setApplicationStatus("pending");
    newSurApp.setCreatureType(creatureTypeRepo.findByType("Dragon"));

    SurrenderApplication newSurApp2 = new SurrenderApplication();
    newSurApp2.setName("Jimmy NotAPetOwner");
    newSurApp2.setPhoneNumber("666-666-6666");
    newSurApp2.setEmail("email@email2.com");
    newSurApp2.setPetName("Abandoned Joey");
    newSurApp2.setPetAge(555);
    newSurApp2.setPetImageUrl("https://i.imgur.com/Vvh2s1y.png");
    newSurApp2.setVaccinationStatus(false);
    newSurApp2.setApplicationStatus("pending");
    newSurApp2.setCreatureType(creatureTypeRepo.findByType("Dragon"));

    List<SurrenderApplication> allSurrenderApps = surrenderApplicationRepo.findAll();
    if (allSurrenderApps.size() == 0) {
      surrenderApplicationRepo.save(newSurApp);
      surrenderApplicationRepo.save(newSurApp2);
    }

  }
}
