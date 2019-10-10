package com.ashindigo.guihelpful.mixins;

import com.ashindigo.guihelpful.api.CommandCategoryManager;
import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.api.CommandListManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
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

    @SuppressWarnings("unchecked")
    @Inject(method = "onCommandTree", at = @At("RETURN"))
    private void onCommandTree(CommandTreeS2CPacket packet, CallbackInfo info) {
        CommandCategoryManager.initMainCategories();
        for (CommandNode<? extends CommandSource> node : commandDispatcher.getRoot().getChildren()) {
            CommandInfo<? extends CommandSource> commandInfo = new CommandInfo<>((CommandNode<CommandSource>) node, commandDispatcher, commandSource);
            CommandListManager.addEntry(commandInfo);
        }
        CommandCategoryManager.initMainCategories();
    }
}
