package pl.edu.agh.two.gui.views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.rooms.Coordinates;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.domain.rooms.Wall;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private JPanel mapPanel;

	private int cellSize = 20;

	public MapPanel() {
		mockMap();
	}

	public void mockMap() {
		mapPanel = new JPanel();
		mapPanel.setLayout(new MigLayout("", "", ""));
		mapPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		for (int column = 0; column < 10; column++) {
			for (int row = 0; row < 10; row++) {
				if (row == 5 && column == 3) {
					setPlayer(column, row);
				} else if (row % 5 == 0) {
					setEmpty(column, row);
				} else if (column % 2 == 0) {
					setWall(column, row);
				} else {
					setEmpty(column, row);
				}
			}
		}
		add(mapPanel);
	}

	public void paint(Map map) {
		mapPanel = new JPanel();
		mapPanel.setLayout(new MigLayout("", "", ""));
		mapPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Coordinates currentCoords = map.getCurrentRoom().getCoordinates();
		for (IRoom[] rooms : map.getMap()) {
			for (IRoom room : rooms) {
				if (!currentCoords.equals(room.getCoordinates())) {
					addRoomToMap(room);
				}
			}
		}

		add(mapPanel);

	}

	private void addRoomToMap(IRoom room) {
		
		Coordinates coords = room.getCoordinates();
		if(room instanceof Wall){
			setWall(coords.getX(), coords.getY());
		} else if (room instanceof )
	}

	private void addMapCell(Component component, int column, int row) {
		mapPanel.add(component, "cell " + column + " " + row + ", width :" + cellSize + ":, height :" + cellSize + ":");
	}

	private JPanel getWallPanel() {
		JPanel panel = new JPanel();

		panel.setBackground(Color.BLACK);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		return panel;
	}

	private JPanel getPlayerPanel() {
		JPanel panel = new JPanel();

		panel.setBackground(Color.RED);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		return panel;
	}

	private JPanel getEmptyPanel() {
		JPanel panel = new JPanel();

		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		return panel;
	}

	public void setPlayer(int column, int row) {
		addMapCell(getPlayerPanel(), column, row);
	}

	public void setWall(int column, int row) {
		addMapCell(getWallPanel(), column, row);
	}

	public void setEmpty(int column, int row) {
		addMapCell(getEmptyPanel(), column, row);
	}
}
