package pl.edu.agh.two.parser.command;

import pl.edu.agh.two.domain.rooms.Direction;
import pl.edu.agh.two.parser.exceptions.ParseException;

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

    public Direction parseDirection(String rest) throws ParseException {
        rest = rest.trim().toLowerCase();
        switch(rest) {
            case "north":
                return Direction.NORTH;
            case "south":
                return Direction.SOUTH;
            case "east":
                return Direction.EAST;
            case "west":
                return Direction.WEST;
            default:
                throw new ParseException("Invalid direction");
        }
    }

    // TODO: get more specifics
    public String getHelpString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Options manual:\n");
        stringBuilder.append("  answer - answer question\n");
        stringBuilder.append("  go [north|south|west|east] - move player in the specified direction\n");
        stringBuilder.append("  help - displays this manual\n");
        stringBuilder.append("  pick [item] - picks specified item\n");
        stringBuilder.append("  repeat - describes the room\n");
        stringBuilder.append("  use [item] - uses specified item");

        return stringBuilder.toString();
    }
}
