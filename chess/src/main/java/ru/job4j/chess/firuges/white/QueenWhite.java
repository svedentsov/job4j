package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Queen;

public class QueenWhite extends Queen {

    private final Cell position;

    public QueenWhite(final Cell position) {
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
        return new QueenWhite(dest);
    }
}
