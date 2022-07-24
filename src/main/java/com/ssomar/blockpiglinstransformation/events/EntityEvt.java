package com.ssomar.blockpiglinstransformation.events;


import com.ssomar.blockpiglinstransformation.BlockPiglinsTransformation;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinAbstract;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityEvt implements Listener {

    @EventHandler
    public void onEntityTransformEvent(EntityTransformEvent e) {

        Entity entity = e.getEntity();
		Entity trans = e.getTransformedEntity();
		//entity.getServer().broadcastMessage("entity: " + entity.getType());

		PiglinAbstract p = null;
        if (entity instanceof PiglinAbstract) {
			p = (PiglinAbstract)entity;
            e.setCancelled(true);
            ((PiglinAbstract) entity).setImmuneToZombification(true);
        }
		else return;

		final PiglinAbstract piglin = p;


		if(trans instanceof PigZombie){
			PigZombie pg = (PigZombie) trans;
			//entity.getServer().broadcastMessage("trans: -> pigzombie");
			EntityEquipment equipment = pg.getEquipment();
			ItemStack mainHand = equipment.getItemInMainHand();
			//entity.getServer().broadcastMessage("mainHand: " + mainHand.getType());
			ItemStack offHand = equipment.getItemInOffHand();
			//entity.getServer().broadcastMessage("offHand: " + offHand.getType());
			ItemStack helmet = equipment.getHelmet();
			ItemStack chestplate = equipment.getChestplate();
			ItemStack leggings = equipment.getLeggings();
			ItemStack boots = equipment.getBoots();

			BukkitRunnable runnable3 = new BukkitRunnable() {
				@Override
				public void run() {
					EntityEquipment equipment = piglin.getEquipment();
					equipment.setItemInMainHand(mainHand);
					equipment.setItemInOffHand(offHand);
					equipment.setHelmet(helmet);
					equipment.setChestplate(chestplate);
					equipment.setLeggings(leggings);
					equipment.setBoots(boots);
				}
			};
			runnable3.runTaskLater(BlockPiglinsTransformation.plugin, 2);
		}
    }
}
