package br.com.luisbsl.gourmetgame.dialog;

import javax.swing.JOptionPane;

/**
 * 
 * @author luislima
 *
 */
public class ConfirmDialog implements IConfirmDialog {
	
	private String message;
	private int typeMessage;
	private static final String title = "Game Gourmet";
	
	public ConfirmDialog() {
		message = "Pense em um prato que gosta";
		typeMessage = JOptionPane.PLAIN_MESSAGE;
	}
	
	public ConfirmDialog(String message, int typeMessage) {
		this.message = message;
		this.typeMessage = typeMessage;
	}

	@Override
	public int showDialog() {
		return verifyOption(JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
				typeMessage));
	}

}
