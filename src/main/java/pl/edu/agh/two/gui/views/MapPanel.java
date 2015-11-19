package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private JPanel map;

	private int cellSize = 30;

	public MapPanel() {

		map = new JPanel();
		map.setLayout(new MigLayout("", "[][]", "[][]"));
		map.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		addMapCell(getEmptyPanel(), 0, 0);
		addMapCell(getWallPanel(), 0, 1);
		addMapCell(getEmptyPanel(), 0, 2);
		addMapCell(getWallPanel(), 0, 3);
		addMapCell(getWallPanel(), 1, 0);
		addMapCell(getWallPanel(), 1, 1);
		addMapCell(getPlayerPanel(), 1, 2);
		addMapCell(getWallPanel(), 1, 3);
		addMapCell(getEmptyPanel(), 2, 0);
		addMapCell(getEmptyPanel(), 2, 1);
		addMapCell(getEmptyPanel(), 2, 2);
		addMapCell(getWallPanel(), 2, 3);
		addMapCell(getWallPanel(), 3, 0);
		addMapCell(getWallPanel(), 3, 1);
		addMapCell(getEmptyPanel(), 3, 2);
		addMapCell(getWallPanel(), 3, 3);

		add(map, BorderLayout.CENTER);
	}

	public void addMapCell(Component component, int column, int row) {
		map.add(component, "cell " + column + " " + row);
	}

	public JPanel getWallPanel() {
		JPanel panel = new JPanel();

		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, cellSize, cellSize);

		return panel;
	}

	public JPanel getPlayerPanel() {
		JPanel panel = new JPanel();

		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, cellSize, cellSize);

		return panel;
	}

	public JPanel getEmptyPanel() {
		JPanel panel = new JPanel();

		panel.setBounds(0, 0, cellSize, cellSize);

		return panel;
	}

}
