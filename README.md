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

### Coverage Rates

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
with the code coverage, it jumped form original total of 74% to 82%. Coverage report image is linked below.

![Code Coverage Report](/images/CodeCoverageR2.png)

### Coverage Rates

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

