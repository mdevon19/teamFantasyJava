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

    public List<Users> initalCall() {
        List<Users> users = (List<Users>) usersRepository.findAll();
        int total;

        for(Users user : users){
            total = 0;
            for(Teams team : user.getTeams()){
                total = total + team.getPoints();
            }
            user.setTotalPoints(total);
        }
        return users;
    }

    public Map<String, Integer> getRankings() {
        Map<String, Integer> rankingMap = new HashMap<>();
        List<Users> users = initalCall();
        List<Teams> undraftedTeams = new ArrayList<>();
        for(Users user: users) {
            if(user.getName().equals("Undrafted")){
                undraftedTeams.addAll(user.getTeams());
            }
        }
        int winCount;
        int worseTeams1Count;
        int worseTeams2Count;
        int team1WinCount = 0;
        for(Character character: undraftedTeams.get(0).getRecord()){
            if(character.equals('w')){
                team1WinCount++;
            }
        }
        int team2WinCount = 0;
        for(Character character: undraftedTeams.get(1).getRecord()){
            if(character.equals('w')){
                team2WinCount++;
            }
        }
        int runningNegTotal1;
        int runningNegTotal2;
        for(Users user: users){
            if(user.getName().equals("Undrafted")){
                continue;
            }
            System.out.println(user.getName() + " has: " + user.getTotalPoints());
            worseTeams1Count = 0;
            worseTeams2Count = 0;
            runningNegTotal1 = 0;
            runningNegTotal2 = 0;

            for(Teams team: user.getTeams()){
                winCount = 0;

                for(Character character: team.getRecord()){
                    if (character.equals('w')){
                        winCount++;
                    }
                }
                if(team1WinCount > winCount){
                    runningNegTotal1 = runningNegTotal1 + ((team1WinCount-winCount) * 10);
                    worseTeams1Count++;
                }
                if(team2WinCount > winCount) {
                    runningNegTotal2 = runningNegTotal2 + ((team2WinCount-winCount) * 10);
                    worseTeams2Count++;
                }
            }
            int totalNeg = (runningNegTotal1 * worseTeams1Count) + (runningNegTotal2 * worseTeams2Count);
            System.out.println(user.getName() + " is getting: " + totalNeg + " in penalty points");

            rankingMap.put(user.getName(), (int) (user.getTotalPoints()-totalNeg));
        }

        return rankingMap;


    }

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


