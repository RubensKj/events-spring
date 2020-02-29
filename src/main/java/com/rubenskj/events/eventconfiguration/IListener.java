package com.rubenskj.events.eventconfiguration;

import org.springframework.context.ApplicationListener;

@FunctionalInterface
public interface IListener<E extends Event> extends ApplicationListener<E> {

    @Override
    default void onApplicationEvent(E event) {
        try {
            this.execute(event);
            this.onFinally(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void execute(E event) throws Exception {
    }

    void onFinally(E event) throws Exception;
}
