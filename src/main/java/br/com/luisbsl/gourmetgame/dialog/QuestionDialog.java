package br.com.luisbsl.gourmetgame.dialog;

public abstract class QuestionDialog implements IDialog {
	
	protected String title = "Confirm";
	protected String food;	
	protected String type;
	protected final String defaultFoodQuestion;
	public final static String defaultFood = "BOLO DE CHOCOLATE";
	protected final String[] options = { "Sim", "Não" };
	
	public QuestionDialog() {
		this(QuestionDialog.defaultFood);
	}

	public QuestionDialog(String food) {
		this.food = food;
		defaultFoodQuestion = "O prato que você pensou é "+food+"?";
	}
	
	public QuestionDialog(String food, String defaultFoodQuestion) {
		this.food = food;
		this.defaultFoodQuestion = defaultFoodQuestion;
	}
	
	public String getFood() {
		return food;
	}
	
	public String getQuestion() {
		return defaultFoodQuestion;
	}

}
