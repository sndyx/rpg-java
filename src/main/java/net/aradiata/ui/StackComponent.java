package net.aradiata.ui;

import java.util.List;

public abstract class StackComponent<T extends UIComponent> implements UIComponent {

    final List<T> components;

    public StackComponent(List<T> components) {
        this.components = components;
    }

    public void addComponent(T component) {
        components.add(component);
    }

    public void removeComponent(Class<?> type) {
        components.removeIf((c) -> c.getClass() == type);
    }
    static String offset(int x) {
        return "";
        // TODO: Calculate string of special characters to properly offset text
        // EG: +36 = [32, 4] = [\uE006, \uE003]
        // TABLE: \uE001 (1) \uE002 (2) \uE003 (4) \uE004 (8) \uE005 (16) \uE006 (32)...
        // NEGATIVE: \uF001 (-1) \uF002 (-2)...
        // Calculate optimal series of positives and negatives?
        // https://stackoverflow.com/questions/57797157/minimum-number-of-powers-of-2-to-get-an-integer
    }

}
