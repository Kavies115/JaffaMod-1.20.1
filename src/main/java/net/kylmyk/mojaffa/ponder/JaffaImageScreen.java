package net.kylmyk.mojaffa.ponder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class JaffaImageScreen extends Screen {

    private Item modItems;

    public JaffaImageScreen(Item modItems) {
        super(Component.literal("Jaffa Cake"));
        this.modItems = modItems;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        // Get the Minecraft instance and ItemRenderer
        Minecraft mc = Minecraft.getInstance();
        ItemRenderer itemRenderer = mc.getItemRenderer();
        ItemStack jaffaCake = new ItemStack(modItems);

        // Calculate rotation angle based on system time
        float time = (System.currentTimeMillis() % 3600L) / 10.0f; // 360 degrees every 6s

        // Apply transformations for spinning, scaling, and flipping
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();

        // Calculate the scale factor to make the item 1/2 the size of the screen
        float scale = this.height / 2.0f; // Make the item half the width of the screen

        // Center the item on the screen
        poseStack.translate(this.width / 2f, this.height / 2f, 200);

        // Apply scaling and flipping (flip horizontally)
        poseStack.scale(scale, -scale, 1.0f); // Flip horizontally (negative scale on X)

        // Apply rotation (spinning)
        poseStack.mulPose(Axis.YP.rotationDegrees(time)); // Spin the item

        // Render the item at the center of the screen with the appropriate transformations
        itemRenderer.render(
                jaffaCake,                       // The item stack to render
                ItemDisplayContext.GUI,           // The display context (GUI context for the inventory or screen)
                false,                            // Is this the left hand? We don't need that here, so false
                poseStack,                        // The transformation stack
                guiGraphics.bufferSource(),       // The buffer source (to handle multiple rendering buffers)
                15728880,                         // Combined light (default lighting level)
                15728880,                         // Combined overlay (default overlay, used for item damage bars, etc.)
                mc.getItemRenderer().getModel(jaffaCake, mc.level, null, 0) // The baked model for the item
        );

        poseStack.popPose();
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
