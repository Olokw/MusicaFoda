package net.olokw.musicafoda.Commands;

import net.olokw.musicafoda.MusicaFoda;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {
    private static final List<String> LIST = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender instanceof Player){
                if (!sender.isOp()) return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage("Recarregando plugin...");
                MusicaFoda.instance.getConfigLoader().load();
            }
        }

        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

        if (args.length == 1) {
            if (sender instanceof Player) {
                LIST.clear();
                LIST.add("reload");
            }
        }

        return StringUtil.copyPartialMatches(args[args.length - 1], LIST, new ArrayList<>());
    }
}
