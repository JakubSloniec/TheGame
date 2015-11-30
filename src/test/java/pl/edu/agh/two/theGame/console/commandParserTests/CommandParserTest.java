package pl.edu.agh.two.theGame.console.commandParserTests;

import pl.edu.agh.two.parser.command.Command;
import pl.edu.agh.two.parser.command.CommandParser;
import pl.edu.agh.two.parser.exceptions.ParseException;

public class CommandParserTest {
    public static void main(String[] args) {
        System.out.println("---- Testing basic command parse ----");

        CommandParser commandParser = new CommandParser();
        Command testCommand;
        // Parsing some basic commands
        try {
            testCommand = commandParser.parse("go north");
            System.out.println(testCommand);
            testCommand = commandParser.parse("hElP");
            System.out.println(testCommand);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
