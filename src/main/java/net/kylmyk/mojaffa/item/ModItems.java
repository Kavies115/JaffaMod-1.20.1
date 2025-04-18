package net.kylmyk.mojaffa.item;

import net.kylmyk.mojaffa.JaffaMod;
import net.kylmyk.mojaffa.sounds.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JaffaMod.MOD_ID);

    public static final List<Item> PONDERABLE_ITEMS = new ArrayList<>();
    public static final RegistryObject<Item> JAFFACAKE = ITEMS.register("jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build())) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
                    super.appendHoverText(stack, world, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.mojaffa.jaffa_cake"));
                }
            });

    public static final RegistryObject<Item> JAFFA_DONUT = ITEMS.register("jaffa_donut",
            () -> new RecordItem(
                    14,
                    ModSounds.JONUT_SOUND,
                    new Item.Properties()
                            .stacksTo(1)
                            .food(new FoodProperties.Builder().nutrition(10).saturationMod(10.2f).build())
                            .rarity(Rarity.RARE)
                    ,
                    3640
            ) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
                    super.appendHoverText(stack, world, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.mojaffa.jaffa_cake"));
                }
            });

    public static final RegistryObject<Item> GOLDEN_JAFFACAKE = ITEMS.register("golden_jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(
                            new FoodProperties.Builder()
                                    .nutrition(4)
                                    .saturationMod(16f)
                                    .build())) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
                    super.appendHoverText(stack, world, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.mojaffa.jaffa_cake"));
                }
            });

    public static final RegistryObject<Item> BEEFY_JAFFACAKE = ITEMS.register("beefy_jaffa_cake",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(14.4f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void registerPonderableItems() {
        PONDERABLE_ITEMS.add(JAFFACAKE.get());
        PONDERABLE_ITEMS.add(GOLDEN_JAFFACAKE.get());
        PONDERABLE_ITEMS.add(JAFFA_DONUT.get());
    }

}
