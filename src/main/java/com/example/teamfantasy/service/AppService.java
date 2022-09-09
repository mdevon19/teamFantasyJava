package com.example.teamfantasy.service;

import com.example.teamfantasy.dto.Teams;
import com.example.teamfantasy.dto.Users;
import com.example.teamfantasy.repository.TeamsRepository;
import com.example.teamfantasy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppService {

    private static final int WIN_POINTS = 10;
    private static final int TIE_POINTS = 5;
    private static final int TOP_SEED = 5;
    private static final int DIV_WINNER = 5;
    private static final int WILD_CARD = 15;
    private static final int FIRST_ROUND_WIN = 15;
    private static final int DIVISION_ROUND_WIN = 20;
    private static final int CONFERENCE_CHAMP = 25;
    private static final int SUPER_BOWL_WIN = 30;

    //negative 10 points per win over your teams record
    //if you have more than one team with a worse record, multiply by number of worse teams


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TeamsRepository teamsRepository;

    public List<String> getAllUsers(){
        List<String> responses = new ArrayList<>();


        List<Users> users = (List<Users>) usersRepository.findAll();
        users.forEach(user -> {
            String str;
            str = user.getName() + " has a total of: " + user.getTotalPoints() + "pts";
            responses.add(str);
        });
        return responses;
    }

    public List<String> justTeamsAndPoints(){
        List<String> stuff = new ArrayList<>();
        List<Teams> teams = (List<Teams>) teamsRepository.findAll();

        teams.forEach(team -> {
            teamsRepository.save(calculatePointsByTeam(team));
        });
        teams.forEach(team -> {
            String info = team.getTeamName() +": "+ team.getPoints();
            stuff.add(info);
        });
        return stuff;
    }

    public List<Teams> getAllTeams(){
        Iterable<Teams> teams = teamsRepository.findAll();
        teams.forEach(team -> {
            teamsRepository.save(calculatePointsByTeam(team));
        });

        return (List<Teams>) teams;
    }

//    public double getPointsbyUser(String name){
//        Optional<Users> opt = usersRepository.findById(name);
//        Users devon = opt.get();
//        return calculatePoints(devon);
//
//    }

    public static Teams calculatePointsByTeam(Teams team) {
        int streak = 1;
        int count = 0;
        for (char game : team.getRecord()) {
            if (count == 18 && game == 'w') {
                team.setPoints(team.getPoints() + WILD_CARD + FIRST_ROUND_WIN);
                continue;
            } else if (count == 18) {
                team.setPoints(team.getPoints() + WILD_CARD);
                continue;
            }
            if (count == 19 && game == 'w') {
                team.setPoints(team.getPoints() + DIVISION_ROUND_WIN);
                continue;
            }
            if (count == 20 && game == 'w') {
                team.setPoints(team.getPoints() + CONFERENCE_CHAMP);
                continue;
            }
            if (count == 21 && game == 'w') {
                team.setPoints(team.getPoints() + SUPER_BOWL_WIN);
                continue;
            }
            if (game == 'w') {
                    if (streak == 1) {
                        team.setPoints(team.getPoints() + WIN_POINTS);
                    }
                    if (streak > 1) {
                        team.setPoints(team.getPoints() + WIN_POINTS + streak);
                    }
                    streak++;
                } else if (game == 't') {
                    team.setPoints(team.getPoints() + TIE_POINTS);
                    streak = 1;
                } else {
                    streak = 1;
                }
                count++;
            }
        return team;
        }

    }

//    public static double calculatePoints(Users user){
//
//        user.getTeams().forEach(team -> {
//            int streak = 0;
//            for (char game: team.getRecord()){
//                if(game == 'w'){
//                    user.setTotalPoints(user.getTotalPoints() + WIN_POINTS + streak);
//                    streak++;
//                } else {
//                    streak = 0;
//                }
//            }
//
//        });
//
//        return user.getTotalPoints();
//
//    }


