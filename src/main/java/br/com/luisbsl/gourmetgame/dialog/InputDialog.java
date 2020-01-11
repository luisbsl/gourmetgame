package br.com.luisbsl.gourmetgame.dialog;

import javax.swing.JOptionPane;

/**
 * 
 * @author luislima
 *
 */
public class InputDialog implements IInputDialog {

	protected String question;
	protected String title;
	protected String errorMessage;

	public InputDialog(String question, String title) {
		this.question = question;
		this.title = title;
	}

	@Override
	public String showDialog(final String errorMessage) {
		String input = "";

		do {
			input = verifyInput(JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE),
					errorMessage);
			
			if(input.isEmpty()) {
				JOptionPane.showConfirmDialog(null, errorMessage, "Erro", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE);
			}
			
		} while (input.isEmpty());

		return input.toUpperCase();
	}

}
