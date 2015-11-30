package pl.edu.agh.two.parser.command;

public class Command {
    private Action action;
    private String rest;

    public Command(Action action, String rest) {
        this.action = action;
        this.rest = rest;
    }

    public Action getAction() {
        return action;
    }

    public String getRest() {
        return rest;
    }

    public static Action parseAction(String action) {
        switch(action.toLowerCase().trim()) {
            case "answer":
                return Action.ANSWER;
            case "go":
                return Action.GO;
            case "help":
                return Action.HELP;
            case "pick":
                return Action.PICK;
            case "repeat":
                return Action.REPEAT;
            case "use":
                return Action.USE;
            default:
                return Action.NONE;
        }
    }

    @Override
    public String toString() {
        return action.toString() + ": " + rest;
    }
}
