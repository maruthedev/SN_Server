package com.maru.socialnetwork4.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class DAO {
    public static Session session;

    public DAO() {
        if (session == null) {
            try {
                session = new Configuration().configure(new File("src/main/resources/Hibernate.config.xml"))
                        .buildSessionFactory().openSession();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
