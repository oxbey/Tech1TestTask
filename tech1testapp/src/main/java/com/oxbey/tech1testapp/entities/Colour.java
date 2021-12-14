package com.oxbey.tech1testapp.entities;

import lombok.Data;

import java.util.Random;

public enum Colour {
    RED ("red"),
    BLACK ("black"),
    YELLOW("yellow"),
    WHITE ("white"),
    GREEN("green"),
    BLUE ("blue");

    String currency;

    Colour(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Colour{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
