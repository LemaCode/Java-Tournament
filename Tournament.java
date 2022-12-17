// Name: Manasse Bosango
// Date: 05/09/20222
// Classs: CS210
// Reason: Understand the importance and the use of while loop and do while loop and boolean type.

import java.util.Scanner;

public class Tournament {

   // 1
   /*
    * ) playGame method: that plays one full game of 7 points between two players.
    * This
    * method accepts a Scanner object and the names of the two players. It returns
    * the name of the
    * winner of this game. Specifically, this method repeatedly asks the user “who
    * the winner of the
    * next point is” until the game is over by following the rules mentioned above.
    * The user is
    * expected to enter the first letter of the player’s names, i.e. if player’s
    * name is Ashley, user is
    * expected to enter ‘A’ or ‘a’. Make the input case insensitive. Method should
    * detect an invalid
    * input and give feedback. See sample runs below
    */
   public static String playGame(Scanner console, String player1FormatedName, String player2FormatedName) {

      // Declaring the variables player1Points and player2Points and initializing them
      // to 0.
      int player1Points = 0;
      int player2Points = 0;

      // Taking the first letter of the player1FormatedName and converting it to
      // uppercase.
      String player1FormatedNameC = player1FormatedName.substring(0, 1).toUpperCase();
      String player2FormatedNameC = player2FormatedName.substring(0, 1).toUpperCase();

      // Printing the game scores.
      printGameScores(player1FormatedName, player2FormatedName, player1Points, player2Points);

      // A boolean variable that is used to check if the game is over or not.
      boolean winner = false;
      while (!winner) {

         // This is asking the user to enter the name of the player who won the point.
         System.out.print("Winner of the next point " + "(" + player1FormatedNameC + " for " + player1FormatedName
               + "/ " + player2FormatedNameC + " for " + player2FormatedName + "):");
         String playerFirstLetterNames = console.next().toUpperCase();

         // Checking if the playerFirstLetterNames is not equal to player1FormatedNameC
         // and
         // playerFirstLetterNames is not equal to player2FormatedNameC. If it is, it
         // prints "Invalid
         // input. Please enter again.".
         if (!playerFirstLetterNames.equals(player1FormatedNameC) && !playerFirstLetterNames
               .equals(player2FormatedNameC)) {
            System.out.println("Invalid input. Please enter again.");
         }

         // Checking if the playerFirstLetterNames is equal to player1FormatedNameC. If
         // it is, it adds
         // 1 to the player1Points.
         if (playerFirstLetterNames.equals(player1FormatedNameC)) {
            player1Points++;

            // Checking if the player1Points is equal to 3 and player2Points is equal to 0.
            // If it is, it
            // sets the winner to true. If it is not, it checks if the player1Points is
            // equal to 7. If
            // it is, it sets the winner to true.
            if (player1Points == 3 && player2Points == 0) {
               winner = true;
            } else if (player1Points == 7) {
               winner = true;
            }

         } else if (playerFirstLetterNames.equals(player2FormatedNameC)) {
            player2Points++;
            if (player2Points == 3 && player1Points == 0) {
               winner = true;
            } else if (player2Points == 7) {
               winner = true;
            }
         }

         // Printing the game scores.
         printGameScores(player1FormatedName, player2FormatedName, player1Points,
               player2Points);
      }

      // Checking if the player1Points is greater than player2Points. If it is, it
      // returns the
      // player1FormatedName. If it is not, it returns the player2FormatedName.
      if (player1Points > player2Points) {
         return player1FormatedName;

      } else {
         return player2FormatedName;
      }
   }

   // 2
   /*
    * printGameScores method: accepts names and points of the two players and
    * prints the
    * scores. See sample runs below.
    */
   public static void printGameScores(String player1, String player2, int player1Points, int player2Points) {
      System.out.println("Game Score  " + player1 + " " + player2);

      System.out.println(padString(Integer.toString(player1Points), 13)
            + padString(Integer.toString(player2Points), player1.length() + 1));
   }

   // 3
   /*
    * printTournamentScores method: accepts names and game counts of the two
    * players
    * and prints the scores. See sample runs below
    */
   public static void printTournamentScores(String player1, String player2, int player1TournamentScore,
         int player2TournamentScore) {
      System.out.println("Tournament score (# of games won): " + player1 + " " + player1TournamentScore + "," + " "
            + player2 + " " + player2TournamentScore);
   }

   // Helper methods
   public static String padString(String string, int length) {
      if (length == string.length()) {
         return string;
      } else {

         int l = (length - string.length());
         // String s = "";
         for (int i = 0; i < l; i++) {
            string = " " + string;
         }
         return string;
      }
   }

   public static void printStarts() {
      for (int i = 0; i <= 65; i++) {
         System.out.print("*");
      }
      System.out.println();
      // or simply: System.out.println("*".repeat(65));
   }

   public static void main(String[] args) {

      // separation bar "*"
      printStarts();
      System.out.println("Welcome to The All NorthWest Racquet Ball Tournament");

      // separation bar "*"
      printStarts();

      Scanner console = new Scanner(System.in);

      // Asking the user to enter the name of the first player.
      System.out.print("Enter the name of the first player: ");
      String player1 = console.next();

      // Asking the user to enter the name of the second player.
      System.out.print("Enter the name of the second player: ");
      String player2 = console.next();

      // Formatting the name of the player.
      String player1FormatedName = player1.substring(0, 1).toUpperCase() + player1.substring(1).toLowerCase();
      String player2FormatedName = player2.substring(0, 1).toUpperCase() + player2.substring(1).toLowerCase();

      // Printing the name of the players.
      System.out.println("Today's Players: " + player1FormatedName + " and " + player2FormatedName);

      // separation bar "*"
      printStarts();

      String saveWinner = "";
      int winTime1 = 0;
      int winTime2 = 0;
      int gameRounds = 1;

      // A boolean variable that is used to check if the tournament is over or not.
      boolean tournamentWinner = false;
      while (!tournamentWinner) {
         System.out.println("Playing game #" + gameRounds);
         saveWinner = playGame(console, player1FormatedName, player2FormatedName);

         // Checking if the saveWinner is equal to player1FormatedName. If it is, it adds
         // 1 to the
         // winTime1. It is also checking if the winTime1 is equal to 2 and winTime2 is
         // equal to 0 or
         // winTime1 is equal to 2. If it is, it sets the tournamentWinner to true.
         if (saveWinner.equals(player1FormatedName)) {
            winTime1++;
            if (winTime1 == 2 && winTime2 == 0 || winTime1 == 2) {
               tournamentWinner = true;
            }

         } else if (saveWinner.equals(player2FormatedName)) {
            winTime2++;
            if (winTime2 == 2 && winTime1 == 0 || winTime2 == 2) {
               tournamentWinner = true;
            }
         }

         System.out.println("Game #" + gameRounds + " over!");
         System.out.println(saveWinner + " Won game #" + gameRounds + ".");

         // Adding 1 to the gameRounds.
         gameRounds++;

         // Printing the separation bar "*"
         printStarts();
         printTournamentScores(player1FormatedName, player2FormatedName, winTime1,
               winTime2);
         // It prints the separation bar "*"
         printStarts();
      }

      System.out.println("Congratulations! " + saveWinner + " won the tournament!");
      printStarts();
   }
}
