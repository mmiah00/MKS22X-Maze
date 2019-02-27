import java.util.*;
import java.io.*;

public class Maze {
  private char[][]maze;
  private boolean animate;//false by default

  public Maze (File f) throws FileNotFoundException {
    animate = false;
    Scanner inf = new Scanner (f);
    int numLines = 0;
    int charsPerLine = 0;
    while (inf.hasNextLine()) {
      numLines ++;
      String line = inf.nextLine();
      charsPerLine = line.length ();
    }
    maze = new char[numLines][charsPerLine];
    for (int x = 0; x < maze.length && inf.hasNextLine (); x ++) {
      String line = inf.nextLine ();
      for (int y = 0; y < maze.length; y ++) {
        maze[x][y] = line.charAt (y);
      }
    }
  }

  private void wait(int millis){
       try {
           Thread.sleep(millis);
       }
       catch (InterruptedException e) {
       }
   }


  public void setAnimate(boolean b){
      animate = b;
  }


  public void clearTerminal(){
      //erase terminal, go to top left of screen.
      System.out.println("\033[2J\033[1;1H");
  }

 /*Return the string that represents the maze.

   It should look like the text file with some characters replaced.

  */
  public String toString(){
    String ans = "";
    for (int x = 0; x < maze.length; x ++) {
      for (int y = 0; y < maze[x].length; y ++) {
        ans += maze[x][y];
        if (y == maze[x].length - 1) {
          ans += "\n";
        }
      }
    }
    return ans;
  }



  /*Wrapper Solve Function returns the helper function

    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

  */
  public int solve(){

          //find the location of the S.


          //erase the S


          //and start solving at the location of the s.

          //return solve(???,???);
          return 1;
  }

  /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.


    Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'

      All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private


      //automatic animation! You are welcome.
      if(animate){

          clearTerminal();
          System.out.println(this);

          wait(20);
      }

      //COMPLETE SOLVE

      return -1; //so it compiles
  }


}
