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
  private class SurenderAppNotFoundException extends RuntimeException {

  }

  @ControllerAdvice
  private class SurenderAppNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SurenderAppNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(SurenderAppNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("surrender/all")
  public Iterable<SurrenderApplication> getAllSurrenderApplications() {
    return surrenderApplicationRepo.findAll();
  }

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
