package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import pl.edu.agh.two.utils.PropertyManager;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class CardPanel extends JPanel {

	// private static final String TAB_INVENTORY = "Inventory";
	// private static final String TAB_STATS = "Statistics";
	// private static final String TAB_QUEST = "Quests";

	private InventoryPanel inventoryPanel;
	private StatsPanel statsPanel;
	private QuestPanel questPanel;

	public CardPanel() {
		setLayout(new BorderLayout(0, 0));
		init();
	}

	private void init() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		statsPanel = new StatsPanel();
		tabbedPane.addTab(PropertyManager.getProperty("window.tabs.statistics"), statsPanel);

		inventoryPanel = new InventoryPanel();
		tabbedPane.addTab(PropertyManager.getProperty("window.tabs.inventory"), inventoryPanel);

		// questPanel = new QuestPanel();
		// tabbedPane.addTab(TAB_QUEST, questPanel);

		add(tabbedPane);
	}

	public InventoryPanel getInventoryPanel() {
		return inventoryPanel;
	}

	public StatsPanel getStatsPanel() {
		return statsPanel;
	}

	public QuestPanel getQuestPanel() {
		return questPanel;
	}

}
