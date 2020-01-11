package br.com.luisbsl.gourmetgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.luisbsl.gourmetgame.dialog.ConfirmQuestionDialog;

/**
 * Unit test for simple App.
 * 
 * @author luislima
 */
public class GourmetGameTest {
	
	private final String MASSA = "MASSA";

	@Test
	public void shouldInitializeFoodMap() throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		GourmetGame gg = new GourmetGame();

		Field privateFoodMap = GourmetGame.class.getDeclaredField("foodMap");
		privateFoodMap.setAccessible(true);
		Map<String, List<ConfirmQuestionDialog>> foodMap = (Map<String, List<ConfirmQuestionDialog>>) privateFoodMap.get(gg);

		assertEquals(1, foodMap.size());
		assertTrue(foodMap.containsKey(MASSA));
		assertEquals(1, foodMap.get(MASSA).size());
		assertEquals("LASANHA", foodMap.get(MASSA).get(0).getFood());
	}

}