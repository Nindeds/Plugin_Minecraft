package org.plugin.Team_Management.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TeamMenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Gestion des équipes")) {
            return; // ignore click on other inventory
        }
        event.setCancelled(true); // cant move item in chestmenu
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
            return;
        }
        player.sendMessage("Vous avez cliqué sur l'équipe : " + clickedItem.getItemMeta().getDisplayName());
    }
}
