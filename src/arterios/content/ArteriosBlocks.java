package arterios.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.MissileUnitType;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import static mindustry.type.ItemStack.*;
import arterios.*;

public class ArteriosBlocks {
    public static Block
    // Environment
      // Ores
      wallTinOre, cadmiumOre,
      // Floors
      tealite, obsidian, obsidianMagmaI, obsidianMagmaII,
      // Walls
      tealiteWall, obsidianWall,
    // Walls
    tinWall, tinWallLarge;

  
  public static void load(){
      // Environment
        wallTinOre = new StaticWall("wall-tin-ore"){{
            itemDrop = ArteriosItems.tin;
            variants = 3;
        }};

        cadmiumOre = new OreBlock("cadmium-ore", ArteriosItems.cadmium){{
         variants = 3;
        }};
      
        tealite = new Floor("tealite"){{
            variants = 3;
        }};
      
        obsidian = new Floor("obsidian"){{
            variants = 4;
        }};

        obsidianMagmaI = new Floor("obsidian-magma-i"){{
            variants = 2;
            attributes.set(Attribute.heat, 0.66f); 
        }};
      
        obsidianMagmaII = new Floor("obsidian-magma-ii"){{
            variants = 2;
            attributes.set(Attribute.heat, 1f); 
        }};

        tealiteWall = new StaticWall("tealite-wall"){{
            variants = 3;
        }};
      
        obsidianWall = new StaticWall("obsidian-wall"){{
            variants = 2;
        }};
      // Walls
      tinWall = new Wall("tin-wall"){{
        requirements(Category.defense, with(ArteriosItems.tin, 6));
        researchCostMultiplier = 0.01f;
        health = 320;
        armor = 3;
      }};
    
      tinWallLarge = new Wall("large-tin-wall"){{
        requirements(Category.defense, with(ArteriosItems.tin, 6));
        size = 2;
        researchCostMultiplier = 0.1f;
        health = 1280;
        armor = 3;
      }};
    }
}
