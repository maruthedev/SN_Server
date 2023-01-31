package com.maru.socialnetwork4.Service;

public interface CustomService<T> {
    T create(T t);
    T update(T t);
    T delete(T t);
}
