package fr.rolan.tools;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

public class ItemUtils {
	/**
     * Get the given player's username head
     *
     * @param player Player's username
     *
     * @return Player's head
     */
    public static ItemStack getPlayerHead(String player)
    {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwner(player);
        head.setItemMeta(meta);

        return head;
    }

    /**
     * Create a player head with a base64 encoded texture
     *
     * @param texture Base64 texture
     *
     * @return A custom head with your texture
     */
    public static ItemStack getCustomHead(String texture)
    {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();

        try
        {
            Reflection.setValue(headMeta, "profile", getHeadCustomizedGameProfile(texture));
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * Create a {@link GameProfile} instance with a base64 encoded texture
     *
     * @param texture Base64 texture
     *
     * @return A custom {@link GameProfile} instance with your texture
     */
    public static GameProfile getHeadCustomizedGameProfile(String texture)
    {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();

        if (propertyMap == null)
            throw new IllegalStateException("Profile doesn't contain a property map");

        byte[] encodedData = texture.getBytes();
        propertyMap.put("textures", new Property("textures", new String(encodedData)));

        return profile;
    }
}
