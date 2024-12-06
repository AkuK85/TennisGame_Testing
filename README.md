# **Tennis Game**

This project is part of Software Quality and Testing Course Autumn/2024 in University of Oulu. It is part of the 
Whitebox testing exercise and its meant to practice unit tests in java. This is my personal fork from the original 
branch provided by the course Teachers. Original can be found from https://github.com/SQATLab2016/TennisGame_Testing.git .

## **Changes to project Structure & Configuration**

Since the exercise was originally designed to be completed with Eclipse IDE and Eclemma plugin for code coverage. For 
personal preferences I did decided to complete it with IntelliJ IDEA IDE, also for the test purpose I picked Maven to be 
my choice of platform. Code coverage part of the exercise is handled with JaCoCo. 

To implement usage of maven I had to slightly alter the project structure. This makes sure it follows standard Maven
project directory layout. This also helps in maintaining consistency and makes it easier to understand. To configure Maven
there is new pom.xml file that is the core of Maven project. It contains needed configuration details used by Maven to 
build the project. It also contains dependencies required by the project, such as JUnit for testing and JaCoCo for code 
coverage. It also contains the build plugins needed to run the tests and generate the code coverage report. With this 
setup i can easily manage the project dependencies and ensure that all required plugins and libraries are up to date.
This is achieved with Mavens automatic dependency management. 

JaCoCo is a code coverage library that can be used to generate code coverage reports. It can be easily integrated with
Maven by adding the JaCoCo Maven plugin to the pom.xml file. It produces a code coverage report in HTML just like Eclemma.

## **New Project Structure**

The project structure is as follows:

-`src/main/java`: Contains the main Java source files.  
-`src/test/java`: Contains the test Java source files.  
-`pom.xml`: Maven configuration file.

## **Compatibility with original Design systems**

The original project was designed to be used with Eclipse IDE and Eclemma plugin for code coverage. Since I refactored
the project to be used with IntelliJ IDEA IDE and Maven. I had to make sure that the project is still compatible with the
original design systems. This is achieved by updating the .classpath and .project files to include the necessary 
dependencies and configurations. This should ensure that the project can be imported into Eclipse IDE and run with
Eclemma plugin without any issues.

## **First Round of Testing**

First round of testing with JaCoCo was successful. The tests were run using Maven and the code coverage report can be
found below.

![Code Coverage Report](/images/CodeCoverageR1.png)

### **Coverage Rates**

### Coverage Rate by Lines

- Coverage Rate: 74%
- Covered Lines: 29
- Missed Lines: 10
- Total Lines: 39

### Coverage Rate by Branches

- Coverage Rate: 54%
- Covered Branches: 18
- Missed Branches: 15
- Total Branches: 33

### Coverage Rate of Methods

- Coverage Rate: 100%
- Covered Methods: 7
- Missed Methods: 0
- Total Methods: 7

## **First implementation of new tests**

First i decdided to implement unit tests that check the fucntionality when player 1 wins and player 2 wins. These tests
are implemented in TennisGameTest.java file.

1. Test for Player 1 winning the game.

```java
@Test
	public void testTennisGame_Player1WinsGame() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		// Assert
		assertEquals("Player 1 win score incorrect", "player1 wins", game.getScore());
	}
```

2. Test for Player 2 winning the game.

```java
@Test
	public void testTennisGame_Player2WinsGame() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		// Asseert
		assertEquals("Player 2 in score incorrect", "player2 wins", game.getScore());
	}
```

### **Second round of testing**

After implementing the 2 new test to TennisGameTest.java class i ran JaCoCo ith Maven again and got some improvement 
with the code coverage. Coverage report image is linked below.

![Code Coverage Report](/images/CodeCoverageR2.png)

### **Coverage Rates**

### Coverage Rate by Lines

- Coverage Rate: 82%
- Covered Lines: 34
- Missed Lines: 6
- Total Lines: 40

### Coverage Rate by Branches

- Coverage Rate: 66%
- Covered Branches: 22
- Missed Branches: 11
- Total Branches: 33

### Coverage Rate of Methods

- Coverage Rate: 100%
- Covered Methods: 7
- Missed Methods: 0
- Total Methods: 7

### **Second implementation of new tests**

Next step was to implement tests to check the functionality when either player 1 or player 2 has advantage. These tests
are implemented in TennisGameTest.java file.

1. Test for Player 1 having advantage.

```java
@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException  {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		// Assert
		assertEquals("Advantage for Player1 score incorrect", "player1 has advantage", game.getScore());
	}
```

2. Test for Player 2 having advantage.

```java
@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		// Arrange
		TennisGame game = new TennisGame();
		// Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		// Assert
		assertEquals("Advantage for Player2 score incorrect", "player2 has advantage", game.getScore());
	}
```

First test passed successfully but the second test failed. After reading the error message it was clear that the
implementation of the game logic was incorrect. By checking the code in TennisGame.java file i found a bug in the
implementation getScore method for checking if player 2 has an advantage. 

Original implementation in TennisGame.java file at line 86:

```java
if (player2Points > 4 && player2Points - player1Points == 1)
    return "player2 has advantage";
```

Corrected implementation is:

```java
if (player2Points >= 4 && player2Points - player1Points == 1)
    return "player2 has advantage";
```

The condition should be player2Points >= 4 insted of player2Points > 4. This caused the test to fail because the condition
was never met. After fixing the bug the test passed successfully.

### **Third round of testing**

After fixing the bug in the implementation of the game logic, i ran JaCoCo with Maven again and got some improvement with
the code coverage, report image can be seen below.

![Code Coverage Report](/images/CodeCoverageR3.png)

### **Coverage Rates**

### Coverage Rate by Lines

- Coverage Rate: 94%
- Covered Lines: 37
- Missed Lines: 3
- Total Lines: 40

### Coverage Rate by Branches

- Coverage Rate: 84%
- Covered Branches: 28
- Missed Branches: 5
- Total Branches: 33

### Coverage Rate of Methods

- Coverage Rate: 100%
- Covered Methods: 7
- Missed Methods: 0
- Total Methods: 7

### **Third implementation of new tests**

After implementing all the recommended tests in course material and not achieving 100% coverage with those(As expected).
Third round of writing new tests and aiming to 100% code coverage,  I had to comb through the code coverage report 
bit more carefully. While going through the report i noticed that there were some parts of code that were not covered by
the tests. 

After adding new tests and trying to analyze missing coverage, I ended up to implement tests to check the game logic at
all possible game states. These tests are implemented in TennisGameTest.java file. While going trough the code coverage
reports after implementing test to cover all the different possible scores and game states, I noticed some problems with 
SUT code, and when I made tests to cover the situation when one player has an advantage, I missed detail in SUT code
that caused the test to fail. When checking getScore method in TennisGame.java file, I noticed that the logic in the
method was incorrect. There was also a bug at returning player scores in the method that i found after implementing 
tests to cover all possible game states. In the comments at the TennisGameTest class its mentioned that score should 
be presented in format "player1 - player2" but the original implementation was returning it in format "player2 - player1".

Original implementation:
```java
public String getScore() {
// Here is the format of the scores:
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"

    String player1Score = getScore(player1Points);
    String player2Score = getScore(player2Points);

    if (gameEnded) {
        if (player1Points > player2Points)
            return "player1 wins";
        else
            return "player2 wins";
    }

    if (player1Points >= 4 && player1Points == player2Points)
        return "deuce";

    if (player1Points >= 4 && player1Points - player2Points == 1)
        return "player1 has advantage";

    if (player2Points >= 4 && player2Points - player1Points == 1)
        return "player2 has advantage";

    return  player2Score + " - " + player1Score ;
}
```

Corrected implementation is:

```java
public String getScore() {

    String player1Score = getScore(player1Points);
    String player2Score = getScore(player2Points);

    if (gameEnded) {
        if (player1Points > player2Points) {
            return "player1 wins";
        }
        else {
            return "player2 wins";
        }
    }
    if (player1Points >= 3 && player2Points >= 3 && player1Points == player2Points) {
        return "deuce";
    }
    if (player1Points >= 3 && player1Points - player2Points == 1) {
        return "player1 has advantage";
    }
    if (player2Points >= 3 && player2Points - player1Points == 1) {
        return "player2 has advantage";
    }

    return  player1Score + " - " + player2Score ;
}
```

First of all for some clarity i decided to move the comments from the method to the class level. This makes the code
cleaner and easier to read. I also added some missing brackets to the if statements to make the code more readable and
less error-prone. I also changed the condition for checking if the game is in deuce state. The original implementation
was checking if the player points were equal to 4, but it should be checking if the player points are equal to 3 or greater
and both players have the same points. I also changed the condition for checking if a player has an advantage. The original
implementation was checking if the player points were equal or greater to 4 and the difference between the player points
was 1, but it should be checking if the player points are equal or greater to 3 and the difference between the player
points is 1. Lastly, I changed the return statement to return the player scores in the correct order.


### **Fourth round of testing**

I decided not to add all the tests i did to cover all possible game states to this README file, because it would make it
too long and bloated. I also decided to leave out the code coverage reports while figuring out the small percentage of
missing coverage in implementation of last tests. There was quite a lot of trial and error in last part and documenting
every step would be way too timid for this project. I did manage finally push the coverage percentage to 100% and it 
would not be possible without changing the SUT code, since it had some critical bugs when handling the scoring and game
states.

![Code Coverage Report](/images/CodeCoverageR3.png)

### **Coverage Rates**

### Coverage Rate by Lines

- Coverage Rate: 100%
- Covered Lines: 40
- Missed Lines: 0
- Total Lines: 40

### Coverage Rate by Branches

- Coverage Rate: 100%
- Covered Branches: 33
- Missed Branches: 0
- Total Branches: 33

### Coverage Rate of Methods

- Coverage Rate: 100%
- Covered Methods: 7
- Missed Methods: 0
- Total Methods: 7

