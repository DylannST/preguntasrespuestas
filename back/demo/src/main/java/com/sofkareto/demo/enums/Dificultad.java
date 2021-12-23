package com.sofkareto.demo.enums;

public enum Dificultad {
    FACIL("FACIL"), NORMAL("NORMAL"), DIFICIL("DIFICIL"), MUYDIFICIL("MUYDIFICIL"), MAXIMO("MAXIMO");

    private String dificultad;

    Dificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return dificultad;
    }
}
