package pl.edu.agh.two.gui.controllers;

import org.springframework.stereotype.Component;

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
	}

	/**
	 * default action called when enter button or enter key is pushed
	 */
	public void clickEnter() {
		String input = getInputText();

		clearInputField();

		// Some proccessing to be done here
		String output = "Response in console for input: " + input;

		appendInConsole(">" + input + "\n");
		appendInConsole(output);
	}

	/**
	 * placeholder for map display method
	 */
	public void displayMap() {

	}

	/**
	 * placeholder for bag display method
	 */
	public void displayBag() {

	}

	/**
	 * placeholder for stats display method
	 */
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
