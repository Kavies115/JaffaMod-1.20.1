package net.kylmyk.mojaffa.creative;

import net.kylmyk.mojaffa.JaffaMod;
import net.kylmyk.mojaffa.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = JaffaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "mojaffa");

    public static final RegistryObject<CreativeModeTab> JAFFA_TAB =
            CREATIVE_TABS.register("jaffa_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mojaffa.jaffa_tab")) // lang key
                    .icon(() -> new ItemStack(ModItems.JAFFACAKE.get()))
                    .displayItems((parameters, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                    })
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_TABS.register(bus);
    }
}
