package pl.edu.agh.two.exceptions;

public class UnmatchableAnswer extends RuntimeException {
    @Override
    public String getMessage() {
        return "Unmatchable answer.";
    }
}
