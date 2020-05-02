package com.launchacademy.fluffandflame.seeders;

import com.launchacademy.fluffandflame.models.AdoptionApplication;
import com.launchacademy.fluffandflame.repositories.AdoptionApplicationRepo;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationSeeder {

  private AdoptionApplicationRepo adoptionApplicationRepo;
  private CreatureRepo creatureRepo;

  @Autowired
  public AdoptionApplicationSeeder(AdoptionApplicationRepo adoptionApplicationRepo,
      CreatureRepo creatureRepo) {
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.creatureRepo = creatureRepo;
  }

  public void seed() {
    AdoptionApplication newAdApp = new AdoptionApplication();
    newAdApp.setName("Testy McGee");
    newAdApp.setPhoneNumber("666-666-6666");
    newAdApp.setEmail("email@email.com");
    newAdApp.setHomeStatus("own");
    newAdApp.setApplicationStatus("pending");
    newAdApp.setCreature(creatureRepo.findByName("Bob Nyanley"));

    AdoptionApplication newAdApp2 = new AdoptionApplication();
    newAdApp2.setName("Bob Marley");
    newAdApp2.setPhoneNumber("666-666-6666");
    newAdApp2.setEmail("bobs@burgers.com");
    newAdApp2.setHomeStatus("own");
    newAdApp2.setApplicationStatus("pending");
    newAdApp2.setCreature(creatureRepo.findByName("Bob Nyanley"));

    List<AdoptionApplication> allApps = adoptionApplicationRepo.findAll();
    if (allApps.size() == 0) {
      adoptionApplicationRepo.save(newAdApp);
      adoptionApplicationRepo.save(newAdApp2);
    }
  }

}
