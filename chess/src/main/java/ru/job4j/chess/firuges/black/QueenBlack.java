package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Queen;

public class QueenBlack extends Queen {

    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return queenWay(source, dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
