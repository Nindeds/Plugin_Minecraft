package org.plugin.Team_Management.commands;
import java.util.HashSet;
import java.util.Set;

public class Team_Manager {

    private final Set<String> teams = new HashSet<>();

    public boolean addTeam(String teamName) {
        return teams.add(teamName);
    }
    public boolean hasTeam(String teamName) {
        return teams.contains(teamName);
    }

    public boolean removeTeam(String teamName) {
        return teams.remove(teamName);
    }
    public Set<String> getTeams() {
        return teams;
    }
}
