package br.com.luisbsl.gourmetgame.dialog;

import javax.swing.JOptionPane;

/**
 * 
 * @author luislima
 *
 */
public class ConfirmQuestionDialog implements IConfirmDialog {

	protected String title = "Confirm";
	protected String food;	
	protected String type;
	protected final String defaultFoodQuestion;
	public final static String defaultFood = "BOLO DE CHOCOLATE";
	protected final String[] options = { "Sim", "Não" };
	
	public ConfirmQuestionDialog() {
		this(QuestionDialog.defaultFood);
	}

	public ConfirmQuestionDialog(String food) {
		this.food = food;
		defaultFoodQuestion = "O prato que você pensou é "+food+"?";
	}
	
	public ConfirmQuestionDialog(String food, String defaultFoodQuestion) {
		this.food = food;
		this.defaultFoodQuestion = defaultFoodQuestion;
	}
	
	public String getFood() {
		return food;
	}
	
	public String getQuestion() {
		return defaultFoodQuestion;
	}

	@Override
	public int showDialog() {
		return verifyOption(JOptionPane.showOptionDialog(null, getQuestion(), title,
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
	}

}
