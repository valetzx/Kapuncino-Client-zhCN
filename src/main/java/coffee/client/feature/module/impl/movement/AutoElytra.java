/*
 * Copyright (c) 2022 Coffee Client, 0x150 and contributors.
 * Some rights reserved, refer to LICENSE file.
 */

package coffee.client.feature.module.impl.movement;

import coffee.client.CoffeeMain;
import coffee.client.feature.config.DoubleSetting;
import coffee.client.feature.module.Module;
import coffee.client.feature.module.ModuleType;
import coffee.client.helper.util.Utils;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Objects;

public class AutoElytra extends Module {

    final DoubleSetting fallDist = this.config.create(new DoubleSetting.Builder(3).name("Fall distance")
        .description("装备伊力特拉需要多长时间")
        .min(2)
        .max(10)
        .precision(1)
        .get());

    public AutoElytra() {
        super("AutoElytra", "如果你跌倒了足够长的时间,会自动从你的库存中装备一辆elytra", ModuleType.MOVEMENT);
    }

    boolean equippedElytra() {
        return Objects.requireNonNull(CoffeeMain.client.player).getInventory().armor.get(2).getItem() == Items.ELYTRA;
    }

    @Override
    public void tick() {
        if (Objects.requireNonNull(CoffeeMain.client.player).fallDistance > fallDist.getValue()) {
            if (!equippedElytra()) { // do we not have an elytra equipped?
                for (int i = 0; i < (9 * 4 + 1); i++) { // gotta equip
                    ItemStack stack = CoffeeMain.client.player.getInventory().getStack(i); // is it an elytra?
                    if (stack.getItem() == Items.ELYTRA) {
                        Utils.Inventory.moveStackToOther(Utils.Inventory.slotIndexToId(i), 6); // equip
                        break; // we found the item, cancel the loop
                    }
                }
            }
        }
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public String getContext() {
        float fd = Objects.requireNonNull(CoffeeMain.client.player).fallDistance;
        if (fd > fallDist.getMin()) {
            return Utils.Math.roundToDecimal(fd, 1) + " | " + fallDist.getValue();
        }
        return null;
    }

    @Override
    public void onWorldRender(MatrixStack matrices) {

    }

    @Override
    public void onHudRender() {

    }
}
