package net.kylmyk.mojaffa;

import net.kylmyk.mojaffa.creative.ModCreativeTab;
import net.kylmyk.mojaffa.input.ModKeybindings;
import net.kylmyk.mojaffa.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JaffaMod.MOD_ID)
public class JaffaMod {

    public static final String MOD_ID = "mojaffa";

    public JaffaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // item
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.register(modEventBus);
        modEventBus.addListener(ModKeybindings::registerBindings);
    }
}
