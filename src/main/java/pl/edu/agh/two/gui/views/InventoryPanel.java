package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import pl.edu.agh.two.domain.attributes.ItemAttribute;
import pl.edu.agh.two.domain.items.AbstractAttributeItem;
import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.players.Backpack;
import pl.edu.agh.two.factories.ItemsFactory;

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
	//	mock();
	}

	private void mock() {
		Backpack bp = Backpack.createBackpack();
		Map<String, Double> beerAttributes = new HashMap<String, Double>();
		beerAttributes.put("si³a", (double) 10);
		beerAttributes.put("moc", (double) 15);
		IItem item = ItemsFactory.createPernamentItem("Piwo", Optional.of(beerAttributes), Optional.empty());
		bp.addItem(item);
		bp.addItem(item);
		bp.addItem(item);
		
		paint(bp);
	}

	private JPanel createItemPanel() {
		JPanel itemList = new JPanel();
		itemList.setLayout(new MigLayout("", "", ""));
		return itemList;
	}

	public void paint(Backpack backpack) {
		itemList = createItemPanel();
		Map<IItem, Integer> items = backpack.getItems();
		int row = 1;
		for (Entry<IItem, Integer> entry : items.entrySet()) {
			IItem item = entry.getKey();
			Integer amount = entry.getValue();
			JPanel iconPanel = getItemIconPanel(item.getIconName());
			JPanel namePanel = getItemNamePanel(item.getName());
			JPanel amountPanel = getItemAmountPanel(amount);

			if (item instanceof AbstractAttributeItem) {
				String tooltipText = generateTooltip((AbstractAttributeItem)item, amount);
				iconPanel.setToolTipText(tooltipText);
				namePanel.setToolTipText(tooltipText);
				amountPanel.setToolTipText(tooltipText);
			}
			
			addCell(iconPanel, ICON_COLUMN, row);
			addCell(namePanel, ITEM_COLUMN, row);
			addCell(amountPanel, AMOUNT_COLUMN, row);
			
			row = row + 1;
		}

		add(itemList);
	}

	private String generateTooltip(AbstractAttributeItem item, Integer amount) {
		String tooltip = "<html>Ten przedmiot zmienia twoje statystyki! <br/>";
		Set<ItemAttribute> attributes = item.getAttributes();
		for (ItemAttribute itemAttribute : attributes) {
			Double changeValue = itemAttribute.getChangeValue();
			if (changeValue < 0) {
				tooltip = tooltip + "<br/>- ";
			} else {
				tooltip = tooltip + "<br/>+ ";
			}
			tooltip = tooltip + amount*changeValue + " " + itemAttribute.getAttribute().getName();
		}
		
		return tooltip + "</html>";
	}

	private JPanel getItemAmountPanel(Integer amount) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(amount.toString());
		panel.add(jlabel);
		return panel;
	}

	private JPanel getItemNamePanel(String name) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		JLabel jlabel = new JLabel(name);
		panel.add(jlabel);
		return panel;
	}

	private JPanel getItemIconPanel(String iconName) {
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
