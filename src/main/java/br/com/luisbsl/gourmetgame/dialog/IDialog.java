package br.com.luisbsl.gourmetgame.dialog;

/**
 * 
 * @author luislima
 *
 */
public interface IDialog {
	
	public default void closeProgram() {
		System.out.println("Goodbye");
		System.exit(0);
	}

}
