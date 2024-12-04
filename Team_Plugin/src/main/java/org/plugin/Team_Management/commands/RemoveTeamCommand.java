package org.plugin.Team_Management.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RemoveTeamCommand implements CommandExecutor {

    private final Team_Manager teamManager;

    public RemoveTeamCommand(Team_Manager teamManager){ //access teamManager class
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender player, Command command, String label, String[] args) {
        //look if user added team name if not return false
        if (args.length == 0) {
            player.sendMessage("Usage : /removeteam < équipe nom>");
            return false;
        }
        //take teamname that have to be removed
        String teamName = args[0];

        //verify if teamName is in teamManager List and remove it if true
        if (teamManager.hasTeam(teamName)){
            teamManager.removeTeam(teamName);
            player.sendMessage("L'équipe " + teamName + " a été retirer avec succès");
        }else
        {
            player.sendMessage("L'équipe " + teamName + " n'existe pas");
            return false;
        }
        return true;
    }

}
