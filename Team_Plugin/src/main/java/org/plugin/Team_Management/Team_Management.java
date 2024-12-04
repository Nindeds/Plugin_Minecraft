package org.plugin.Team_Management;
import org.bukkit.plugin.java.JavaPlugin;
import org.plugin.Team_Management.commands.*;
import org.plugin.Team_Management.listener.TeamMenuListener;

public class Team_Management extends JavaPlugin {

    private Team_Manager teamManager;

    @Override
    public void onEnable() {
        teamManager = new Team_Manager();
        getLogger().info("Team_Managemenet est activé !");
        // add command
        getCommand("addteam").setExecutor(new AddTeamCommand(teamManager));
        getCommand("removeteam").setExecutor(new RemoveTeamCommand(teamManager));
        getCommand("listteams").setExecutor(new ListTeamsCommand(teamManager));
        getCommand("teammenu").setExecutor(new TeamMenu(teamManager));
        // add listener
        getServer().getPluginManager().registerEvents(new TeamMenuListener(), this);
        getLogger().info("Listener est activé");
    }

    @Override
    public void onDisable() {
        getLogger().info("Team_Management est désactivé !");
    }
}
