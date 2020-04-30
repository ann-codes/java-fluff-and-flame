package com.launchacademy.fluffandflame.controllers.api.v1;

import com.launchacademy.fluffandflame.models.AdoptionApplication;
import com.launchacademy.fluffandflame.repositories.AdoptionApplicationRepo;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import java.util.List;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdoptionAppApiController {

  private AdoptionApplicationRepo adoptionApplicationRepo;
  private CreatureRepo creatureRepo;

  @Autowired
  public AdoptionAppApiController(AdoptionApplicationRepo adoptionApplicationRepo,
      CreatureRepo creatureRepo) {
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.creatureRepo = creatureRepo;
  }

  @NoArgsConstructor
  private class AdoptionAppNotFoundException extends RuntimeException {

    @ResponseBody
    @ExceptionHandler(AdoptionAppNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(AdoptionAppNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("/adoption/applications")
  public Iterable<AdoptionApplication> getAllAdoptionApplications() {
    return adoptionApplicationRepo.findAll();
  }

  @PostMapping("/adoption/application/new")
  public ResponseEntity create(@Valid @RequestBody AdoptionApplication adoptionApplication,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    } else {
      return new ResponseEntity<AdoptionApplication>(
          adoptionApplicationRepo.save(adoptionApplication), HttpStatus.CREATED);
    }
  }

}

//curl -X POST localhost:8080/api/v1/adoption/application/new -H 'Content-type:application/json' -d
// '{"name": "TEST ADD","phoneNumber": "617-666-8888","email": "bobs@burgers.com","homeStatus": "own","applicationStatus": "pending",
// "creature": {"id": 2,"name": "Test Thing","creatureImg": "https://i.imgur.com/Vvh2s1y.png","age": 2,
// "vaccinationStatus": false,"adoptionStory": "A testy mc testing tester doodle","adoptionStatus": "available",
// "creatureType": {"id": 1,"type": "Testasaurus","description": "This is just a test.","imgUrl": "https://i.imgur.com/Vvh2s1y.png"}}}'