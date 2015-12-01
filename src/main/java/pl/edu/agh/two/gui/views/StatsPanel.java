package pl.edu.agh.two.gui.views;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.factories.PlayerStatisticsFactory;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {

	private static final int HEIGHT = 20;
	private static final int STAT_NAME_COLUMN = 1;
	private static final int STAT_VAL_COLUMN = 2;
	
	private JPanel statList;

	public StatsPanel() {
		statList = createStatPanel();
		//mock();
	}

	private void mock() {
		Set<IPlayerStatistic> stats = new HashSet<>();
		stats.add(PlayerStatisticsFactory.createPlayerStatistic("stat 1", 15.));
		stats.add(PlayerStatisticsFactory.createPlayerStatistic("stat 2", 1.));
		stats.add(PlayerStatisticsFactory.createPlayerStatistic("stat 3", 15.5));
		stats.add(PlayerStatisticsFactory.createPlayerStatistic("stat 4", 0.));
		stats.add(PlayerStatisticsFactory.createPlayerStatistic("stat 5", 9.0));
		paint(stats);
	}

	private JPanel createStatPanel() {
		JPanel statList = new JPanel();
		statList.setLayout(new MigLayout("", "", ""));
		return statList;
	}

	public void paint(Set<IPlayerStatistic> statistics) {
		statList = createStatPanel();
		int row = 0;
		for (IPlayerStatistic stat : statistics) {
			row = row + 1;
			String attributeName = stat.getAttribute().getName();
			Double currentValue = stat.getCurrentValue();
			addCell(getStatNameCell(attributeName), 1, row);
			addCell(getStatValueCell(currentValue), 2, row);
		}

		add(statList);
	}

	private Component getStatValueCell(Double name) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(name.toString());
		panel.add(jlabel);
		return panel;
	}

	private Component getStatNameCell(String statName) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(statName);
		panel.add(jlabel);
		return panel;
	}

	private void addCell(Component component, int column, int row) {
		statList.add(component, "cell " + column + " " + row + ", width :" + checkWidth(column) + ":, height :" + HEIGHT + ":");
	}

	private int checkWidth(int column) {
		switch (column) {
		case STAT_NAME_COLUMN:
			return 200;
		case STAT_VAL_COLUMN:
			return 40;

		default:
			break;
		}
		throw new RuntimeException("No column width configuration for stat panel column " + column);
	}
}
