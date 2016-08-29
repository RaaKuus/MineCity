package br.com.gamemods.minecity.forge.mc_1_7_10.protection;

import br.com.gamemods.minecity.forge.base.Referenced;
import br.com.gamemods.minecity.forge.mc_1_7_10.core.transformer.forge.entity.SevenEntityBoatTransformer;
import br.com.gamemods.minecity.forge.mc_1_7_10.core.transformer.forge.entity.SevenEntityFishingHookTransformer;
import br.com.gamemods.minecity.forge.mc_1_7_10.core.transformer.forge.entity.SevenEntityPotionTransformer;
import br.com.gamemods.minecity.forge.mc_1_7_10.event.FishingHookBringEntityEvent;
import br.com.gamemods.minecity.forge.mc_1_7_10.event.FishingHookHitEntityEvent;
import br.com.gamemods.minecity.forge.mc_1_7_10.event.PotionApplyEvent;
import br.com.gamemods.minecity.forge.mc_1_7_10.event.VehicleDamageEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;

@Referenced
public class MineCitySevenHooks
{
    @Referenced(at = SevenEntityBoatTransformer.class)
    public static boolean onVehicleDamage(Entity entity, DamageSource source, float amount)
    {
        return MinecraftForge.EVENT_BUS.post(new VehicleDamageEvent(entity, source, amount));
    }

    @Referenced(at = SevenEntityPotionTransformer.class)
    public static void onPotionApplyEffect(EntityLivingBase entity, PotionEffect effect, Entity potion)
    {
        PotionApplyEvent event = new PotionApplyEvent(entity, effect, potion);
        if(!MinecraftForge.EVENT_BUS.post(event))
            entity.addPotionEffect(effect);
    }

    @Referenced(at = SevenEntityFishingHookTransformer.class)
    public static Entity onFishingHookHitEntity(Entity entity, EntityFishHook hook)
    {
        if(entity == null)
            return null;

        FishingHookHitEntityEvent event = new FishingHookHitEntityEvent(entity, hook);
        if(MinecraftForge.EVENT_BUS.post(event))
            return null;
        else
            return entity;
    }

    @Referenced(at = SevenEntityFishingHookTransformer.class)
    public static boolean onFishingHookBringEntity(EntityFishHook hook)
    {
        FishingHookBringEntityEvent event = new FishingHookBringEntityEvent(hook.field_146043_c, hook);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    private MineCitySevenHooks(){}
}