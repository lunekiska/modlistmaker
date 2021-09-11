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

package dev.kisca.modlistmaker;

import dev.kisca.modlistmaker.command.CopyCommand;
import dev.kisca.modlistmaker.command.SaveCommand;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

/**
 * Represents ModListMaker mod.
 *
 * @author Lunekiska
 * @version 1.0.0
 * @since 1.0.0
 */
@Environment(EnvType.CLIENT)
public final class ModListMaker implements ModInitializer {
    public static final String NAMESPACE = "modlistmaker";

    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            if (!dedicated) {
                CopyCommand.register(dispatcher);
                SaveCommand.register(dispatcher);
            }
        });
    }
}