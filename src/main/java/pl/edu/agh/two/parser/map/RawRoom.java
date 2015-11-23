package pl.edu.agh.two.parser.map;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class RawRoom {

    private int x;
    private int y;
    private String event;
    private RawPrecondition preconditions;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public RawPrecondition getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(RawPrecondition preconditions) {
        this.preconditions = preconditions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("COORDS: " + "(" + getX() + ", " + getY() + ")");
        sb.append(" EVENT: " + getEvent());
        sb.append(" PRECONDITION: " + getPreconditions());
        sb.append("\n");
        return sb.toString();
    }
}
