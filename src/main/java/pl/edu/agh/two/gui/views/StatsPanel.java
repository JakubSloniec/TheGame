package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.JPanel;

import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {

	public StatsPanel() {
		setLayout(new BorderLayout(0, 0));
	}

	public void paint(Set<IPlayerStatistic> statistics) {
		
		
	}

}
