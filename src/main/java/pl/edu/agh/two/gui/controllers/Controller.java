package pl.edu.agh.two.gui.controllers;

import java.util.Set;

import org.springframework.stereotype.Component;

import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.players.Backpack;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.factories.PlayersFactory;
import pl.edu.agh.two.gui.views.RootFrame;
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

	public void init(String playerName) {
		rootFrame = new RootFrame();
		rootFrame.setVisible(true);

		rootFrame.getInputPanel().getBtnEnter().addActionListener(a -> clickEnter());

		initMap();
		initPlayer(playerName);
	}

	private void initPlayer(String playerName) {
		player = PlayersFactory.createDefaultPlayer(playerName);
	}

	private void initMap() {
		map = MapFactory.getMap();
		displayMap(map);
	}

	public void clickEnter() {
		String input = getInputText();
		clearInputField();

		appendInConsole(">" + input + "\n");

		// Some proccessing to be done here

		String output = "Response in console for input: " + input;

		appendInConsole(output + "\n");
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
		rootFrame.getConsolePanel().appendText(text);
	}
}
