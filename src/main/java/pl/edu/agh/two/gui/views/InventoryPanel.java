package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.players.Backpack;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class InventoryPanel extends JPanel {

	private static final int AMOUNT_COLUMN = 3;
	private static final int ITEM_COLUMN = 2;
	private static final int ICON_COLUMN = 1;
	private static final int height = 20;
	private JPanel itemList;

	public InventoryPanel() {
		setLayout(new BorderLayout(0, 0));
		itemList = createItemPanel();
	}

	private JPanel createItemPanel() {
		JPanel itemList = new JPanel();
		itemList.setLayout(new MigLayout("", "", ""));
		return itemList;
	}

	public void paint(Backpack backpack) {
		itemList = createItemPanel();
		Map<IItem, Integer> items = backpack.getItems();
		int row = 0;
		for (Entry<IItem, Integer> entry : items.entrySet()) {
			IItem item = entry.getKey();
			Integer amount = entry.getValue();
			row = row + 1;
			addCell(getItemIconPanel(item.getIconName()), ICON_COLUMN, row);
			addCell(getItemNamePanel(item.getName()), ITEM_COLUMN, row);
			addCell(getItemAmountPanel(amount), AMOUNT_COLUMN, row);
		}

		add(itemList);
	}

	private Component getItemAmountPanel(Integer amount) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(amount.toString());
		panel.add(jlabel);
		return panel;
	}

	private Component getItemNamePanel(String name) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(name);
		panel.add(jlabel);
		return panel;
	}

	private Component getItemIconPanel(String iconName) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBackground(Color.BLUE);
		JLabel jlabel = new JLabel(iconName);
		panel.add(jlabel);
		return panel;
	}

	private void addCell(Component component, int column, int row) {
		itemList.add(component, "cell " + column + " " + row + ", width :" + checkWidth(column) + ":, height :" + height + ":");
	}

	private int checkWidth(int column) {
		switch (column) {
		case ICON_COLUMN:
			return height;
		case ITEM_COLUMN:
			return 190;
		case AMOUNT_COLUMN:
			return 20;

		default:
			break;
		}
		throw new RuntimeException("No column width configuration for inventory panel column " + column);
	}

}
