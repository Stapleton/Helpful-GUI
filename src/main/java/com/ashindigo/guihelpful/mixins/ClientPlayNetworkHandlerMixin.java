package com.ashindigo.guihelpful.mixins;

import com.ashindigo.guihelpful.api.CommandCategoryManager;
import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.api.CommandListManager;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.packet.CommandTreeS2CPacket;
import net.minecraft.server.command.CommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Final
    @Shadow
    private ClientCommandSource commandSource;

    @Shadow
    private CommandDispatcher<CommandSource> commandDispatcher;

    @Inject(method = "onCommandTree", at = @At("RETURN"))
    private void onCommandTree(CommandTreeS2CPacket packet, CallbackInfo info) {
        CommandCategoryManager.initMainCategories();
        commandDispatcher.getRoot().getChildren().stream().map(node -> new CommandInfo<>(node, commandDispatcher, commandSource)).forEach(CommandListManager::addEntry);
        CommandCategoryManager.initMainCategories();
    }
}
