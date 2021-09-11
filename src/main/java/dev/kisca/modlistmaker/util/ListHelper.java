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
            modStrings.add(String.format("'%s' (%s:%s), %s", mod.getMetadata().getName(), mod.getMetadata().getVersion(), mod.getMetadata().getVersion(), System.lineSeparator()));
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
