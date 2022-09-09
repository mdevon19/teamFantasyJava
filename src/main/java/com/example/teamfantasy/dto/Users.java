package com.example.teamfantasy.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @OneToMany
    List<Teams> teams;
    double totalPoints;

    public Users(String name, List<Teams> teams, double totalPoints) {
        this.name = name;
        this.teams = teams;
        this.totalPoints = totalPoints;
    }

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> teams) {
        this.teams = teams;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }
}
