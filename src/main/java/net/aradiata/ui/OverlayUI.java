package net.aradiata.ui;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class OverlayUI extends StackComponent {

    private final Player player;

    public OverlayUI(Player player) {
        super(new ArrayList<>());
        this.player = player;
    }

    public RenderResult render() {
        return new RenderResult()
    }

}
