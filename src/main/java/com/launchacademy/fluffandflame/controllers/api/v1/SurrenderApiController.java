package com.launchacademy.fluffandflame.controllers.api.v1;

import com.launchacademy.fluffandflame.models.SurrenderApplication;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import com.launchacademy.fluffandflame.repositories.SurrenderApplicationRepo;
import java.util.List;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
public class SurrenderApiController {

  private SurrenderApplicationRepo surrenderApplicationRepo;
  private CreatureTypeRepo creatureTypeRepo;

  @Autowired
  public SurrenderApiController(CreatureTypeRepo creatureTypeRepo,
      SurrenderApplicationRepo surrenderApplicationRepo) {
    this.creatureTypeRepo = creatureTypeRepo;
    this.surrenderApplicationRepo = surrenderApplicationRepo;
  }

  @NoArgsConstructor
  private class SuurenderAppNotFoundException extends RuntimeException {

  }

  @ControllerAdvice
  private class SuurenderAppNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SuurenderAppNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(SuurenderAppNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("surrender/all")
  public Iterable<SurrenderApplication> getAllSurrenderApplications() {
    return surrenderApplicationRepo.findAll();
  }

//  @PostMapping("surrender/new")
//  public SurrenderApplication create(
//      @RequestBody @ModelAttribute SurrenderApplication surrenderApplication,
//      BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//      throw new SuurenderAppNotFoundException();
//    } else {
//      return surrenderApplicationRepo.save(surrenderApplication);
//    }
//  }

  @PostMapping("surrender/new")
  public ResponseEntity create(@Valid @RequestBody SurrenderApplication surrenderApplication,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    } else {
      return new ResponseEntity<SurrenderApplication>(
          surrenderApplicationRepo.save(surrenderApplication), HttpStatus.CREATED);
    }
  }

}

//curl -X POST localhost:8080/api/v1/surrender/new -H 'Content-type:application/json' -d '{"name": "Some Guy Giving up His Pet222","phoneNumber": "666-666-6666","email": "email@email.com","petName": "Poor Abandoned Pet","petAge": 666,"petImageUrl": "https://i.imgur.com/Vvh2s1y.png","vaccinationStatus": true,"applicationStatus": "pending","creatureType": { "id": 1, "type": "Testasaurus", "description": "This is just a test.", "imgUrl": "https://i.imgur.com/Vvh2s1y.png" }}'

