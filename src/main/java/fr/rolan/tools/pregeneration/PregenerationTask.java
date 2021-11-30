package fr.rolan.tools.pregeneration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import fr.rolan.api.UHCAPI;
import fr.rolan.tools.NMSMethod;

public class PregenerationTask extends BukkitRunnable {
	
	private Double percent;
	private Double currentChunkLoad;
	private Double totalChunkToLoad;
	
	private Integer cx;
	private Integer cz;
	private Integer mx;
	private Integer mz;
	private Integer radius;
	private World world;
	private Boolean finished;
	
	public PregenerationTask(World world, Integer r) {
		r+=150;
		this.percent = Double.valueOf(0.0D);
		this.totalChunkToLoad = Double.valueOf(Math.pow(r.intValue(), 2.0D) / 64.0D);
		this.currentChunkLoad = Double.valueOf(0.0D);
		this.cx = Integer.valueOf(world.getSpawnLocation().getBlockX()-r.intValue());
		this.cz = Integer.valueOf(world.getSpawnLocation().getBlockZ()-r.intValue());
		this.world = world;
		this.radius = r;
		this.mx = Integer.valueOf(r.intValue()+world.getSpawnLocation().getBlockX());
		this.mz = Integer.valueOf(r.intValue()+world.getSpawnLocation().getBlockZ());
		this.finished = Boolean.valueOf(false);
		Bukkit.broadcastMessage("§8[§cPregen§8] §fLancement de la pré-génération");
		runTaskTimer(UHCAPI.get().getPlugin(), 0L, 5L);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 30 && !this.finished.booleanValue(); i++) {
			Location loc = new Location(this.world, this.cx.intValue(), 0.0D, this.cz.intValue());
			if (!loc.getChunk().isLoaded())
				loc.getWorld().loadChunk(loc.getChunk().getX(), loc.getChunk().getZ(), true);
			this.cx+=16;
			this.currentChunkLoad = Double.valueOf(this.currentChunkLoad.doubleValue() + 1.0D);
			if(this.cx.intValue() > this.mx.intValue()) {
				this.cx = Integer.valueOf(world.getSpawnLocation().getBlockX()-this.radius.intValue());
				this.cz+=16;
				if(this.cz.intValue() > this.mz.intValue()) {
					this.currentChunkLoad = this.totalChunkToLoad;
					this.finished = Boolean.valueOf(true);
				}
			}
		}
		this.percent = Double.valueOf(this.currentChunkLoad.doubleValue() / this.totalChunkToLoad.doubleValue() * 100.0D);
		Bukkit.getOnlinePlayers().forEach(players -> NMSMethod.sendActionbar(players, "§fPré-génération §8» [§r"+UHCAPI.get().getGameManager().getProgressBar(this.percent.intValue(), 100, 20, "|", "§c", "§f")+"§8] §c"+this.percent.intValue()+"%"));
		if(this.finished.booleanValue()) {
			Bukkit.broadcastMessage("§8[§cPregen§8] §fLa pré-génération est terminée !");
			cancel();
		}
	}
}