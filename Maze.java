import java.util.*;
import java.io.*;

public class Maze {
  private char[][]maze;
  private boolean animate;//false by default

  public Maze (String f) throws FileNotFoundException {
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

  private int[] findS () { //loops through the maze to find S
    int[] coordinates = new int[2];
    for (int y = 0; y < maze.length; y ++) {
      for (int x = 0; x < maze[y].length; x ++) {
        if (maze[y][x] == 'S') {
          coordinates [0] = y;
          coordinates [1] = x;
        }
      }
    }
    return coordinates;
  }

  public int solve(){
    int[] xy = findS (); //find the location of the S.
    maze[xy[0]][xy[1]] = ' '; //erase the S
    return solve (xy[0], xy[1], 0); //start solving at the location of the s.
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

  private int solve(int row, int col, int steps){ //you can add more parameters since this is private
      if(animate){
          clearTerminal();
          System.out.println(this);

          wait(20);
      }

      if (maze[row][col] == 'E') {
        return steps;
      }
      else {
        if (maze[row-1][col] == ' ') { //one up
          maze[row - 1][col] = '@';
          return solve (row - 1, col, steps + 1);
        }
        if (maze[row + 1][col] == ' ') { //one down
          maze[row + 1][col] = '@';
          return solve (row + 1, col, steps + 1);
        }
        if (maze[row][col + 1] == ' ') { //one right
          maze[row][col + 1] = '@';
          return solve (row, col + 1, steps + 1);
        }
        if (maze[row][col -1] == ' ') { //one left
          maze[row][col - 1] = '@';
          return solve (row, col - 1, steps + 1);
        }
        else {
          if (maze[row][col] != '#') {
            maze[row][col] = '.';
          }
        }
        return 0;
      }
  }


}
