package arterios.content;

import arc.graphics.Color;
import arterios.APal;
import arterios.entities.bullet.UndergroundBulletType;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ArteriosUnits {
    public static UnitType

    felix;

    public static void load() {
        felix = new UnitType("felix"){{
            constructor = UnitWaterMove::create;
            aiController = GroundAI::new;

            speed = 1.1f;
            drag = 0.13f;
            hitSize = 8f;
            health = 280;
            accel = 0.4f;
            rotateSpeed = 3.3f;
            faceTarget = true;
            naval = true;
            outlineColor = APal.lightOutline;
            trailLength = 20;
            trailScl = 1.3f;
            waveTrailX = 2f;

            armor = 2f;

            weapons.addAll(
                    new Weapon("arterios-felix-weapon"){{
                        x = 2.5f;
                        y = 0;
                        reload = 32;
                        shootSound = Sounds.mineDeploy;
                        mirror = true;
                        rotate = false;
                        targetAir = false;

                        top = false;
                        alternate = true;
                        layerOffset = -0.005f;
                        bullet = new UndergroundBulletType(1.5f, 12){{
                            sprite = "mine-bullet";
                            ignoreRotation = true;
                            width = height = 8f;
                            shootEffect = smokeEffect = ejectEffect = Fx.none;
                            backColor = hitColor = trailColor = APal.navalBullet;
                            frontColor = mixColorTo = Color.white;
                            hitSound = Sounds.plasmaboom;
                            hitSize = 22f;
                            lifetime = 60f;
                            hitEffect = despawnEffect = Fx.flakExplosion;
                            shrinkX = shrinkY = 0f;
                            inaccuracy = 2f;
                            trailWidth = 3f;
                            trailLength = 8;
                            homingPower = 0.2f;
                        }};
                    }}
            );
        }};
    }
}
