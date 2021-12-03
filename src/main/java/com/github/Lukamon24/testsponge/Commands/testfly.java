package com.github.Lukamon24.testsponge.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class testfly implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            if(player.hasPermission("testsponge.fly")) {
                if(player.get(Keys.GAME_MODE).equals(GameModes.SURVIVAL)) {
                    player.offer(Keys.CAN_FLY, true);
                    player.sendMessage(Text.of(TextColors.AQUA, "Flight enabled!"));
                }
                else {
                    player.sendMessage(Text.of(TextColors.RED, "Please check if you are in the right gamemode!"));
                }
            }
            else {
                player.sendMessage(Text.of(TextColors.DARK_RED, "No Permission!"));
            }
        }
        else if(src instanceof ConsoleSource) {
            src.sendMessage(Text.of(TextColors.DARK_RED, "You need to be a player to do this!"));
        }
        return CommandResult.success();
    }
}


