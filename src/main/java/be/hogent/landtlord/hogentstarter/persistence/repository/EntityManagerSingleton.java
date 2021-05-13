package be.hogent.landtlord.hogentstarter.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    private static final String NAME_PERSISTENCE_UNIT = "HoGentStarter";

    private static EntityManagerSingleton instance;

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerSingleton() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(NAME_PERSISTENCE_UNIT);
    }

    public static EntityManagerSingleton getInstance() {
        if (instance == null) {
            instance = new EntityManagerSingleton();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
