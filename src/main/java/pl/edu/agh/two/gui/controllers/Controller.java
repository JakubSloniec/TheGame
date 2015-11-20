package pl.edu.agh.two.gui.controllers;

import org.springframework.stereotype.Component;

import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.gui.views.RootFrame;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */

@Component
public class Controller {

	private RootFrame rootFrame;

	public void init() {
		rootFrame = new RootFrame();
		rootFrame.setVisible(true);

		rootFrame.getInputPanel().getBtnEnter().addActionListener(a -> clickEnter());
		// displayMap();
	}

	public void clickEnter() {
		String input = getInputText();

		clearInputField();

		// Some proccessing to be done here
		String output = "Response in console for input: " + input;

		appendInConsole(">" + input + "\n");
		appendInConsole(output);
	}

	public void displayMap(Map map) {
		rootFrame.getMapPanel().paint(map);
	}

	public void displayBag() {

	}

	public void displayStats() {

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
