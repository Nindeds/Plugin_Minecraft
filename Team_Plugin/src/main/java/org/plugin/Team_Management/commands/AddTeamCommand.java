package org.plugin.Team_Management.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AddTeamCommand implements CommandExecutor {

    private final Team_Manager teamManager;

    public AddTeamCommand(Team_Manager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender player, Command command, String label, String[] args) {
        // verify if user used command wrong or not
        if (args.length == 0) {
            player.sendMessage("Usage : /addteam <nom>");
            return false;
        }

        // take user team name
        String teamName = args[0];

        //add team and verify if team already exist
        if (teamManager.addTeam(teamName)) {
            player.sendMessage("L'équipe " + teamName + " a été ajoutée !");
        } else {
            player.sendMessage("L'équipe " + teamName + " existe déjà.");
        }

        return true;
    }
}
