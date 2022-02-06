package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Knight;

public class KnightBlack extends Knight {

    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return knightWay(source, dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
