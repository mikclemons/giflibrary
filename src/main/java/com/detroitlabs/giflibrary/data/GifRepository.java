package com.detroitlabs.giflibrary.data;

import com.detroitlabs.giflibrary.model.Gif;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    public static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("toobad", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 2),
            new Gif("exhausting", LocalDate.of(2019, 2, 23), "Jen Bloomer", false, 1),
            new Gif("headtilt", LocalDate.of(2019, 2, 23), "Dan Newport", true, 3),
            new Gif("corgibeg", LocalDate.of(2019, 2, 23), "Matt of Lansing", false, 3),
            new Gif("hugemistake", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 2),
            new Gif("whatisaid", LocalDate.of(2019, 2, 23), "Dan Newport", true, 1),
            new Gif("minionwhat",LocalDate.of(2019,2,26), "Jen Bloomer", true, 2 ),
            new Gif("brittanyheadtilt", LocalDate.of(2019, 2, 16)," Matt of Lansing", false, 1)
    );

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public Gif findFavorite(Boolean isFavorite) {
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite() == true) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifsInCategory = new ArrayList<>();

        for (Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id) {
                gifsInCategory.add(gif);
            }
        }
        return gifsInCategory;
    }

    public List<Gif> findBySearch(String name) {

        List<Gif> searchResults = new ArrayList<>();

        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(name)) {
                searchResults.add(gif);
            }
        }
        return searchResults;
    }
}




