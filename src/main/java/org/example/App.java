package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //передаем класс, который помечен @Entity
        //автоматически считывает информацию из фалйа с названием hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        //создаем сессию для работы с хибер
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
    try {
        session.beginTransaction();


//        1. С помощью Hibernate получите любого режиссера, а затем получите список его фильмов.
//        Director director = session.get(Director.class, 4);
//        List<Movie> movies = director.getMovies();
//        for(Movie movie : movies)
//            System.out.println(movie);


        //2.Получите любой фильм, а затем получите его режиссера
//        Movie movie = session.get(Movie.class, 3);
//        System.out.println(movie.getName()+ " "+ movie.getDirector());


        //3. Добавьте еще один фильм для любого режиссера.
//            Movie movie =new Movie("Test Movie", 2023);
//            Director director = session.get(Director.class, 3);
//            director.setMovies(new ArrayList<>(Collections.singleton(movie)));
//            movie.setDirector(director);
//            session.persist(movie);


        //4. Создайте нового режиссера и новый фильм и свяжите эти сущности.
//        Director newDirector = new Director("Artyom Tarasov", 25);
//        Movie newMovie = new Movie("New Movie", 2021);
//        newDirector.setMovies(new ArrayList<>(Collections.singleton(newMovie)));
//        newMovie.setDirector(newDirector);
//        session.persist(newDirector);
//        session.persist(newMovie);


        //5.Смените режиссера у существующего фильма.
//        Movie movie = session.get(Movie.class, 6);
//        Director director = session.get(Director.class,4);
//        movie.setDirector(director);
//
//        director.setMovies(new ArrayList<>(Collections.singleton(movie)));
//        session.persist(director);
//        session.persist(movie);


        //7. Удалите фильм у любого режиссера.
        Director director = session.get(Director.class, 7);
        List<Movie> movies = director.getMovies();
        for(Movie movie: movies) {
            session.remove(movie);
        }
        director.getMovies().clear();
        session.getTransaction().commit();
    }
    finally {
          sessionFactory.close();
    }
    }
}
