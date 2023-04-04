package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager movie = new MovieManager();

    private Movie movie1 = new Movie(1, "Бладшот", "боевик");
    private Movie movie2 = new Movie(2, "Вперёд", "мультфильм");
    private Movie movie3 = new Movie(3, "Отель 'Белград'", "комедия");
    private Movie movie4 = new Movie(4, "Джентельмены", "боевик");
    private Movie movie5 = new Movie(5, "Человек-невидимка", "ужасы");
    private Movie movie6 = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    private Movie movie7 = new Movie(7, "Номер один", "комедия");
    private Movie movie8 = new Movie(8, "Валли", "мультфильм");

    @Test
    public void shouldAddMovie() {
        movie.add(movie1);
        movie.add(movie2);

        Movie[] expected = {movie1, movie2};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNullMovie() {
        Movie[] expected = {};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllLimit() {
        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);
        movie.add(movie8);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOverLimit() {
        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);


        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllLimit5() {

        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);


        Movie[] expected = {movie1, movie2, movie3, movie4, movie5};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastThreeMovie() {
        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = movie.findLastFive();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastFiveLimit() {
        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);
        movie.add(movie8);

        Movie[] expected = {movie8, movie7, movie6, movie5, movie4};
        Movie[] actual = movie.findLastFive();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastFiveLimit5() {
        MovieManager movie = new MovieManager(5);

        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = movie.findLastFive();

        assertArrayEquals(expected, actual);
    }
}
