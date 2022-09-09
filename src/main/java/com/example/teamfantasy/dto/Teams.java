package com.example.teamfantasy.dto;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Teams {

    @Id
    @GeneratedValue
    Long id;

    String teamName;
    @ElementCollection
    List<Character> record;
    int points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Character> getRecord() {
        return record;
    }

    public void setRecord(List<Character> record) {
        this.record = record;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
