package com.launchacademy.fluffandflame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
@Table(name = "adoption_applications")
public class AdoptionApplication {

  @Id
  @SequenceGenerator(name = "adoption_application_generator", sequenceName = "adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoption_application_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  //  CREATE TABLE adoption_applications (
  //    id SERIAL PRIMARY KEY,
  //    name VARCHAR(255) NOT NULL,
  //  phone_number VARCHAR(255) NOT NULL,
  //  email VARCHAR(255) NOT NULL,

  @NotBlank
  @Column(name = "name")
  private String name;

  @NotBlank
  @Column(name = "phone_number")
  private String phoneNumber;

  @NotBlank
  @Email
  @Column(name = "email")
  private String email;

  //  home_status VARCHAR(255) NOT NULL,
  //  application_status VARCHAR(255),
  //  creature_id INTEGER REFERENCES adoptable_creatures(id) NOT NULL

  @NotBlank
  @Column(name = "home_status")
  private String homeStatus;

  @NotBlank
  @Column(name = "application_status")
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name = "creature_id")
  Creature creature;
}




