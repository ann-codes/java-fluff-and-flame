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
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
@Table(name = "pet_surrender_applications")
public class SurrenderApplication {

  @Id
  @SequenceGenerator(name = "surrender_application_generator", sequenceName = "pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surrender_application_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

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

  @NotBlank
  @Column(name = "pet_name")
  private String petName;

  @NotNull
  @Column(name = "pet_age")
  private Integer petAge;

  @NotBlank
  @URL
  @Column(name = "pet_image_url")
  private String petImageUrl;

  @NotNull
  @Column(name = "vaccination_status")
  private Boolean vaccinationStatus;

  @NotBlank
  @Column(name = "application_status")
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name = "pet_type_id")
  CreatureType creatureType;

}
