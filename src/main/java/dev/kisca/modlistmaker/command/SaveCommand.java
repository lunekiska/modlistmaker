/*
 * Copyright (c) 2021 Lunekiska <kiscaatwork@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package dev.kisca.modlistmaker.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.kisca.modlistmaker.ListToFile;
import dev.kisca.modlistmaker.util.MessageHelper;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class SaveCommand implements Command<ServerCommandSource> {
    private static final SaveCommand CMD = new SaveCommand();

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
            dispatcher.register(CommandManager.literal("lm-save")
                    .requires(cs -> cs.hasPermissionLevel(0))
                    .then(CommandManager.argument("alphabetical", BoolArgumentType.bool())
                            .executes(CMD)));
    }

    @Override
    public int run(CommandContext<ServerCommandSource> context) {
        boolean alphabetical = BoolArgumentType.getBool(context, "alphabetical");

            ListToFile.saveList(alphabetical);

            return SINGLE_SUCCESS;
        }
}
