package org.plugin.Team_Management.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Team;

public class ListTeamsCommand implements CommandExecutor {
    private final Team_Manager teamManager;

    public ListTeamsCommand(Team_Manager teamManager) {
        this.teamManager = teamManager;
    }
    @Override
    public boolean onCommand(CommandSender player, Command command, String s, String[] args) {
            if (teamManager.getTeams().isEmpty()) {
                player.sendMessage("Il n'y a pas d'équipe créer pour le moment.");
                return false;
            }
            else{
                for (String Team : teamManager.getTeams()) {
                    player.sendMessage(Team);
                }
            }
        return true;
    }
}
