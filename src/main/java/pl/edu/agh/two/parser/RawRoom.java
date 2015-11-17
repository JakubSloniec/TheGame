package pl.edu.agh.two.parser;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class RawRoom {

    private int id;
    private int x;
    private int y;
    private String type;
    private String precondition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("COORDS: " + "(" + getX() + ", " + getY() + ")");
        sb.append(" TYPE: " + getType());
        sb.append(" PRECONDITION: " + getPrecondition());
        sb.append("\n");
        return sb.toString();
    }
}
