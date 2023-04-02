/*
 * Copyright (c) 2022 Coffee Client, 0x150 and contributors.
 * Some rights reserved, refer to LICENSE file.
 */

package coffee.client.feature.module.impl.movement;

import coffee.client.CoffeeMain;
import coffee.client.feature.gui.notifications.Notification;
import coffee.client.feature.module.Module;
import coffee.client.feature.module.ModuleType;
import coffee.client.helper.util.Utils;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.vehicle.BoatEntity;

public class BoatPhase extends Module {

    public BoatPhase() {
        super("BoatPhase", "当你在一艘有沙子落下的船上时,允许你通过障碍物", ModuleType.MOVEMENT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void enable() {
        Utils.Logging.message("要使用BoatPhase,进入一艘船,将它一直移动到一面墙,并在船上扔沙子");
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
        if (CoffeeMain.client.player == null || CoffeeMain.client.getNetworkHandler() == null) {
            return;
        }
        if (!(CoffeeMain.client.player.getVehicle() instanceof BoatEntity)) {
            Notification.create(5000, "Boat phase", true, Notification.Type.INFO, "sir you need a boat");
            setEnabled(false);
            return;
        }
        CoffeeMain.client.player.getVehicle().noClip = true;
        CoffeeMain.client.player.getVehicle().setNoGravity(true);
        CoffeeMain.client.player.noClip = true;
    }

    @Override
    public void onHudRender() {

    }
}
