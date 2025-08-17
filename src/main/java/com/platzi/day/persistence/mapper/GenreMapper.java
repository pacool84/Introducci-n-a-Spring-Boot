package com.platzi.day.persistence.mapper;

import com.platzi.day.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    // Este metodo es utilizado para convertir un String a un Enum
    public static Genre stringToGenre(String genero) {
        if(genero == null) return null;

        return switch (genero.toUpperCase()) {

            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATED;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    // Este metodo es utilizado para convertir un Enum a un String
    public static String genreToString(Genre genre) {
        if(genre == null) return null;

        return switch (genre) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
        };
    }
}
