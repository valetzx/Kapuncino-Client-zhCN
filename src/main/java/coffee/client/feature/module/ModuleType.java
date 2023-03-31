/*
 * Copyright (c) 2022 Coffee Client, 0x150 and contributors.
 * Some rights reserved, refer to LICENSE file.
 */

package coffee.client.feature.module;

public enum ModuleType {
    RENDER("Render", "render.png"),
    MOVEMENT("Movement", "movement.png"),
    MISC("Miscellaneous", "misc.png"),
    WORLD("世界", "world.png"),
    EXPLOIT("Exploit", "exploit.png"),
    ADDON_PROVIDED("插件", "addons.png"),
    COMBAT("战斗", "combat.png"),
    GRIEF("Grief", "grief.png"),
    HIDDEN("", "");


    final String name;
    final String tex;

    ModuleType(String n, String tex) {
        this.name = n;
        this.tex = tex;
    }

    public String getName() {
        return name;
    }

    public String getTex() {
        return tex;
    }
}
