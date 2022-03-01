package com.example.sprintDataRest;

import com.example.sprintDataRest.model.Alian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel="alians", path = "alians")
public interface AlianRepo extends JpaRepository<Alian, Integer> {

}
