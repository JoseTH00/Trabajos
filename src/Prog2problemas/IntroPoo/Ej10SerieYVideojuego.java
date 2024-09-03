package Prog2problemas.IntroPoo;

import java.util.Collections;

class Producto {
    private String titulo;
    private boolean entregado;
    private String genero;

    public Producto() {
        this.titulo = "";
        this.entregado = false;
        this.genero = "";
    }

    public Producto(String titulo, String genero) {
        this.titulo = titulo;
        this.entregado = false;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void entregar() {
        this.entregado = true;
    }

    public void devolver() {
        this.entregado = false;
    }
}

class Serie extends Producto {
    private int numeroDeTemporadas;
    private String creador;

    public Serie() {
        super();
        this.numeroDeTemporadas = 3;
        this.creador = "";
    }

    public Serie(String titulo, String creador) {
        super(titulo, "");
        this.numeroDeTemporadas = 3;
        this.creador = creador;
    }

    public Serie(String titulo, int numeroDeTemporadas, String genero, String creador) {
        super(titulo, genero);
        this.numeroDeTemporadas = numeroDeTemporadas;
        this.creador = creador;
    }

    public int getNumeroDeTemporadas() {
        return numeroDeTemporadas;
    }

    public String getCreador() {
        return creador;
    }

    public void setNumeroDeTemporadas(int numeroDeTemporadas) {
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
}

class Videojuego extends Producto {
    private int horasEstimadas;
    private String compania;

    public Videojuego() {
        super();
        this.horasEstimadas = 10;
        this.compania = "";
    }

    public Videojuego(String titulo, int horasEstimadas) {
        super(titulo, "");
        this.horasEstimadas = horasEstimadas;
        this.compania = "";
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        super(titulo, genero);
        this.horasEstimadas = horasEstimadas;
        this.compania = compania;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getCompania() {
        return compania;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
}

class Alquiler {
    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        series[1] = new Serie("Stranger Things", 4, "Ciencia Ficción", "Hermanos Duffer");
        series[2] = new Serie("The Office", 9, "Comedia", "Greg Daniels");
        series[3] = new Serie("Friends", 10, "Comedia", "David Crane");
        series[4] = new Serie("Game of Thrones", 8, "Fantasía", "George R. R. Martin");

        videojuegos[0] = new Videojuego("The Witcher 3", 50, "RPG", "CD Projekt");
        videojuegos[1] = new Videojuego("God of War", 20, "Acción", "Santa Monica Studio");
        videojuegos[2] = new Videojuego("Red Dead Redemption 2", 60, "Aventura", "Rockstar Games");
        videojuegos[3] = new Videojuego("Cyberpunk 2077", 40, "RPG", "CD Projekt");
        videojuegos[4] = new Videojuego("Horizon Zero Dawn", 30, "Aventura", "Guerrilla Games");

        series[1].entregar();
        series[3].entregar();
        videojuegos[2].entregar();
        videojuegos[4].entregar();

        int seriesEntregadas = 0;
        int videojuegosEntregados = 0;

        for (Serie serie : series) {
            if (serie.isEntregado()) {
                seriesEntregadas++;
            }
        }

        for (Videojuego videojuego : videojuegos) {
            if (videojuego.isEntregado()) {
                videojuegosEntregados++;
            }
        }

        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);

        Serie serieConMasTemporadas = series[0];
        Videojuego videojuegoConMasHoras = videojuegos[0];

        for (Serie serie : series) {
            if (serie.getNumeroDeTemporadas() > serieConMasTemporadas.getNumeroDeTemporadas()) {
                serieConMasTemporadas = serie;
            }
        }

        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getHorasEstimadas() > videojuegoConMasHoras.getHorasEstimadas()) {
                videojuegoConMasHoras = videojuego;
            }
        }

        System.out.println("Serie con más temporadas: " + serieConMasTemporadas.getTitulo() +
                " con " + serieConMasTemporadas.getNumeroDeTemporadas() + " temporadas.");
        System.out.println("Videojuego con más horas estimadas: " + videojuegoConMasHoras.getTitulo() +
                " con " + videojuegoConMasHoras.getHorasEstimadas() + " horas.");
    }
}

