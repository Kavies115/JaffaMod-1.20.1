package net.kylmyk.mojaffa.events;


import com.mojang.blaze3d.platform.InputConstants;
import net.kylmyk.mojaffa.JaffaMod;
import net.kylmyk.mojaffa.input.ModKeybindings;
import net.kylmyk.mojaffa.item.ModItems;
import net.kylmyk.mojaffa.ponder.JaffaImageScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JaffaMod.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Minecraft.getInstance().screen == null) return;

        long window = Minecraft.getInstance().getWindow().getWindow();
        InputConstants.Key key = InputConstants.getKey(event.getKey(), event.getScanCode());

        if (ModKeybindings.OPEN_JAFFA_SCREEN.isActiveAndMatches(key)) {
            ItemStack hovered = getHoveredItem();
            if (!hovered.isEmpty() && ModItems.PONDERABLE_ITEMS.contains(hovered.getItem())) {
                Minecraft.getInstance().setScreen(new JaffaImageScreen(hovered.getItem()));
            }
        }
    }

    private static ItemStack getHoveredItem() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen instanceof AbstractContainerScreen<?> screen) {
            Slot hoveredSlot = screen.getSlotUnderMouse();
            if (hoveredSlot != null && hoveredSlot.hasItem()) {
                return hoveredSlot.getItem();
            }
        }
        return ItemStack.EMPTY;
    }
}
