package com.example.teamfantasy.controller;

import com.example.teamfantasy.dto.Teams;
import com.example.teamfantasy.dto.Users;
import com.example.teamfantasy.service.AppService;
import com.example.teamfantasy.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    DataService dataService;

    @GetMapping(path = "/populateData")
    public void populateData(){
        dataService.createTeams();
    }

//    @GetMapping(path = "/getPointsByUser")
//    public double getPointsbyUser(@RequestParam String name){
//        return appService.getPointsbyUser(name);
//    }

    @GetMapping(path = "/allUsers")
    public List<String> allUsers(){
        return appService.getAllUsers();
    }


    @GetMapping(path = "/teams")
    public List<Teams> getAllTeams(){
        return appService.getAllTeams();
    }

    @GetMapping(path = "/stuff")
    public List<String> stuff(){
        return appService.justTeamsAndPoints();
    }

    @GetMapping(path = "/main")
    public List<Users> initialCall() {
        return appService.initalCall();
    }

    @GetMapping(path = "/rankings")
    public Map<String, Integer> getRankings() {
        return appService.getRankings();
    }

}
