/*
 * Copyright (c) 2022 Coffee Client, 0x150 and contributors.
 * Some rights reserved, refer to LICENSE file.
 */

package coffee.client.feature.module.impl.render;

import coffee.client.feature.config.DoubleSetting;
import coffee.client.feature.module.Module;
import coffee.client.feature.module.ModuleType;
import coffee.client.helper.util.Transitions;
import net.minecraft.client.util.math.MatrixStack;

public class Radar extends Module {
    final DoubleSetting scale = this.config.create(new DoubleSetting.Builder(3).name("Scale")
        .description("你周围有多少区域可以展示")
        .min(0.1)
        .max(10)
        .precision(1)
        .get());
    public double iScale = 0;

    public Radar() {
        super("Radar", "允许你看到周围的其他玩家和实体", ModuleType.RENDER);
    }

    @Override
    public void tick() {

    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public String getContext() {
        return null;
    }

    @Override
    public void onWorldRender(MatrixStack matrices) {

    }

    @Override
    public void onFastTick() {
        iScale = Transitions.transition(iScale, scale.getValue(), 30, 0);
    }

    @Override
    public void onHudRender() {

    }
}
