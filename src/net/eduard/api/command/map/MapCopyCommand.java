
package net.eduard.api.command.map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.lib.Mine;
import net.eduard.api.lib.game.Schematic;
import net.eduard.api.lib.manager.CommandManager;

public class MapCopyCommand extends CommandManager {

	public MapCopyCommand() {
		super("copy","copiar");
		setDescription("Copia os blocos da posição 1 a posção 2");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (Mine.onlyPlayer(sender)) {
			Player p = (Player) sender;
			Schematic schema = Mine.getSchematic(p);
			
			if (!schema.hasFirstLocation()) {
				p.sendMessage("§bEduardAPI §aPosicao 1 nao foi setada!");
				return true;
			}
			if (!schema.hasSecondLocation()) {
				p.sendMessage("§bEduardAPI §aPosicao 2 nao foi setada!");
				return true;
			}
			schema.copy(p.getLocation());
			p.sendMessage("§bEduardAPI §aMapa copiado!");
		}
		return true;
	}

}
