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

import dev.kisca.modlistmaker.util.ListHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class ListToClipboard {

    public static void copyList(boolean alphabetical) {
        try {
            String text = ListHelper.getList(alphabetical);

            Keyboard kb = new Keyboard(MinecraftClient.getInstance());
            kb.setClipboard(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
