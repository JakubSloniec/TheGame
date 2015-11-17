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
	}
}
