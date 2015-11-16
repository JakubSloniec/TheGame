package pl.edu.agh.two.theGame.console.command;

import pl.edu.agh.two.theGame.console.exception.ParseException;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public Command parse(String line) throws ParseException {
        List<String> splits = splitLine(line);
        if(isLineValid(line)) {
            Action action = Command.parseAction(splits.get(0));
            if (action.equals(Action.NONE) == false) {
                String rest = line.substring(splits.get(0).length()).trim();
                return new Command(action, rest);
            } else {
                throw new ParseException("Invalid command");
            }
        } else {
            throw new ParseException("Invalid line");
        }
    }

    private List<String> splitLine(String line) {
        return Arrays.asList(line.trim().split(" "));
    }

    private boolean isLineValid(String line) {
        List<String> splits = splitLine(line);
        return splits.size() >= 1 && splits.get(0).length() > 0;
    }
}
