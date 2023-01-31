package com.maru.socialnetwork4.Dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.File;

public abstract class DAO<T> {
    private static Session session;

    protected DAO() {
        if (session == null) {
            try {
                session = new Configuration().configure(new File("src/main/resources/Hibernate.config.xml"))
                        .buildSessionFactory().openSession();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Session getSession() {
        return session;
    }

    public abstract T create(T t);
    public abstract T update(T t);
    public abstract T delete(T t);
}
