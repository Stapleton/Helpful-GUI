package com.ashindigo.guihelpful.mixins;

import com.ashindigo.guihelpful.gui.HelpfulShowAllScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Inject(method = "keyPressed", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;openScreen(Lnet/minecraft/client/gui/screen/Screen;)V"), cancellable = true)
    private void onKeyPressed(CallbackInfoReturnable<Boolean> ci) {
        if (MinecraftClient.getInstance().currentScreen instanceof HelpfulShowAllScreen) {
            ci.setReturnValue(true);
            ci.cancel();
        }
    }
}
