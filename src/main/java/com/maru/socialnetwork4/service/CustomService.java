package com.maru.socialnetwork4.service;

public interface CustomService<T> {
    T create(T t);
    T update(T t);
    T delete(T t);
}
