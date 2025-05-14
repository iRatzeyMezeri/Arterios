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
    // Distribution
    itemPassage, passageJunction, passageRouter,
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
      // Distribution
      itemPassage = new Duct("item-passage"){{
            requirements(Category.distribution, with(ArteriosItems.cadmium, 1));
            health = 90;
            speed = 3f;
            researchCost = with(ArteriosItems.cadmium, 5);
        }};

      passageRouter = new DuctRouter("passage-router"){{
            requirements(Category.distribution, with(ArteriosItems.cadmium, 7));
            health = 110;
            speed = 3f;
            regionRotated1 = 1;
            solid = false;
            researchCost = with(ArteriosItems.cadmium, 30);
        }};

      passageJunction = new Junction("passage-junction"){{
            requirements(Category.distribution, with(ArteriosItems.cadmium, 4));
            health = 110;
            speed = 6f;
            solid = false;
            researchCost = with(ArteriosItems.cadmium, 30);
        }};
      
      ((Duct) itemPassage).junctionReplacement = passageJunction;
      
      // Walls
      tinWall = new Wall("tin-wall"){{
        requirements(Category.defense, with(ArteriosItems.tin, 6));
        researchCost = with(ArteriosItems.tin, 50);
        health = 320;
        armor = 3;
      }};
    
      tinWallLarge = new Wall("tin-wall-large"){{
        requirements(Category.defense, with(ArteriosItems.tin, 24));
        size = 2;
        researchCost = with(ArteriosItems.tin, 200);
        health = 1280;
        armor = 3;
      }};
    }
}
