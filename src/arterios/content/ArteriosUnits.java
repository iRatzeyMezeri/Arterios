package arterios.content;

import arc.graphics.Color;
import arterios.APal;
import arterios.entities.bullet.*;
import arterios.entities.part.*;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.abilities.MoveEffectAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.part.HoverPart;
import mindustry.entities.pattern.ShootHelix;
import mindustry.gen.ElevationMoveUnit;
import mindustry.gen.Sounds;
import mindustry.gen.UnitWaterMove;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ArteriosUnits {
    public static UnitType
    // Hover
    cambru, ordovi, silur, devon, carbonifer,
    // Naval
    felix, lynx, silvester, leptail, namafelis;

    public static void load() {
        cambru = new UnitType("cambru"){{
            constructor = ElevationMoveUnit::create;

            drag = 0.07f;
            speed = 2f;
            accel = 0.09f;

            hitSize = 9;
            rotateSpeed = 8;
            health = 280;
            armor = 0;
            faceTarget = true;
            targetAir = true;
            outlineColor = APal.lightOutline;

            hovering = true;

            shadowElevation = 0.1f;

            parts.addAll(
                    new HoverPart(){{
                        x = -1f;
                        y = -4;
                        mirror = false;
                        radius = 5;
                        phase = 90;
                        stroke = 2;
                        layerOffset = -0.01f;
                        color = APal.hoverRed;
                    }},
                    new HoverPart(){{
                        x = 3f - 1f;
                        y = 3f;
                        mirror = false;
                        radius = 5;
                        phase = 90;
                        stroke = 2;
                        layerOffset = -0.01f;
                        color = APal.hoverRed;
                    }},
                    new HoverPart(){{
                        x = -3f - 1f;
                        y = 3f;
                        mirror = false;
                        radius = 5;
                        phase = 90;
                        stroke = 2;
                        layerOffset = -0.01f;
                        color = APal.hoverRed;
                    }},
                    new SillyPart("-bow")
            );

            abilities.add(new MoveEffectAbility(-1f, -6f, APal.hoverRed, Fx.missileTrailShort, 4f));

            weapons.addAll(
                    new Weapon("arterios-cambru-weapon"){{
                        x = 4f;
                        y = 0;
                        reload = 48;
                        shootSound = Sounds.lasershoot;
                        mirror = false;
                        rotate = true;
                        rotationLimit = 25;
                        bullet = new LaserBulletType(){{
                            damage = 14;
                            colors = new Color[]{
                                    APal.hoverRed,
                                    APal.hoverRed,
                                    Color.white
                            };
                            hitEffect = Fx.hitLancer;
                            sideLength = 2;
                            hitSize = 3;
                            lifetime = 8;
                            drawSize = 300;
                            collidesAir = true;
                            length = 40;
                            width = 8;
                            pierce = false;
                            pierceCap = 1;
                        }};
                    }}
            );
        }};

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

            parts.addAll(new SillyPart("-bow"));

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
                            backColor = hitColor = trailColor = APal.navalGreen;
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
