package pl.edu.agh.two.gui.views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel {

	private JTextField textFieldInput;

	private JButton btnEnter;

	public InputPanel() {
		setLayout(new BorderLayout(0, 0));

		btnEnter = new JButton("Enter");
		add(btnEnter, BorderLayout.EAST);

		JLabel label = new JLabel(">");
		add(label, BorderLayout.WEST);

		textFieldInput = new JTextField();
		add(textFieldInput, BorderLayout.CENTER);
	}

	public String getInput() {
		return textFieldInput.getText();
	}

	public void clearInput() {
		textFieldInput.setText("");
	}

	public JTextField getTextFieldInput() {
		return textFieldInput;
	}

	public JButton getBtnEnter() {
		return btnEnter;
	}

	public void setTextFieldInput(JTextField textFieldInput) {
		this.textFieldInput = textFieldInput;
	}

	public void setBtnEnter(JButton btnEnter) {
		this.btnEnter = btnEnter;
	}

}
