package fr.rolan.tools.pregeneration;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class EventChunkUnload implements Listener {
	
	public static List<Chunk> keepChunk = new ArrayList<>();
	
	@EventHandler
	public void onChunkUnload(ChunkUnloadEvent e) {
		if (keepChunk.contains(e.getChunk()))
			e.setCancelled(true); 
   }
}