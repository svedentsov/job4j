package ru.job4j.cinema.persistence;

import ru.job4j.cinema.model.Seat;
import ru.job4j.cinema.model.User;

import java.util.List;

public interface Store {

    List<Seat> getSeats();

    Seat getSeat(Seat seat);

    boolean makePayment(Seat seat, User user);
}
