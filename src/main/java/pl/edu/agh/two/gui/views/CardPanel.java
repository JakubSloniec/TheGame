package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class CardPanel extends JPanel {

	private static final String TAB_INVENTORY = "Inv";
	private static final String TAB_STATS = "Stats";
	private static final String TAB_QUEST = "Quests";

	private JPanel inventoryPanel;
	private JPanel statsPanel;
	private JPanel questPanel;

	public CardPanel() {
		setLayout(new BorderLayout(0, 0));
		init();
	}

	private void init() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		inventoryPanel = new InventoryPanel();
		tabbedPane.addTab(TAB_INVENTORY, inventoryPanel);

		statsPanel = new StatsPanel();
		tabbedPane.addTab(TAB_STATS, statsPanel);

		questPanel = new QuestPanel();
		tabbedPane.addTab(TAB_QUEST, questPanel);

		add(tabbedPane);
	}

}
