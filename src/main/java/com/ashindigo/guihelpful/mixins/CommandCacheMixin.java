package com.ashindigo.guihelpful.mixins;

import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.api.CommandListManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import io.github.cottonmc.clientcommands.impl.CommandCache;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandCache.class)
public abstract class CommandCacheMixin {

    @Final
    @Shadow(remap = false)
    private static CommandDispatcher<CottonClientCommandSource> DISPATCHER;

    @Inject(method = "build", at = @At("RETURN"), remap = false)
    private static void build(CallbackInfo cbi) {
        CommandListManager.initMainList();
        for (CommandNode<CottonClientCommandSource> node : DISPATCHER.getRoot().getChildren()) {
            CommandListManager.addEntry(new CommandInfo<>(node, DISPATCHER));
        }
    }
}
