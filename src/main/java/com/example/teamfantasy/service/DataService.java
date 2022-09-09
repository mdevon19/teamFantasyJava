package com.example.teamfantasy.service;

import com.example.teamfantasy.dto.Teams;
import com.example.teamfantasy.dto.Users;
import com.example.teamfantasy.repository.TeamsRepository;
import com.example.teamfantasy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    @Autowired
    TeamsRepository teamsRepository;

    @Autowired
    UsersRepository usersRepository;

    public void createTeams(){
        undraftedTeams();
        devonTeams();
        mattTeams();
        ryanTeams();
        leahTeams();
        benTeams();
        chrisTeams();
    }

    public void undraftedTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record = {'l','l','l','w','l','l','w','l','l','l','w','l','l','l','w','l','l'};
        Teams Jets = new Teams();
        Jets.setTeamName("Jets");
        Jets.setRecord(Arrays.asList(record));
        teams.add(Jets);
        teamsRepository.save(Jets);

        Character[] record5 = {'l','l','l','l','l','w','l','w','l','l','l','l','l','l','l','l','w'};
        Teams jaguars = new Teams();
        jaguars.setTeamName("Jaguars");
        jaguars.setRecord(Arrays.asList(record5));
        teams.add(jaguars);
        teamsRepository.save(jaguars);

        Users undrafted = new Users();
        undrafted.setName("Undrafted");
        undrafted.setTotalPoints(0.0);
        undrafted.setTeams(teams);

        usersRepository.save(undrafted);
    }

    public void devonTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record = {'w','w','l','w','w','w','w','l','l','w','w','w','w','l','w','w','w','w','l'};
        Teams buccaneers = new Teams();
        buccaneers.setTeamName("Buccaneers");
        buccaneers.setRecord(Arrays.asList(record));
        teams.add(buccaneers);
        teamsRepository.save(buccaneers);

        Character[] record2 = {'w','l','l','l','w','w','w','w','t','l','l','w','l','w','l','w','w','l'};
        Teams steelers = new Teams();
        steelers.setTeamName("Steelers");
        steelers.setRecord(Arrays.asList(record2));
        teams.add(steelers);
        teamsRepository.save(steelers);

        Character[] record3 = {'w','w','w','w','w','w','w','l','w','l','w','w','l','l','l','w','l','l'};
        Teams cardinals = new Teams();
        cardinals.setTeamName("Cardinals");
        cardinals.setRecord(Arrays.asList(record3));
        teams.add(cardinals);
        teamsRepository.save(cardinals);

        Character[] record5 = {'l','w','l','w','w','l','l','l','l','l','w','l','l','l','w','w','l'};
        Teams bears = new Teams();
        bears.setTeamName("Bears");
        bears.setRecord(Arrays.asList(record5));
        teams.add(bears);
        teamsRepository.save(bears);

        Character[] record4 = {'l','l','w','l','w','w','l','w','l','l','w','l','w','l','w','l','l'};
        Teams falcons = new Teams();
        falcons.setTeamName("Falcons");
        falcons.setRecord(Arrays.asList(record4));
        teams.add(falcons);
        teamsRepository.save(falcons);

        Users devon = new Users();
        devon.setName("Devon");
        devon.setTotalPoints(0.0);
        devon.setTeams(teams);

        usersRepository.save(devon);
    }

    public void mattTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record = {'w','w','w','l','l','l','w','l','w','w','w','l','w','w','l','w','w','w','w','l'};
        Teams niners = new Teams();
        niners.setTeamName("49ers");
        niners.setRecord(Arrays.asList(record));
        teams.add(niners);
        teamsRepository.save(niners);

        Character[] record2 = {'l','w','w','w','w','w','l','w','l','w','w','l','l','l','l','l','l'};
        Teams ravens = new Teams();
        ravens.setTeamName("Ravens");
        ravens.setRecord(Arrays.asList(record2));
        teams.add(ravens);
        teamsRepository.save(ravens);

        Character[] record3 = {'l','l','l','w','l','w','w','l','w','w','w','l','w','w','w','l','l'};
        Teams colts = new Teams();
        colts.setTeamName("Colts");
        colts.setRecord(Arrays.asList(record3));
        teams.add(colts);
        teamsRepository.save(colts);

        Character[] record4 = {'l','l','w','l','w','w','l','l','w','w','l','l','w','w','l','l','w'};
        Teams vikings = new Teams();
        vikings.setTeamName("Vikings");
        vikings.setRecord(Arrays.asList(record4));
        teams.add(vikings);
        teamsRepository.save(vikings);

        Character[] record5 = {'l','l','l','l','l','l','l','l','t','l','l','w','l','w','l','l','w'};
        Teams lions = new Teams();
        lions.setTeamName("Lions");
        lions.setRecord(Arrays.asList(record5));
        teams.add(lions);
        teamsRepository.save(lions);

        Users matt = new Users();
        matt.setName("Matt");
        matt.setTotalPoints(0.0);
        matt.setTeams(teams);
        usersRepository.save(matt);
    }

    public void ryanTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record = {'l','w','w','w','w','l','w','l','w','l','w','l','l','w','w','w','w','w','l'};
        Teams bills = new Teams();
        bills.setTeamName("Bills");
        bills.setRecord(Arrays.asList(record));
        teams.add(bills);
        teamsRepository.save(bills);

        Character[] record2 = {'l','w','l','w','l','l','l','l','w','w','w','w','l','l','l','l','w'};
        Teams commanders = new Teams();
        commanders.setTeamName("Commanders");
        commanders.setRecord(Arrays.asList(record2));
        teams.add(commanders);
        teamsRepository.save(commanders);

        Character[] record3 = {'l','w','w','l','w','w','w','w','w','w','l','l','w','l','w','w','w','l'};
        Teams titans = new Teams();
        titans.setTeamName("Titans");
        titans.setRecord(Arrays.asList(record3));
        teams.add(titans);
        teamsRepository.save(titans);

        Character[] record4 = {'l','w','w','w','w','w','w','l','w','l','l','w','w','w','w','l','w','l'};
        Teams cowboys = new Teams();
        cowboys.setTeamName("Cowboys");
        cowboys.setRecord(Arrays.asList(record4));
        teams.add(cowboys);
        teamsRepository.save(cowboys);

        Character[] record5 = {'w','w','w','l','l','w','w','l','l','l','w','l','l','w','w','w','w','l'};
        Teams raiders = new Teams();
        raiders.setTeamName("Raiders");
        raiders.setRecord(Arrays.asList(record5));
        teams.add(raiders);
        teamsRepository.save(raiders);

        Users ryan = new Users();
        ryan.setName("Ryan");
        ryan.setTotalPoints(0.0);
        ryan.setTeams(teams);
        usersRepository.save(ryan);
    }

    public void leahTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record3 = {'w','l','w','l','w','w','w','l','l','l','l','l','w','w','l','w','w'};
        Teams saints = new Teams();
        saints.setTeamName("Saints");
        saints.setRecord(Arrays.asList(record3));
        teams.add(saints);
        teamsRepository.save(saints);

        Character[] record5 = {'w','l','l','l','w','l','l','w','l','w','w','l','w','w','w','w','l','l'};
        Teams eagles = new Teams();
        eagles.setTeamName("Eagles");
        eagles.setRecord(Arrays.asList(record5));
        teams.add(eagles);
        teamsRepository.save(eagles);

        Character[] record = {'w','l','l','w','l','w','l','w','w','w','w','w','w','w','w','l','w','w','w','l'};
        Teams chiefs = new Teams();
        chiefs.setTeamName("Chiefs");
        chiefs.setRecord(Arrays.asList(record));
        teams.add(chiefs);
        teamsRepository.save(chiefs);

        Character[] record2 = {'w','l','w','w','l','w','w','l','l','w','w','l','l','w','w','w','l','w','w','w','l'};
        Teams bengals = new Teams();
        bengals.setTeamName("Bengals");
        bengals.setRecord(Arrays.asList(record2));
        teams.add(bengals);
        teamsRepository.save(bengals);

        Character[] record4 = {'w','l','l','w','l','l','l','w','l','l','l','w','w','l','l','w','w'};
        Teams seahawks = new Teams();
        seahawks.setTeamName("Seahawks");
        seahawks.setRecord(Arrays.asList(record4));
        teams.add(seahawks);
        teamsRepository.save(seahawks);

        Users leah = new Users();
        leah.setName("Leah");
        leah.setTotalPoints(0.0);
        leah.setTeams(teams);
        usersRepository.save(leah);
    }

    public void benTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record4 = {'l','l','l','w','l','l','w','l','w','l','w','l','l','l','l','l','l'};
        Teams giants = new Teams();
        giants.setTeamName("Giants");
        giants.setRecord(Arrays.asList(record4));
        teams.add(giants);
        teamsRepository.save(giants);

        Character[] record = {'w','w','w','l','l','l','l','w','l','w','l','l','l','l','l','l','l'};
        Teams panthers = new Teams();
        panthers.setTeamName("Panthers");
        panthers.setRecord(Arrays.asList(record));
        teams.add(panthers);
        teamsRepository.save(panthers);

        Character[] record3 = {'w','l','l','l','l','l','l','l','w','w','w','w','w','w','w','l','w'};
        Teams dolphins = new Teams();
        dolphins.setTeamName("Dolphins");
        dolphins.setRecord(Arrays.asList(record3));
        teams.add(dolphins);
        teamsRepository.save(dolphins);

        Character[] record5 = {'w','w','w','l','l','l','l','w','w','l','w','l','w','l','l','l','l'};
        Teams broncos = new Teams();
        broncos.setTeamName("Broncos");
        broncos.setRecord(Arrays.asList(record5));
        teams.add(broncos);
        teamsRepository.save(broncos);

        Character[] record2 = {'w','w','w','l','w','w','w','w','l','l','l','w','w','w','w','w','l','w','w','w','w'};
        Teams rams = new Teams();
        rams.setTeamName("Rams");
        rams.setRecord(Arrays.asList(record2));
        teams.add(rams);
        teamsRepository.save(rams);

        Users ben = new Users();
        ben.setName("Ben");
        ben.setTotalPoints(0.0);
        ben.setTeams(teams);
        usersRepository.save(ben);
    }

    public void chrisTeams(){
        List<Teams> teams = new ArrayList<>();

        Character[] record = {'l','w','l','w','w','w','w','w','l','w','l','w','w','w','w','w','l','l'};
        Teams packers = new Teams();
        packers.setTeamName("Packers");
        packers.setRecord(Arrays.asList(record));
        teams.add(packers);
        teamsRepository.save(packers);

        Character[] record2 = {'w','l','w','w','w','l','l','w','l','w','l','w','w','l','l','w','l'};
        Teams chargers = new Teams();
        chargers.setTeamName("Chargers");
        chargers.setRecord(Arrays.asList(record2));
        teams.add(chargers);
        teamsRepository.save(chargers);

        Character[] record3 = {'l','w','w','w','l','l','w','l','w','l','w','l','w','l','l','l','w'};
        Teams browns = new Teams();
        browns.setTeamName("Browns");
        browns.setRecord(Arrays.asList(record3));
        teams.add(browns);
        teamsRepository.save(browns);

        Character[] record4 = {'l','w','l','l','w','l','w','w','w','w','w','w','w','l','l','w','l','l'};
        Teams patriots = new Teams();
        patriots.setTeamName("Patriots");
        patriots.setRecord(Arrays.asList(record4));
        teams.add(patriots);
        teamsRepository.save(patriots);

        Character[] record5 = {'w','l','l','l','l','l','l','l','l','w','l','l','l','w','w','l','l'};
        Teams texans = new Teams();
        texans.setTeamName("Texans");
        texans.setRecord(Arrays.asList(record5));
        teams.add(texans);
        teamsRepository.save(texans);

        Users chris = new Users();
        chris.setName("Chris");
        chris.setTotalPoints(0.0);
        chris.setTeams(teams);
        usersRepository.save(chris);
    }
}
