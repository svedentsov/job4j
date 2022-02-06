package ru.job4j.chess.firuges;

/**
 * Abstract class for a Pawn.
 */
public abstract class Pawn implements Figure {

    public Cell[] pawnWayBlack(Cell source, Cell dest) {
        Cell[] steps;
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("You can't walk like that. ");
        }
        return steps;
    }

    public Cell[] pawnWayWhite(Cell source, Cell dest) {
        Cell[] steps;
        if (source.y == dest.y - 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("You can't walk like that. ");
        }
        return steps;
    }
}
