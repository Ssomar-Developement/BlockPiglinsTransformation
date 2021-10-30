package com.ssomar.blockpiglinstransformation.events;

import com.ssomar.blockpiglinstransformation.BlockPiglinsTransformation;


public class EventsHandler {
	
	private static EventsHandler instance;
	
	private BlockPiglinsTransformation main;
	
	public void setup(BlockPiglinsTransformation main) {
		this.main = main;
		setupEvents();
	}
	
	public void setupEvents() {

		main.getServer().getPluginManager().registerEvents(new EntityEvt(), main);
		
	}

	public static EventsHandler getInstance() {
	    if (instance == null) instance = new EventsHandler();
	    return instance;
	 }
}
