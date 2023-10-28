package coffee.client.feature.module.impl.render;

import coffee.client.feature.config.StringSetting;
import coffee.client.feature.module.Module;
import coffee.client.feature.module.ModuleType;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.util.math.MatrixStack;

public class NameProtect extends Module {
    final StringSetting name = this.config.create(new StringSetting.Builder("REPLACE").name("name").description("the name to use").get());


    private String username = "如果你看到这个,一定有问题.";
    public NameProtect() {
        super("NameProtect", "假冒你的名字客户端", ModuleType.RENDER);
    }

    @Override
    public void tick() {

    }

    @Override
    public void enable() {
        username = client.getSession().getUsername();
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
    public void onHudRender() {

    }

    public String replaceName(String string) {
        if (string != null && isEnabled()) {
            return string.replace(username, name.getValue());
        }

        return string;
    }

    public String getName(String original) {
        if (name.getValue().length() > 0 && isEnabled()) {
            return name.getValue();
        }

        return original;
    }
}
