package com.dev.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
public class BowlingGameTest {

	private BowlingGame game;
	
	@Test
	public void validateSetUp() {
		assertTrue(true);
	}
	
	@Before
	public void setUp() {
		 game = new BowlingGame();
	}
	
	@Test
	public void testGameScoreForGutterBalls() {
		rollPins(20,0);

		assertEquals(0, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenTwoPinsDownPerRoll() {
		rollPins(20,2);

		assertEquals(40, game.calculateScore());
	}
	
	private void rollPins(int roll,int pins) {
		for(int index=0;index<roll;index++) {
			game.roll(pins);
		}
	}
	
	@Test
	public void testGameScoreWhenRollsAreMiss() {
		game.roll(5);
		game.roll(0);
		game.roll(0);
		rollPins(17,1);
		assertEquals(22, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenOneSpare() {
		game.roll(2);
		game.roll(8);
		game.roll(7);
		rollPins(17,2);
		
		assertEquals(58, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenLastRollSpare() {
		rollPins(18,2);
		game.roll(5);
		game.roll(5);
		game.roll(2);
		
		assertEquals(48, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenMultipleSpareOccur() {
		rollPins(16,2);
		game.roll(5);
		game.roll(5);
		game.roll(2);
		game.roll(8);
		game.roll(5);
		
		assertEquals(59, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenSpareAndMissOccur() {
		rollPins(16,2);
		game.roll(5);
		game.roll(5);
		game.roll(0);
		game.roll(0);
		
		assertEquals(42, game.calculateScore());
	}
}
