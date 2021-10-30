package com.ssomar.blockpiglinstransformation.events;


import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinAbstract;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;

public class EntityEvt implements Listener {

	 @EventHandler
	 public void onEntityTransformEvent(EntityTransformEvent e) {

	 	Entity entity = e.getEntity();

	 	if(entity instanceof PiglinAbstract){
	 		e.setCancelled(true);
	 		((PiglinAbstract) entity).setImmuneToZombification(true);
		}
	 }
}
