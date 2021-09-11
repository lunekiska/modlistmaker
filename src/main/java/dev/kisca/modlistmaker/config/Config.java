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


package dev.kisca.modlistmaker.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@me.shedaniel.autoconfig.annotation.Config(name = "modlistmaker")
public class Config implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    public static MakerTypes makerTypes = new MakerTypes();

    public static class MakerTypes {
        public boolean commandsList = true;
        public boolean onLoadList = false;
    }
}
