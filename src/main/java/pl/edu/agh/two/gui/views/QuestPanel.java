package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class QuestPanel extends JPanel {

	public QuestPanel() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblQuests = new JLabel("Quests");
		add(lblQuests, BorderLayout.CENTER);

	}

}
