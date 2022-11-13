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

package dev.kisca.modlistmaker.util;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;

public class ListHelper {
    public static String getList(boolean alphabetical) {
        Collection<ModContainer> mods = FabricLoader.getInstance().getAllMods();
        ArrayList<String> modStrings = new ArrayList<>();

        for (ModContainer mod : mods) {
            modStrings.add(String.format(mod.getMetadata().getName() + " ☛ " + mod.getMetadata().getId() + " : " + mod.getMetadata().getVersion() + System.lineSeparator()));
        }

        if (alphabetical)
            modStrings.sort(Collator.getInstance());

        StringBuilder builder = new StringBuilder();

        for (String value : modStrings) {
            builder.append(value);
        }

        String str = builder.toString();
        str = str.substring(0, str.length() - (System.lineSeparator().length() + 2));

        return str;
    }
}
