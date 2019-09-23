package me.hassantahan.slapplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Started the Slap Plugin; dev: MrMineHeads");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Slap Plugin Stopped");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("slap"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (player.hasPermission("slapplugin.slap"))
                {
                    if (args.length != 0)
                    {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target == null)
                            player.sendMessage("Player is not online.");
                        else
                        {
                            player.sendMessage(args[0] + " was successfully slapped!");
                            target.sendMessage("You were slapped by " + player.getDisplayName() + "!");
                            target.damage(0.2);
                        }
                    }
                    else
                    {
                        player.sendMessage("Stop hitting yourself!");
                        player.damage(0.2);
                    }
                }
            }
            else
            {
                System.out.println("HOW CAN SHE SLAP?!");
            }
        }
        return true;
    }
}