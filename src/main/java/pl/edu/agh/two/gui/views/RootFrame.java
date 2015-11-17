package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.border.MatteBorder;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class RootFrame extends JFrame {

	private ConsolePanel consolePanel;
	private InputPanel inputPanel;
	private MapPanel mapPanel;
	private CardPanel cardPanel;

	public RootFrame() {
		setTitle("IET Game");
		setResizable(false);
		// Image icon = null;
		// try {
		// icon =
		// ImageIO.read(getClass().getClassLoader().getResourceAsStream("icon.png"));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// setIconImage(icon);

		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// int windowWidth =
		// Integer.parseInt(PropertyManager.getProperty("window.width"));
		int windowWidth = 1000;
		// int windowHeight =
		// Integer.parseInt(PropertyManager.getProperty("window.height"));
		int windowHeight = 700;

		setBounds(100, 100, windowWidth, windowHeight);

		getContentPane().setLayout(new BorderLayout(0, 0));

		consolePanel = new ConsolePanel();
		consolePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		inputPanel = new InputPanel();
		inputPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mapPanel = new MapPanel();
		mapPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cardPanel = new CardPanel();
		cardPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		// int dividerLeftLocation =
		// Integer.parseInt(PropertyManager.getProperty("window.divider.left.location"));
		int dividerLeftLocation = 640;
		// boolean dividerLeftEnabled =
		// Boolean.parseBoolean(PropertyManager.getProperty("window.divider.left.enabled"));
		boolean dividerLeftEnabled = false;

		JSplitPane splitPane_left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, consolePanel, inputPanel);
		splitPane_left.setEnabled(dividerLeftEnabled);
		splitPane_left.setDividerSize(5);
		splitPane_left.setDividerLocation(dividerLeftLocation);

		// int dividerRightLocation =
		// Integer.parseInt(PropertyManager.getProperty("window.divider.right.location"));
		int dividerRightLocation = 205;
		// boolean dividerRightEnabled =
		// Boolean.parseBoolean(PropertyManager.getProperty("window.divider.right.enabled"));
		boolean dividerRightEnabled = false;

		JSplitPane splitPane_right = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mapPanel, cardPanel);
		splitPane_right.setEnabled(dividerRightEnabled);
		splitPane_right.setDividerSize(5);
		splitPane_right.setDividerLocation(dividerRightLocation);

		// int dividerCenterLocation =
		// Integer.parseInt(PropertyManager.getProperty("window.divider.center.location"));
		int dividerCenterLocation = 750;
		// boolean dividerCenterEnabled =
		// Boolean.parseBoolean(PropertyManager.getProperty("window.divider.center.enabled"));
		boolean dividerCenterEnabled = false;

		JSplitPane splitPane_center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane_left, splitPane_right);
		splitPane_center.setEnabled(dividerCenterEnabled);
		splitPane_center.setDividerSize(5);
		splitPane_center.setDividerLocation(dividerCenterLocation);

		getContentPane().add(splitPane_center, BorderLayout.CENTER);

		this.getRootPane().setDefaultButton(inputPanel.getBtnEnter());
	}

	public ConsolePanel getConsolePanel() {
		return consolePanel;
	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public MapPanel getMapPanel() {
		return mapPanel;
	}

	public CardPanel getCardPanel() {
		return cardPanel;
	}

	public void setConsolePanel(ConsolePanel consolePanel) {
		this.consolePanel = consolePanel;
	}

	public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public void setMapPanel(MapPanel mapPanel) {
		this.mapPanel = mapPanel;
	}

	public void setCardPanel(CardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

}
