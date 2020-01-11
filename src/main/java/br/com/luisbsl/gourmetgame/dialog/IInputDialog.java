package br.com.luisbsl.gourmetgame.dialog;

/**
 * 
 * @author luislima
 *
 */
public interface IInputDialog extends IDialog {	
	
	public default String verifyInput(final String input, final String errorMessage) {
		if(input == null) {
			closeProgram();
		}	
		return input;
	}
	
	public String showDialog(final String errorMessage);

}
