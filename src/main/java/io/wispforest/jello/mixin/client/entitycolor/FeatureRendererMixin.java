package io.wispforest.jello.mixin.client.entitycolor;

import io.wispforest.jello.api.ducks.entity.ConstantColorEntity;
import io.wispforest.jello.api.ducks.entity.DyeableEntity;
import io.wispforest.jello.api.ducks.entity.GrayScaleEntity;
import io.wispforest.jello.api.ducks.entity.RainbowEntity;
import io.wispforest.jello.api.registry.ColorizeBlackListRegistry;
import io.wispforest.jello.api.registry.GrayScaleEntityRegistry;
import io.wispforest.jello.api.util.ColorUtil;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;

@Mixin(FeatureRenderer.class)
public class FeatureRendererMixin<T extends Entity, M extends EntityModel<T>> {

    @Inject(method = "renderModel", at = @At(value = "HEAD"), cancellable = true)
    private static <T extends LivingEntity> void renderWithColor(EntityModel<T> model, Identifier texture, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T livingEntity, float red, float green, float blue, CallbackInfo ci) {
        if (!ColorizeBlackListRegistry.isBlackListed(livingEntity)) {
            if (!(livingEntity instanceof WolfEntity)) {
                boolean hasCustomColor = false;
                float[] colorComp = new float[]{1.0F, 1.0F, 1.0F};

                if (livingEntity instanceof DyeableEntity dyeableEntity && dyeableEntity.isDyed() && !(livingEntity instanceof SheepEntity)) {
                    colorComp = dyeableEntity.getDyeColor().getColorComponents();
                    hasCustomColor = true;
                } else if (livingEntity instanceof ConstantColorEntity constantColorEntity && constantColorEntity.isColored()) {
                    colorComp = new Color(constantColorEntity.getConstantColor()).getRGBColorComponents(null);
                    hasCustomColor = true;
                } else if (livingEntity instanceof RainbowEntity rainbowEntity && rainbowEntity.isRainbowTime()) {
                    colorComp = ColorUtil.rainbowColorizer(livingEntity);
                    hasCustomColor = true;
                }

                if (hasCustomColor) {
                    VertexConsumer vertexConsumer;

                    if (livingEntity instanceof GrayScaleEntity grayScaleEntity && grayScaleEntity.isGrayScaled(livingEntity)) {
                        vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(GrayScaleEntityRegistry.INSTANCE.getOrFindTexture(livingEntity, texture)));
                    } else {
                        vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(texture));
                    }

                    model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(livingEntity, 0.0F), colorComp[0], colorComp[1], colorComp[2], 1.0F);
                    ci.cancel();
                }
            }
        }
    }

    @Inject(method = "getTexture", at = @At(value = "RETURN"), cancellable = true)
    private void getGrayScaleID(T entity, CallbackInfoReturnable<Identifier> cir) {
        if (!(entity instanceof PlayerEntity) && (entity instanceof GrayScaleEntity grayScaleEntity && grayScaleEntity.isGrayScaled(entity))) {
            cir.setReturnValue(GrayScaleEntityRegistry.INSTANCE.getOrFindTexture(entity, cir.getReturnValue()));
        }
    }
}
