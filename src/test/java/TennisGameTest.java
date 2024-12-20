import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TennisGameTest {


	@Test(expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
	}

	@Test(expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		// Act
		// This statement should cause an exception
		game.player2Scored();
	}

	@Test
	public void testTennisGame_Start() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);
	}

	@Test
	public void testTennisGame_Score_15To15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 15 to 15 incorrect", "15 - 15", score);
	}

	@Test
	public void testTennisGame_Score_30To30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 30 to 30 incorrect", "30 - 30", score);
	}

	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();

		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);
	}

	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_DeuceReversed() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);
	}

	@Test
	public void testTennisGame_Score_15ToLove() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 15 to love incorrect", "15 - love", score);
	}

	@Test
	public void testTennisGame_Score_LoveTo15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score love to 15 incorrect", "love - 15", score);
	}

	@Test
	public void testTennisGame_Score_30ToLove() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 30 to love incorrect", "30 - love", score);
	}

	@Test
	public void testTennisGame_Score_LoveTo30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score love to 30 incorrect", "love - 30", score);
	}

	@Test
	public void testTennisGame_Score_40ToLove() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 40 to love incorrect", "40 - love", score);
	}

	@Test
	public void testTennisGame_Score_LoveTo40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score love to 40 incorrect", "love - 40", score);
	}

	@Test
	public void testTennisGame_Score_30To15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 30 to 15 incorrect", "30 - 15", score);
	}

	@Test
	public void testTennisGame_Score_15To30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 15 to 30 incorrect", "15 - 30", score);
	}

	@Test
	public void testTennisGame_Score_40To15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 40 to 15 incorrect", "40 - 15", score);
	}

	@Test
	public void testTennisGame_Score_15To40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Score 15 to 40 incorrect", "15 - 40", score);
	}

	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored(); // player1Points = 1
		game.player1Scored(); // player1Points = 2
		game.player1Scored(); // player1Points = 3
		game.player2Scored(); // player2Points = 1
		game.player2Scored(); // player2Points = 2
		game.player2Scored(); // player2Points = 3
		game.player1Scored(); // player1Points = 4 (Advantage)
		String score = game.getScore();
		// Assert
		assertEquals("Player1 Has advantage, score incorrect", "player1 has advantage", score);
	}

	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player2Scored(); // player2Points = 1
		game.player2Scored(); // player2Points = 2
		game.player2Scored(); // player2Points = 3
		game.player1Scored(); // player1Points = 1
		game.player1Scored(); // player1Points = 2
		game.player1Scored(); // player1Points = 3
		game.player2Scored(); // player2Points = 4 (Advantage)
		String score = game.getScore();
		// Assert
		assertEquals("Player2 has advantage, score incorrect", "player2 has advantage", score);
	}

	@Test
	public void testTennisGame_Player1WinsGame() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Player 1 win score incorrect", "player1 wins", score);
	}

	@Test
	public void testTennisGame_Player2WinsGame() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		// Assert
		assertEquals("Player 2 win score incorrect", "player2 wins", score);
	}

	// Tests below this line are added after the mutation testing was done first time.

	@Test
	public void testTennisGame_Player1WinsAtBoundary() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		// Assert
		assertEquals("Player 1 win score incorrect", "player1 wins", game.getScore());
	}


	@Test
	public void testTennisGame_Player2WinsAtBoundary() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		// Assert
		assertEquals("Player 2 win score incorrect", "player2 wins", game.getScore());
	}

	@Test
	public void testTennisGame_InvalidDefaultScore() throws Exception {
		// Arrange
		TennisGame game = new TennisGame();
		// Use reflection to access the private getScore method
		Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
		getScoreMethod.setAccessible(true);
		// Act
		String score = (String) getScoreMethod.invoke(game, 4); // Invalid score
		// Assert
		assertEquals("Invalid score incorrect", "40", score);
	}

	@Test
	public void testTennisGame_DeuceAtBoundary() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		// Assert
		assertEquals("Deuce score incorrect", "deuce", game.getScore());
	}

	@Test(expected = TennisGameException.class)
	public void testTennisGame_InvalidScore_ThrowsExceptionPlayer1() throws Exception {
		TennisGame game = new TennisGame();

		// Use reflection to modify score directly
		Field field = TennisGame.class.getDeclaredField("player1Points");
		field.setAccessible(true);
		field.set(game, -1); // Set an invalid negative score

		// Attempt to get the score
		game.getScore();
	}

	@Test
	public void testPlayer1WinsWithExactPoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player1Scored(); // 4
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsWithExactPoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player2Scored(); // 4
		assertEquals("player2 wins", game.getScore());
	}



	@Test
	public void testPlayer1HasAdvantageExactPoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		assertEquals("player1 has advantage, score incorrect", "player1 has advantage", game.getScore());
	}

	@Test
	public void testPlayer2HasAdvantageExactPoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 has advantage score incorrect", "player2 has advantage", game.getScore());
	}

	@Test
	public void testPlayer1WinsAfterAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 4 (Advantage)
		game.player1Scored(); // 5 (Wins)
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsAfterAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 4 (Advantage)
		game.player2Scored(); // 5 (Wins)
		assertEquals("player2 wins", game.getScore());
	}

	@Test
	public void testPlayer1LosesAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 4 (Advantage)
		game.player2Scored(); // 4 (Deuce)
		assertEquals("deuce", game.getScore());
	}

	@Test
	public void testPlayer2LosesAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 4 (Advantage)
		game.player1Scored(); // 4 (Deuce)
		assertEquals("deuce", game.getScore());
	}

	@Test
	public void testPlayer1WinsAfterDeuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 4 (Advantage)
		game.player2Scored(); // 4 (Deuce)
		game.player1Scored(); // 5 (Advantage)
		game.player1Scored(); // 6 (Wins)
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsAfterDeuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 4 (Advantage)
		game.player1Scored(); // 4 (Deuce)
		game.player2Scored(); // 5 (Advantage)
		game.player2Scored(); // 6 (Wins)
		assertEquals("player2 wins", game.getScore());
	}

	@Test
	public void testPlayer1WinsAfterAdvantageAndDeuceTransitions() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 4 (Advantage)
		game.player2Scored(); // 4 (Deuce)
		game.player1Scored(); // 5 (Advantage)
		game.player2Scored(); // 5 (Deuce)
		game.player1Scored(); // 6 (Advantage)
		game.player1Scored(); // 7 (Wins)
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsAfterAdvantageAndDeuceTransitions() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 1
		game.player2Scored(); // 2
		game.player2Scored(); // 3
		game.player1Scored(); // 1
		game.player1Scored(); // 2
		game.player1Scored(); // 3
		game.player2Scored(); // 4 (Advantage)
		game.player1Scored(); // 4 (Deuce)
		game.player2Scored(); // 5 (Advantage)
		game.player1Scored(); // 5 (Deuce)
		game.player2Scored(); // 6 (Advantage)
		game.player2Scored(); // 7 (Wins)
		assertEquals("player2 wins", game.getScore());
	}

	@Test
	public void testPlayer1WinsByTwo() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored(); // 1-0
		game.player1Scored(); // 2-0
		game.player1Scored(); // 3-0
		game.player2Scored(); // 3-1
		game.player1Scored(); // 4-1 Player 1 wins
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsByTwo() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored(); // 0-1
		game.player2Scored(); // 0-2
		game.player2Scored(); // 0-3
		game.player1Scored(); // 1-3
		game.player2Scored(); // 1-4 Player 2 wins
		assertEquals("player2 wins", game.getScore());
	}

	@Test
	public void testPlayer1WinsByTwoAfterMorePoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();//1-0
		game.player2Scored();//1-1
		game.player1Scored();//2-1
		game.player2Scored();//2-2
		game.player1Scored();//3-2
		game.player2Scored();//3-3
		game.player1Scored();//4-3
		game.player1Scored();//5-3 Player 1 wins
		assertEquals("player1 wins", game.getScore());
	}

	@Test
	public void testPlayer2WinsByTwoAfterMorePoints() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored();//0-1
		game.player1Scored();//1-1
		game.player2Scored();//1-2
		game.player1Scored();//2-2
		game.player2Scored();//2-3
		game.player1Scored();//3-3
		game.player2Scored();//3-4
		game.player2Scored();//3-5 Player 2 wins
		assertEquals("player2 wins", game.getScore());
	}


}


