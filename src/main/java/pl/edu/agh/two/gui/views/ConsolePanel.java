package pl.edu.agh.two.gui.views;

import java.awt.*;

import javax.swing.*;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class ConsolePanel extends JPanel {

	private JTextArea console;

	public ConsolePanel() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		console = new JTextArea();

		console.setEditable(false);
		console.setLineWrap(true);
		console.setFont(new Font("monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(console);
	}

	public void setText(String text) {
		this.console.setText(text);
	}

	public void appendText(String text) {
		this.console.append(text);
	}

	public void scrollToBottom() {
		console.setCaretPosition(console.getDocument().getLength());
	}

}
