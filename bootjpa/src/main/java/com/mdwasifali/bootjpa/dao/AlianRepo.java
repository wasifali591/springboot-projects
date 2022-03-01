package com.mdwasifali.bootjpa.dao;

import com.mdwasifali.bootjpa.model.Alian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlianRepo extends JpaRepository<Alian, Integer> {
    List<Alian> findByTech(String tech);
    List<Alian> findByAidGreaterThan(int aid);
    @Query("from Alian where tech=?1 order by aname")
    List<Alian> findByTechSorted(String tech);
}