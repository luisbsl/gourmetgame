package br.com.luisbsl.gourmetgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.luisbsl.gourmetgame.dialog.ConfirmDialog;
import br.com.luisbsl.gourmetgame.dialog.ConfirmQuestionDialog;
import br.com.luisbsl.gourmetgame.dialog.InputDialog;
import br.com.luisbsl.gourmetgame.dialog.QuestionDialog;

/**
 * 
 * @author luislima
 *
 */
public class GourmetGame {

	private Map<String, List<ConfirmQuestionDialog>> foodMap;

	public GourmetGame() {
		init();
	}

	private void init() {
		ConfirmQuestionDialog cq = new ConfirmQuestionDialog("LASANHA");
		List<ConfirmQuestionDialog> questions = new ArrayList<>(Arrays.asList(cq));
		foodMap = new HashMap<String, List<ConfirmQuestionDialog>>();
		foodMap.put("MASSA", questions);
	}

	private void askQuestions() {
		initGame();

		int mapIdx = 0;
		for (Map.Entry<String, List<ConfirmQuestionDialog>> entry : foodMap.entrySet()) {

			final String currFood = entry.getKey();
			int answerTypeFood = new ConfirmQuestionDialog(currFood).showDialog();

			List<ConfirmQuestionDialog> questions = entry.getValue();
			if (answerTypeFood == JOptionPane.YES_OPTION) {
				iterateFoodQuestions(questions, entry.getKey());
			} else if (mapIdx + 1 == foodMap.size()) {
				askLastQuestion();
				askQuestions();
			}

			mapIdx++;
		}
	}

	private void initGame() {
		new ConfirmDialog().showDialog();
	}

	public void iterateFoodQuestions(List<ConfirmQuestionDialog> questions, final String foodType) {
		int idx = 0;
		do {
			if (questions.get(idx).showDialog() == JOptionPane.NO_OPTION) {
				if (idx + 1 == questions.size()) {
					addNewQuestion(foodType);
					askQuestions();
				}
			} else {
				showSuccessMessage();
				askQuestions();
			}
			idx++;
		} while (idx < questions.size());
	}

	private String askThoughtFood() {
		return new InputDialog("Qual prato você pensou?", "Desisto").showDialog("Favor entrar com um prato válido");
	}

	private String askFoodType(final String thoughtFood) {
		return new InputDialog(thoughtFood + " é ______ mas " + QuestionDialog.defaultFood + " não", "Complete")
				.showDialog("Favor entrar com um tipo de prato válido");
	}

	private void addNewQuestion(final String foodType) {
		String food = askThoughtFood();
		foodMap.get(foodType).add(new ConfirmQuestionDialog(food));
	}

	private void askLastQuestion() {
		final int defaultQuestion = new ConfirmQuestionDialog(QuestionDialog.defaultFood).showDialog();

		if (defaultQuestion == JOptionPane.YES_OPTION) {
			showSuccessMessage();
		} else {
			String thoughtFood = askThoughtFood();
			String typeFood = askFoodType(thoughtFood);

			ConfirmQuestionDialog cq = new ConfirmQuestionDialog(thoughtFood);
			if (foodMap.containsKey(typeFood)) {
				foodMap.get(typeFood).add(cq);
			} else {
				foodMap.put(typeFood, new ArrayList<>(Arrays.asList(cq)));
			}
		}
	}

	private void showSuccessMessage() {
		new ConfirmDialog("Acertei de novo!", JOptionPane.INFORMATION_MESSAGE).showDialog();
	}

	public static void main(String[] args) {
		GourmetGame gg = new GourmetGame();
		gg.askQuestions();
	}

}
