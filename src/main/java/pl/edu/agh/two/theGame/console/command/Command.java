package pl.edu.agh.two.theGame.console.command;

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
            case "go":
                return Action.GO;
            case "pick":
                return Action.PICK;
            case "answer":
                return Action.ANSWER;
            case "repeat":
                return Action.REPEAT;
            case "help":
                return Action.HELP;
            default:
                return Action.NONE;
        }
    }

    @Override
    public String toString() {
        return action.toString() + ": " + rest;
    }
}
