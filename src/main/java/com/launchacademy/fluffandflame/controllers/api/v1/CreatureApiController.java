package com.launchacademy.fluffandflame.controllers.api.v1;

import com.launchacademy.fluffandflame.models.Creature;
import com.launchacademy.fluffandflame.models.CreatureType;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreatureApiController {

  private CreatureTypeRepo creatureTypeRepo;
  private CreatureRepo creatureRepo;

  @Autowired
  public CreatureApiController(CreatureTypeRepo creatureTypeRepo, CreatureRepo creatureRepo) {
    this.creatureTypeRepo = creatureTypeRepo;
    this.creatureRepo = creatureRepo;
  }

  @NoArgsConstructor
  private class NotFoundException extends RuntimeException {

  }

  @ControllerAdvice
  private class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(NotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("all/types")
  public Iterable<CreatureType> getAllCreatureTypes() {
    return creatureTypeRepo.findAll();
  }

  @GetMapping("types/{typeName}")
  public CreatureType getOneCreatureByTypeName(@PathVariable String typeName) {
    try {
      creatureTypeRepo.findByType(typeName);
    } catch (NotFoundException ex) {
      System.out.println("NOT FOUND ==============>" + ex);
    }
    return creatureTypeRepo.findByType(typeName);
  }

  @GetMapping("creatures/all")
  public Iterable<Creature> getCreatures() {
    return creatureRepo.findAll();
  }

  @GetMapping("creatures/adopted")
  public Iterable<Creature> getAllAdoptedCreatures() {
    return creatureRepo.findAllByAdoptionStatus("adopted");
  }

  @GetMapping("adoptable")
  public Iterable<Creature> getAllAdoptableCreatures() {
    return creatureRepo.findAllByAdoptionStatus("available");
  }

  @GetMapping("adoptable/{typeName}")
  public Iterable<Creature> getAdoptableCreaturesByType(@PathVariable String typeName) {
    return creatureRepo.findAllByCreatureType(typeName);
  }

  @GetMapping("adoptable/{typeName}/{id}")
  public Optional<Creature> getOneCreature(@PathVariable String typeName,
      @PathVariable Integer id) {
    if (creatureRepo.findById(id).get().getCreatureType().getType().equals(typeName)) {
      return creatureRepo.findById(id);
    } else {
      return Optional.empty();
    }
  }

  @PutMapping("adopted/{id}")
  public Creature adoptCreature(@RequestBody Creature updateCreature, @PathVariable Integer id) {
    return creatureRepo.findById(id).map(creature -> {
      creature.setName(updateCreature.getName());
      creature.setCreatureImg(updateCreature.getCreatureImg());
      creature.setAge(updateCreature.getAge());
      creature.setVaccinationStatus(updateCreature.getVaccinationStatus());
      creature.setAdoptionStory(updateCreature.getAdoptionStory());
      creature.setAdoptionStatus("adopted");
      creature.setCreatureType(updateCreature.getCreatureType());
      return creatureRepo.save(creature);
    }).orElseThrow(NotFoundException::new);
  }

  @PostMapping("creature/types")
  public ResponseEntity create(@Valid @RequestBody CreatureType creatureType,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    } else {
      return new ResponseEntity<CreatureType>(creatureTypeRepo.save(creatureType),
          HttpStatus.CREATED);
    }
  }
  
}
