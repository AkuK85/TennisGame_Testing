import static org.junit.Assert.*;
import org.junit.Test;

public class TennisGameTest {

	/*
	 Here is the format of the scores: "player1Score - player2Score"
	 "love - love"
	 "15 - 15"
	 "30 - 30"
	 "deuce"
	 "15 - love", "love - 15"
	 "30 - love", "love - 30"
	 "40 - love", "love - 40"
	 "30 - 15", "15 - 30"
	 "40 - 15", "15 - 40"
	 "player1 has advantage"
	 "player2 has advantage"
	 "player1 wins"
	 "player2 wins"
	*/

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
	public void testTennisGame_Start() {
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

}
