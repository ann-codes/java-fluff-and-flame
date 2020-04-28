CREATE TABLE pet_surrender_applications (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  pet_name VARCHAR(255) NOT NULL,
  pet_age INT NOT NULL,
  pet_type_id INTEGER REFERENCES creature_types(id) NOT NULL,
  pet_image_url VARCHAR(255) NOT NULL,
  vaccination_status BOOLEAN NOT NULL,
  application_status VARCHAR(255) NOT NULL
);
