package fr.devteam.plugin.helpers;

import java.util.Iterator;

import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class RenderHelper {

	public static MapView resetRenderers(MapView map){
        final Iterator<MapRenderer> iterator = map.getRenderers().iterator();

        while (iterator.hasNext()){
            map.removeRenderer(iterator.next());
        }

        return map;
    }
}
