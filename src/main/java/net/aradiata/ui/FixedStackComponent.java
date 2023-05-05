package net.aradiata.ui;

import net.md_5.bungee.api.chat.ComponentBuilder;

import java.util.ArrayList;

public class FixedStackComponent extends StackComponent<FixedComponent> {

    public FixedStackComponent() {
        super(new ArrayList<>());
    }

    @Override
    public void addComponent(FixedComponent component) {
        super.addComponent(component);
        // Sort for more compact UI string
        components.sort((a, b) -> Integer.signum(a.getX() - b.getX()));
    }

    public RenderResult render() {
        int x = 0;
        ComponentBuilder cb = new ComponentBuilder();
        for (FixedComponent component : components) {
            String offset = offset(component.getX() - x);
            RenderResult result = component.render();
            // Realign current X position
            x = component.getX() + result.size();
            cb.append(offset);
            cb.append(result.result());
        }
        return new RenderResult(cb.create(), 0);
    }

}
