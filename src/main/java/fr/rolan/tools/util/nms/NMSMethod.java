package fr.rolan.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityBat;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityEquipment;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

public class NMSMethod {
	/**
     * Send title
     *
     * @param player Player
     * @param fadeIn Fade in time (in ticks)
     * @param stay Stay time (in ticks)
     * @param fadeOut Fade out time (in ticks)
     * @param title Title text
     * @param subtitle Subtitle text
     */
    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle)
    {
        Reflection.sendPacket(player, new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut));

        if (subtitle != null)
        {
            subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
            subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);

            Reflection.sendPacket(player, new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}")));
        }

        if (title != null)
        {
            title = title.replaceAll("%player%", player.getDisplayName());
            title = ChatColor.translateAlternateColorCodes('&', title);

            Reflection.sendPacket(player, new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}")));
        }
    }

    /**
     * Send tab title
     *
     * @param player Player
     * @param header Header line
     * @param footer Footer line
     */
    public static void setTablistHeaderFooter(Player player, String header, String footer)
    {
        if (header == null) header = "";
        header = ChatColor.translateAlternateColorCodes('&', header);

        if (footer == null) footer = "";
        footer = ChatColor.translateAlternateColorCodes('&', footer);

        header = header.replaceAll("%player%", player.getDisplayName());
        footer = footer.replaceAll("%player%", player.getDisplayName());

        try
        {
            PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
            Reflection.setField(packet.getClass().getDeclaredField("a"), packet, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + header + "\"}"));
            Reflection.setField(packet.getClass().getDeclaredField("b"), packet, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + footer + "\"}"));

            Reflection.sendPacket(player, packet);
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void sendActionbar(Player p, String message) {
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte) 2);
		
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(bar);
	}
    
    public static String getPingColor(Player player) {
		EntityPlayer nmsPlayer = ((CraftPlayer) player).getHandle();
		if(nmsPlayer.ping < 80) {
			return String.valueOf("§a"+nmsPlayer.ping+"ms");
		}else if(nmsPlayer.ping < 120) {
			return String.valueOf("§2"+nmsPlayer.ping+"ms");
		}else if(nmsPlayer.ping < 180) {
			return String.valueOf("§6"+nmsPlayer.ping+"ms");
		}else if(nmsPlayer.ping < 500) {
			return String.valueOf("§c"+nmsPlayer.ping+"ms");
		}else {
			return String.valueOf("§4"+nmsPlayer.ping+"ms");
		}
	}
    
    public static void disableF3(Player player) {
		try {
	    	Class<?> packetClass = Reflection.getNMSClass("PacketPlayOutEntityStatus");
			Constructor<?> packetConstructor = packetClass.getConstructor(new Class[] { Reflection.getNMSClass("Entity"), Byte.TYPE });
			Object packet = packetConstructor.newInstance(new Object[] { ((CraftPlayer) player).getHandle(), Byte.valueOf((byte) 22) });
			Method sendPacket = Reflection.getNMSClass("PlayerConnection").getMethod("sendPacket", new Class[] { Reflection.getNMSClass("Packet") });
			Field conField = ((CraftPlayer) player).getHandle().getClass().getField("playerConnection");
			Object con = conField.get(((CraftPlayer) player).getHandle());
			sendPacket.invoke(con, new Object[] { packet });
		} catch (NoSuchMethodException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: NoSuchMethod !");
		} catch (SecurityException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: SecurityException !");
		} catch (InstantiationException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: InstantiationException !");
		} catch (IllegalAccessException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: IllegalAccess !");
		} catch (IllegalArgumentException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: IllegalArgument !");
		} catch (InvocationTargetException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: InvocationTarget !");
		} catch (NoSuchFieldException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: NoSuchField !");
		}
	}
    
    public static void enableF3(Player player) {
		try {
			Class<?> packetClass = Reflection.getNMSClass("PacketPlayOutEntityStatus");
			Constructor<?> packetConstructor = packetClass.getConstructor(new Class[] { Reflection.getNMSClass("Entity"), Byte.TYPE });
			Object packet = packetConstructor.newInstance(new Object[] { ((CraftPlayer) player).getHandle(), Byte.valueOf((byte) 23) });
			Method sendPacket = Reflection.getNMSClass("PlayerConnection").getMethod("sendPacket", new Class[] { Reflection.getNMSClass("Packet") });
			Field conField = ((CraftPlayer) player).getHandle().getClass().getField("playerConnection");
			Object con = conField.get(((CraftPlayer) player).getHandle());
			sendPacket.invoke(con, new Object[] { packet });
		} catch (NoSuchMethodException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: NoSuchMethod !");
		} catch (SecurityException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: SecurityException !");
		} catch (InstantiationException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: InstantiationException !");
		} catch (IllegalAccessException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: IllegalAccess !");
		} catch (IllegalArgumentException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: IllegalArgument !");
		} catch (InvocationTargetException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: InvocationTarget !");
		} catch (NoSuchFieldException e) {
			Bukkit.getConsoleSender().sendMessage("§c[§6No§ePos§c] §4Error: NoSuchField !");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void disguiseInPNJ(Player p) {
		try {
			Class entityClass = Reflection.getNMSClass("EntityVillager");
	        Constructor constructor = entityClass.getConstructor(World.class);
	        World world = ((CraftWorld) p.getWorld()).getHandle();
	        Entity entity = (Entity) constructor.newInstance(world);
	        EntityVillager villager = (EntityVillager) entity;
	        villager.d(p.getEntityId());
	        villager.setCustomNameVisible(false);
	        villager.setPosition(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
	        villager.setLocation(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
	        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(p.getEntityId());
	        PacketPlayOutPlayerInfo packetPlayOutPlayerInfo = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER);
	        PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving(villager);
	        for (Player players : Bukkit.getOnlinePlayers()) {
	            if (!players.equals(p)) {
	            	Reflection.sendPacket(players, packetPlayOutEntityDestroy);
	            	Reflection.sendPacket(players, packetPlayOutPlayerInfo);
	                Reflection.sendPacket(players, packetPlayOutSpawnEntityLiving);
	            }
	        }
		}catch(IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void disguiseInBat(Player p) {
		try {
			Class entityClass = Reflection.getNMSClass("EntityBat");
	        Constructor constructor = entityClass.getConstructor(World.class);
	        World world = ((CraftWorld) p.getWorld()).getHandle();
	        Entity entity = (Entity) constructor.newInstance(world);
	        EntityBat bat = (EntityBat) entity;
	        bat.setCustomName(p.getName());
			bat.setCustomNameVisible(true);
			bat.setAsleep(false);
	        bat.setLocation(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
    		p.setAllowFlight(true);
    		p.setFlying(true);
			p.setMaxHealth(4);
	        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(p.getEntityId());
	        PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving(bat);
	        try {
				Reflection.setField(packetPlayOutSpawnEntityLiving.getClass().getDeclaredField("a"), packetPlayOutSpawnEntityLiving,  ((CraftPlayer)p).getHandle().getId());
			}catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
	        for (Player players : Bukkit.getOnlinePlayers()) {
	            if (!players.equals(p)) {
	                Reflection.sendPacket(players, packetPlayOutEntityDestroy);
	                Reflection.sendPacket(players, packetPlayOutSpawnEntityLiving);
	            }
	        }
		}catch(IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
	}
	
	public static void undisguise(Player p) {
        PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(p.getEntityId());
        PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(((CraftPlayer)p).getHandle());
        PacketPlayOutEntityEquipment helmet = new PacketPlayOutEntityEquipment(p.getEntityId(), 4, CraftItemStack.asNMSCopy(p.getInventory().getHelmet()));
        PacketPlayOutEntityEquipment chestplate = new PacketPlayOutEntityEquipment(p.getEntityId(), 3, CraftItemStack.asNMSCopy(p.getInventory().getChestplate()));
        PacketPlayOutEntityEquipment leggings = new PacketPlayOutEntityEquipment(p.getEntityId(), 2, CraftItemStack.asNMSCopy(p.getInventory().getLeggings()));
        PacketPlayOutEntityEquipment boots = new PacketPlayOutEntityEquipment(p.getEntityId(), 1, CraftItemStack.asNMSCopy(p.getInventory().getBoots()));
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (!players.equals(p)) {
            	Reflection.sendPacket(players, destroy);
            	Reflection.sendPacket(players, spawn);
            	Reflection.sendPacket(players, helmet);
            	Reflection.sendPacket(players, chestplate);
            	Reflection.sendPacket(players, leggings);
            	Reflection.sendPacket(players, boots);
            }
        }
    }
}
