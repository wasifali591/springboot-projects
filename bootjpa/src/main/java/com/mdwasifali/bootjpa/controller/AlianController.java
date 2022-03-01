package com.mdwasifali.bootjpa.controller;

import com.mdwasifali.bootjpa.dao.AlianRepo;
import com.mdwasifali.bootjpa.model.Alian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlianController {
    @Autowired
    AlianRepo repo;

    @RequestMapping("/")
    public String Home(){
        return "home";
    }

//    @RequestMapping("/addAlian")
//    public String addAlian(Alian alian){
//        repo.save(alian);
//        return "home";
//    }

    @RequestMapping("/getAlian")
    public ModelAndView getAlian(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showAlian");


        Alian alian = repo.findById(aid).orElse(new Alian());
        mv.addObject(alian);

        System.out.println(repo.findByTech("java"));
        System.out.println(repo.findByAidGreaterThan(102));
        System.out.println(repo.findByTechSorted("java"));
        return mv;
    }

    @GetMapping("/alians")
    public List<Alian> getAlians(){
        return repo.findAll();
    }

    @GetMapping("/alian/{aid}")
    public Optional<Alian> getAlians(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

    @PostMapping("/alian")
    public Alian addAlian(@RequestBody Alian alian){
        repo.save(alian);
        return alian;
    }

    @DeleteMapping("/alian/{aid}")
    public String deleteAlian(@PathVariable int aid){
        Alian a = repo.getById(aid);
        repo.delete(a);
        return "Deleted!";
    }

    @PutMapping("/alian")
    public Alian updateAlian(@RequestBody Alian alian){
        repo.save(alian);
        return alian;
    }
}