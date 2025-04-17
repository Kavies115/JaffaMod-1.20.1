package net.kylmyk.mojaffa.item;

import net.kylmyk.mojaffa.JaffaMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JaffaMod.MOD_ID);
    public static final RegistryObject<Item> JAFFACAKE = ITEMS.register("jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build())) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
                    super.appendHoverText(stack, world, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.mojaffa.jaffa_cake")); // Add "Poderable" as a tooltip
                }
            });

    public static final RegistryObject<Item> GOLDEN_JAFFACAKE = ITEMS.register("golden_jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(
                            new FoodProperties.Builder()
                                    .nutrition(4)
                                    .saturationMod(16f)
                                    .build())));

    public static final RegistryObject<Item> BEEFY_JAFFACAKE = ITEMS.register("beefy_jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(9).saturationMod(14f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
