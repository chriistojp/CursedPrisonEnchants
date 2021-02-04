package me.christo.enchants.Enchantments;


import me.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import me.drawethree.ultraprisoncore.enchants.enchants.UltraPrisonEnchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class TrophyFinder extends UltraPrisonEnchantment {

    private final double chance;

    public TrophyFinder() {
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
            e.getPlayer().sendMessage("You have triggered the enchant!");
        }

    }


    //lol

}
