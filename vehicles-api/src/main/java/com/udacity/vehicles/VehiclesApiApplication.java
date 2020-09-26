package com.udacity.vehicles;

import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import com.udacity.vehicles.domain.manufacturer.ManufacturerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Launches a Spring Boot application for the Vehicles API,
 * initializes the car manufacturers in the database,
 * and launches web clients to communicate with maps and pricing.
 */
@SpringBootApplication
@EnableJpaAuditing
public class VehiclesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesApiApplication.class, args);
    }

    /**
     * Initializes the car manufacturers available to the Vehicle API.
     * @param repository where the manufacturer information persists.
     * @return the car manufacturers to add to the related repository
     */
    @Bean
    CommandLineRunner initDatabase(ManufacturerRepository repository) {
        return args -> {
            repository.save(new Manufacturer(100, "Audi"));
            repository.save(new Manufacturer(101, "Chevrolet"));
            repository.save(new Manufacturer(102, "Ford"));
            repository.save(new Manufacturer(103, "BMW"));
            repository.save(new Manufacturer(104, "Dodge"));
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Web Client for the maps (location) API
     * @param endpoint where to communicate for the maps API
     * @return created maps endpoint
     */
    @Bean(name="maps")
    public WebClient webClientMaps(@Value("${maps.endpoint}") String endpoint) {
        return WebClient.create(endpoint);
    }

    /**
     * Web Client for the pricing API
     * @param endpoint where to communicate for the pricing API
     * @return created pricing endpoint
     */
    @Bean(name="pricing")
    public WebClient webClientPricing(@Value("${pricing.endpoint}") String endpoint) {
        return WebClient.create(endpoint);
    }

}


// POST

/*

{
  "condition": "NEW",
  "createdAt": "2019-09-17T14:34:28.043Z",
  "details": {
    "body": "sedan",
    "engine": "3.6L V6",
    "externalColor": "white",
    "fuelType": "Gasoline",
    "manufacturer": {
      "code": 101,
      "name": "Chevrolet"
    },
    "mileage": 32280,
    "model": "Impala",
    "modelYear": 2018,
    "numberOfDoors": 4,
    "productionYear": 2018
  },
  "location": {
    "lat": 0,
    "lon": 0
  }
}

*/

// GET (id = 1)

// PUT (id = 1)

/*

{
    "id": 1,
    "createdAt": "2020-09-12T20:39:00.48914",
    "modifiedAt": "2020-09-12T20:39:00.48914",
    "condition": "NEW",
    "details": {
        "body": "hatchback",
        "model": "Impala",
        "manufacturer": {
            "code": 101,
            "name": "Chevrolet"
        },
        "numberOfDoors": 2,
        "fuelType": "Gasoline",
        "engine": "3.6L V6",
        "mileage": 32280,
        "modelYear": 2018,
        "productionYear": 2018,
        "externalColor": "white"
    },
    "location": {
        "lat": 40.73061,
        "lon": -73.935242,
        "address": null,
        "city": null,
        "state": null,
        "zip": null
    },
    "price": null
}

*/


// DELETE (id = 1)
