package cleancode.minesweeper.tobe.cell;

import java.util.Arrays;
import java.util.List;

public class Cells {
    private final List<Cell> cells;

    private Cells(List<Cell> cells){
        this.cells = cells;
    }

    public static Cells of(List<Cell> cells){
        return new Cells(cells);
    }

    //todo: stream 공부하기
    public static Cells from(Cell[][] cells) {
        List<Cell> cellList = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .toList();

        return of(cellList);
    }

    //todo: stream 공부하기
    public boolean isAllChecked() {
        return cells.stream()
                .allMatch(Cell::isChecked);
    }
}
