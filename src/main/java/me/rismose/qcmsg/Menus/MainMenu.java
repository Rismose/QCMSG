package me.rismose.qcmsg.Menus;

import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.rismose.qcmsg.QCMSG;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MainMenu implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

            // MAIN GUI
            Gui gui = new Gui(3, "Main Menu");
            gui.setDefaultClickAction(event -> {
                event.setCancelled(true);
            });
            // ZOMBIE GUI
            Gui zombiegui = new Gui(4, "Zombie Menu");
            zombiegui.setDefaultClickAction(event -> {
                event.setCancelled(true);
            });
            // MAIN GUI ITEMS
            GuiItem ZHead = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Zombie Menu").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                zombiegui.open(player);

            });
            GuiItem Close = ItemBuilder.from(Material.RED_WOOL).setName(ChatColor.RED + "Close").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                gui.close(player);

            });
            GuiItem Back = ItemBuilder.from(Material.GRAY_WOOL).setName(ChatColor.RED + "Back").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                gui.open(player);

            });
            // ZOMBIE GUI ITEMS
            GuiItem ZSpawn = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Spawn Normal Zombie").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(QCMSG.ZombieNormalSpawn)));
                spawnZombie(player.getLocation(), EntityType.ZOMBIE);

            });
            GuiItem Flower = ItemBuilder.from(Material.POPPY).setName(ChatColor.YELLOW + "NOTE: Spawns a default Zombie").asGuiItem();
            GuiItem ZHelmSpawn = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Spawn Zombie With Helmet").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', QCMSG.ZombieHelmetSpawn));
                spawnHelmetZombie(player.getLocation(), player);

            });
            GuiItem IronHelmet = ItemBuilder.from(Material.IRON_HELMET).setName(ChatColor.YELLOW + "NOTE: Spawns a Zombie with helmet").asGuiItem();
            GuiItem ZChestSpawn = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Spawn Zombie with Chestplate").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', QCMSG.ZombieChestSpawn));
                spawnChestZombie(player.getLocation(), player);

            });
            GuiItem IronChestplate = ItemBuilder.from(Material.IRON_CHESTPLATE).setName(ChatColor.YELLOW + "NOTE: Spawns a Zombie with chestplate").asGuiItem();
            GuiItem ZLeggingSpawn = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Spawn Zombie with Leggings").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', QCMSG.ZombieLeggingSpawn));
                spawnLeggingZombie(player.getLocation(), player);

            });
            GuiItem IronLeggings = ItemBuilder.from(Material.IRON_LEGGINGS).setName(ChatColor.YELLOW + "NOTE: Spawns a Zombie with leggings").asGuiItem();
            GuiItem ZBootSpawn = ItemBuilder.from(Material.ZOMBIE_HEAD).setName(ChatColor.YELLOW + "Spawn Zombie with Boots").asGuiItem(event -> {

                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', QCMSG.ZombieBootSpawn));
                spawnBootZombie(player.getLocation(), player);

            });
            GuiItem IronBoots = ItemBuilder.from(Material.IRON_BOOTS).setName(ChatColor.YELLOW + "NOTE: Spawns a Zombie with Boots").asGuiItem();


            GuiItem IHelm = new GuiItem(new ItemStack(Material.IRON_HELMET));

            // MAIN GUI SET ITEMS
            gui.setItem(13, ZHead);
            gui.setItem(26, Close);
            gui.getFiller().fill(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName(" ").asGuiItem());
            // ZOMBIE GUI SET ITEMS
            zombiegui.setItem(9, ZSpawn);
            zombiegui.setItem(11,ZHelmSpawn);
            zombiegui.setItem(13,ZChestSpawn);
            zombiegui.setItem(15, ZLeggingSpawn);
            zombiegui.setItem(17, ZBootSpawn);
            zombiegui.setItem(18, Flower);
            zombiegui.setItem(20, IronHelmet);
            zombiegui.setItem(22, IronChestplate);
            zombiegui.setItem(24, IronLeggings);
            zombiegui.setItem(26, IronBoots);
            zombiegui.setItem(35, Back);
            zombiegui.getFiller().fill(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName(" ").asGuiItem());

            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("qc.menu")) {
                    if (command.getName().equalsIgnoreCase("QC")) {
                        gui.open(player);
                    }
                }
            }


        return true;
    }


    private void spawnZombie(Location loc, EntityType zombie) {
        loc.getWorld().spawnEntity(loc, zombie);
    }

    public void spawnHelmetZombie(Location loc, Player player) {
        Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        LivingEntity mob = (LivingEntity) zombie;
        ItemStack item = new ItemStack(Material.IRON_HELMET);
        mob.getEquipment().setHelmet(item);
    }

    public void spawnChestZombie(Location loc, Player player) {
        Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        LivingEntity mob = (LivingEntity) zombie;
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        mob.getEquipment().setChestplate(item);
    }

    public void spawnLeggingZombie(Location loc, Player player) {
        Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        LivingEntity mob = (LivingEntity) zombie;
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
        mob.getEquipment().setLeggings(item);
    }

    public void spawnBootZombie(Location loc, Player player) {
        Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        LivingEntity mob = (LivingEntity) zombie;
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        mob.getEquipment().setBoots(item);
    }
}
