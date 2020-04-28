package com.launchacademy.fluffandflame.controllers.api.v1;

import com.launchacademy.fluffandflame.models.Creature;
import com.launchacademy.fluffandflame.models.CreatureType;
import com.launchacademy.fluffandflame.repositories.CreatureRepo;
import com.launchacademy.fluffandflame.repositories.CreatureTypeRepo;
import java.util.List;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("creature/types")
  public Iterable<CreatureType> getAllCreatureTypes(
//      @RequestParam(required = false) Integer page
  ) {
//    if (page == null) {
//      page = 0;
//    }
//    Pageable pageable = PageRequest.of(page, 20);
//    return creatureTypeRepo.findAll(pageable);
    return creatureTypeRepo.findAll();

  }

//  @GetMapping("creature/types/{id}")
//  public CreatureType getOneCreatureType(@PathVariable Integer id, Pageable pageable){
//    return creatureTypeRepo.findById(id).orElseThrow(NotFoundException::new);
//  }

  @GetMapping("creature/types/{typeName}")
  public CreatureType getOneCreatureByTypeName(@PathVariable String typeName) {
    // doesnt seem to have a .orElseThrow method to chain
    try {
      creatureTypeRepo.findByType(typeName);
    } catch (NotFoundException ex) {
      System.out.println("NOT FOUND ==============>" + ex);
      // doesn't work if not found? just blank
    }
    return creatureTypeRepo.findByType(typeName);
  }

  @GetMapping("creatures/adoptable")
  public Iterable<Creature> getAllAdoptableCreatures(
//      @RequestParam(required = false) Integer page
  ) {
//    if (page == null) {
//      page = 0;
//    }
//    Pageable pageable = PageRequest.of(page, 20);
//    return creatureRepo.findAll(pageable);
    return creatureRepo.findAll();
  }

  @GetMapping("creatures/adoptable/{typeName}")
  public Iterable<Creature> getAllCreaturesByType(@PathVariable String typeName) {
//    Pageable pageable = PageRequest.of(page, 20);

    try {
      System.out.println(creatureRepo.findAllByCreatureType(typeName));
    } catch (NotFoundException ex) {
      System.out.println("NOT FOUND ==============>" + ex);
    }
//return null;
    return creatureRepo.findAllByCreatureType(typeName);
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

  // curl -X POST localhost:8080/api/v1/creature/types -H 'Content-type:application/json' -d '{"type": "Testing2", "description": "Another Test", "imgUrl":"https://via.placeholder.com/150"}'


}
