package pl.edu.agh.two;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import pl.edu.agh.two.gui.controllers.Controller;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@Component
public class AppGUI {

	private static Controller controller;

	@Autowired
	public AppGUI(Controller controller) {
		AppGUI.controller = controller;
	}

	public static void main(String[] args) {
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		Runnable doStart = new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
						| IllegalAccessException e1) {
					e1.printStackTrace();
				}

				// Controller controller = new Controller();
				controller.init();
			}
		};
		SwingUtilities.invokeLater(doStart);
	}
}
