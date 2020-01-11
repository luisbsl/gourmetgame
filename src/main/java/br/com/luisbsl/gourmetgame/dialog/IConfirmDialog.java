package br.com.luisbsl.gourmetgame.dialog;

import javax.swing.JOptionPane;

/**
 * 
 * @author luislima
 *
 */
public interface IConfirmDialog extends IDialog {
	
	public default int verifyOption(final int option) {
		if(option == JOptionPane.CLOSED_OPTION) {
			closeProgram();
		}
		
		return option;
	}
	
	public int showDialog();

}
