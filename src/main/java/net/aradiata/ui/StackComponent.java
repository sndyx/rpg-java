package net.aradiata.ui;

import java.util.List;

public abstract class StackComponent implements UIComponent {

    final List<UIComponent> components;

    public StackComponent(List<UIComponent> components) {
        this.components = components;
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public void removeComponent(Class<?> type) {
        components.removeIf((c) -> c.getClass() == type);
    }

}
