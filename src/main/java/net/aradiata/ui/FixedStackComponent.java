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

    private String offset(int x) {
        return "";
        // TODO: Calculate string of special characters to properly offset text
        // EG: +36 = [32, 4] = [\uE006, \uE003]
        // TABLE: \uE001 (1) \uE002 (2) \uE003 (4) \uE004 (8) \uE005 (16) \uE006 (32)...
        // NEGATIVE: \uF001 (-1) \uF002 (-2)...
        // Calculate optimal series of positives and negatives?
    }

}
