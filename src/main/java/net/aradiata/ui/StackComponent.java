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

}
