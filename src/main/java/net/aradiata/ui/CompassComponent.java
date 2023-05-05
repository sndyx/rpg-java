package net.aradiata.ui;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class CompassComponent implements FixedComponent {

    private final Player player;

    private double rotation;
    private double speed;

    public CompassComponent(Player player) {
        this.player = player;
    }

    @Override
    public int getX() { return 0; }

    @Override
    public int getY() { return 0; }

    @Override
    public RenderResult render() {
        double angle = Math.atan2(
                player.getCompassTarget().getZ() - player.getLocation().getZ(),
                player.getCompassTarget().getX() - player.getLocation().getX()
        ) / 6.2831854820251465;
        double yaw = player.getLocation().getYaw() / 360.0 % 1.0;
        updateCompass(0.5 - (yaw - 0.25));
        double direction = (angle + rotation) % 1.0;
        int ordinal = ((int) Math.floor(direction * 32) + 16) % 32;
        char c = (char) (0xE109 + ordinal);
        TextComponent text = new TextComponent(String.valueOf(c));
        return new RenderResult(new BaseComponent[] { text }, 32);
    }

    private void updateCompass(double target) {
        double e = target - rotation;
        e = (e + 0.5) % 1.0 - 0.5;
        speed += e * 0.1;
        speed *= 0.8;
        speed = (rotation + speed) % 1.0;
    }

}
