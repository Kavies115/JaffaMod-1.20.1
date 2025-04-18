package net.kylmyk.mojaffa;

import net.kylmyk.mojaffa.creative.ModCreativeTab;
import net.kylmyk.mojaffa.input.ModKeybindings;
import net.kylmyk.mojaffa.item.ModItems;
import net.kylmyk.mojaffa.sounds.ModSounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
        ModSounds.SOUND_EVENT.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // This ensures that the item registrations are complete before we try to use them
        ModItems.registerPonderableItems();
    }
}
