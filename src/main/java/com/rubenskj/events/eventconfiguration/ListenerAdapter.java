package com.rubenskj.events.eventconfiguration;

@FunctionalInterface
public interface ListenerAdapter<E extends Event> extends IListener<E> {

    @Override
    default void execute(E event) throws Exception {}

    @Override
    void onFinally(E event) throws Exception;
}
