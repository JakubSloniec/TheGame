package pl.edu.agh.two.gui.controllers;

import java.util.Set;

import org.springframework.stereotype.Component;

import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.players.Backpack;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.domain.rooms.Direction;
import pl.edu.agh.two.factories.PlayersFactory;
import pl.edu.agh.two.gui.views.RootFrame;
import pl.edu.agh.two.parser.command.Command;
import pl.edu.agh.two.parser.command.CommandParser;
import pl.edu.agh.two.parser.factories.ItemsInitializer;
import pl.edu.agh.two.parser.factories.MapFactory;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */

@Component
public class Controller {

	private Map map;
	private IPlayer player;
	private RootFrame rootFrame;

	private CommandParser commandParser;

	public void init(String playerName) {
		rootFrame = new RootFrame();
		rootFrame.setVisible(true);
		rootFrame.getInputPanel().getBtnEnter().addActionListener(a -> clickEnter());

		commandParser = new CommandParser();

		initItems();
		initMap();
		initPlayer(playerName);
		displayStats(player.getStatistics());
		displayBag(player.getBackpack());
	}

	private void initItems() {
		ItemsInitializer.initializeItems();
	}

	private void initPlayer(String playerName) {
		player = PlayersFactory.createDefaultPlayer(playerName);
		appendInConsole("Your name is " + playerName + ". Hello!");
		// TODO: room description required
		appendInConsole(map.getCurrentRoom().toString());
	}

	private void initMap() {
		map = MapFactory.getMap();
		displayMap(map);
	}

	public void clickEnter() {
		String input = getInputText();
		clearInputField();

		appendInConsole(">" + input);

		try {
			Command command = commandParser.parse(input);
			switch (command.getAction()) {
			case ANSWER:
				break;
			case GO:
				Direction direction = commandParser.parseDirection(command.getRest());
				map.go(direction, player);
				displayMap(map);
				break;
			case HELP:
				appendInConsole(commandParser.getHelpString());
				break;
			case PICK:
				break;
			case REPEAT:
				// TODO: room description required
				appendInConsole(map.getCurrentRoom().toString());
				break;
			case USE:
				break;
			}
			// TODO: create basic exception from which other exceptions will
			// extend
		} catch (Exception e) {
			appendInConsole(e.getMessage());
		}

		// Some proccessing to be done here
		// String output = "Response in console for input: " + input; // or
		// here,
		// it's mock
		// BTW
		displayStats(player.getStatistics());
		displayBag(player.getBackpack());
	}

	public void displayMap(Map map) {
		rootFrame.getMapPanel().paint(map);
	}

	public void displayBag(Backpack backpack) {
		rootFrame.getCardPanel().getInventoryPanel().paint(backpack);
	}

	public void displayStats(Set<IPlayerStatistic> statistics) {
		rootFrame.getCardPanel().getStatsPanel().paint(statistics);
	}

	public void clearInputField() {
		rootFrame.getInputPanel().clearInput();
	}

	public String getInputText() {
		return rootFrame.getInputPanel().getInput();
	}

	public void appendInConsole(String text) {
		rootFrame.getConsolePanel().appendText(text + "\n");
	}
}
