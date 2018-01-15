package nl.Steffion.BlockHunt.Listeners;

import nl.Steffion.BlockHunt.Arena;
import nl.Steffion.BlockHunt.MemoryStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnFoodLevelChangeEvent implements Listener {

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
		Player player = (Player) event.getEntity();

		for (Arena arena : MemoryStorage.arenaList) {
			if (arena.playersInArena.contains(player)) {
				event.setCancelled(true);
			}
		}
	}
}
