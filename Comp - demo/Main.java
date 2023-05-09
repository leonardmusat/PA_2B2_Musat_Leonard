import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import musicPackage.AlbumsEntity;

import javax.swing.text.html.parser.Entity;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
               AlbumsEntity albumsEntity = new AlbumsEntity();
                //albumsEntity.setId(2);
                albumsEntity.setReleaseYear("1970");
                albumsEntity.setTitle("Let It Be");
                albumsEntity.setArtist("The Beatles");
                albumsEntity.setGenre("Rock");
                entityManager.merge(albumsEntity);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
