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
    newSurApp.setName("Some Guy Giving up His Pet");
    newSurApp.setPhoneNumber("666-666-6666");
    newSurApp.setEmail("email@email.com");
    newSurApp.setPetName("Poor Abandoned Pet");
    newSurApp.setPetAge(666);
    newSurApp.setPetImageUrl("https://i.imgur.com/Vvh2s1y.png");
    newSurApp.setVaccinationStatus(true);
    newSurApp.setApplicationStatus("pending");
    newSurApp.setCreatureType(creatureTypeRepo.findByType("Testasaurus"));

    List<SurrenderApplication> allSurrenderApps = surrenderApplicationRepo.findAll();
    if (allSurrenderApps.size() == 0) {
      System.out.println("NONE FOUND ADDING " + newSurApp.getName());
      surrenderApplicationRepo.save(newSurApp);
    }

  }
}
