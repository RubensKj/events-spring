package com.rubenskj.events.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@FunctionalInterface
public interface ListenerAdapter<E extends ApplicationEvent> extends ApplicationListener {

    @Override
    default void onApplicationEvent(ApplicationEvent event) {
        try {
            E eventE = (E) event;
            this.execute(eventE);
            this.onFinally(eventE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void execute(E event) throws Exception {
    }

    void onFinally(E event);
}
