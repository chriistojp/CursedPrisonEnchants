package me.christo.enchants.Enchantments;

import me.drawethree.ultraprisoncore.UltraPrisonCore;
import me.drawethree.ultraprisoncore.api.enums.ReceiveCause;
import me.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import me.drawethree.ultraprisoncore.enchants.enchants.UltraPrisonEnchantment;
import me.drawethree.ultraprisoncore.gems.UltraPrisonGems;
import me.drawethree.ultraprisoncore.gems.api.UltraPrisonGemsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class GemFinder extends UltraPrisonEnchantment {

    private final double chance;

    public GemFinder() {
        super(UltraPrisonEnchants.getInstance(), 99);
        this.chance = this.getPlugin().getConfig().get().getDouble("enchants." + id + ".Chance");
    }

    //        this.chance = this.getPlugin().getConfig().get().getDouble("enchants." + id + ".Chance");

    @Override
    public String getAuthor() {
        return "christo";
    }

    @Override
    public void onEquip(Player player, ItemStack itemStack, int i) {

    }

    @Override
    public void onUnequip(Player player, ItemStack itemStack, int i) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent e, int enchantLevel) {

        if (this.chance * enchantLevel >= ThreadLocalRandom.current().nextDouble(100)) {

            UltraPrisonGems.getInstance().getGemsManager().giveGems(e.getPlayer(), 100, Bukkit.getConsoleSender(), ReceiveCause.GIVE);

            e.getPlayer().sendMessage(color("&d&lCursed&f&lPrison &8» &7Your gem finder enchant has found you gems!"));
        }

    }


    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
