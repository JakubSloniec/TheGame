package pl.edu.agh.two.parser.map;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class RawMap {

    private int rows;
    private int columns;
    private List<RawRoom> rooms;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<RawRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<RawRoom> rooms) {
        this.rooms = rooms;
    }
}
