package pl.edu.agh.two.exceptions;

public class YouCannotEnterThisRoom extends Exception {
    public YouCannotEnterThisRoom(String message) {
        super(message);
    }
}
