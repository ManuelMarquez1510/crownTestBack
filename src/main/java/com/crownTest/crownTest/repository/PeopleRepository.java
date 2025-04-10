// Aquí estamos simulando la interacción con una API externa (como la de Star Wars) en lugar de una base de datos real,
// para fines de demostración o pruebas, ya que el propósito de este proyecto no es interactuar con una BD real en este momento.
// En un entorno de producción, este archivo debería implementar las operaciones de acceso a la base de datos, como consultas
// de tipo SELECT, INSERT, UPDATE, DELETE, utilizando un ORM (como Hibernate o Spring Data JPA) o mediante acceso directo 
// a la BD, dependiendo de la configuración y la arquitectura del sistema. 
// Si el sistema estuviera conectado a una base de datos real, este repository debería ser responsable de 
// realizar las consultas necesarias a la BD (por ejemplo, utilizando JPA y un repositorio de Spring Data o JDBC directo),
// en lugar de hacer una solicitud HTTP a una API externa.
package com.crownTest.crownTest.repository;

import com.crownTest.crownTest.model.People;
import com.crownTest.crownTest.model.PeopleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${api.url}")
    private String apiUrl;

    public List<People> fetchPeople() {
        String url = apiUrl;
        List<People> allPeople = new ArrayList<>();

        while (url != null) {
            PeopleResponse response = restTemplate.getForObject(url, PeopleResponse.class);
            if (response != null) {
                allPeople.addAll(response.getResults());
                url = response.getNext(); 
            } else {
                break;
            }
        }

        return allPeople;
    }
}