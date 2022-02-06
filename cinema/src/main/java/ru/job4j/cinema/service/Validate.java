package ru.job4j.cinema.service;

import ru.job4j.cinema.model.Seat;
import ru.job4j.cinema.model.User;

import java.util.List;

public interface Validate {

    List<Seat> getSeats();

    void makePayment(Seat seat, User user);
}
