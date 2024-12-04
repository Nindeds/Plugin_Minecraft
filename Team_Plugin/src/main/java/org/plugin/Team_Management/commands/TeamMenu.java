package org.plugin.Team_Management.commands;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class TeamMenu implements CommandExecutor {

    private final Team_Manager teamManager;

    public TeamMenu(Team_Manager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Cette commande doit être exécutée par un joueur !");
            return true; //check if user is a player or not
        }
        Player player = (Player) commandSender;

        //create chestmenue
        Inventory chestMenu = Bukkit.createInventory(null, 27, "Gestion des équipes");
        int slot = 0;
        for(String team : teamManager.getTeams()) {
            ItemStack Team = new ItemStack(Material.EMERALD);
            ItemMeta meta = Team.getItemMeta();
            meta.setDisplayName(team);
            Team.setItemMeta(meta);
            chestMenu.setItem(slot, Team);
            slot++;
        }
        player.openInventory(chestMenu);

        return true;
    }
}




