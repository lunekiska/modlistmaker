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
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Environment(EnvType.CLIENT)
public class ListToFile {
    private static final DateFormat date = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
    public static File textFile;

    public static File getFile() {
        try {
            String nowDate = date.format(new Date());
            Path path = FabricLoader.getInstance().getGameDir().resolve("mod_data/modlistmaker/list-" + nowDate + ".txt");

            return path.toFile();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveList(boolean alphabetical) {
        try {
            textFile = getFile();
            textFile.getParentFile().mkdirs();

            textFile.createNewFile();
            FileWriter fr = new FileWriter(textFile, false);
            fr.write(ListHelper.getList(alphabetical));

            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
