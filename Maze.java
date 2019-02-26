import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  char[][] maze;
  public Maze (File f) {
    try {
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
    }catch (FileNotFoundException e) {
      System.out.println ("File not Found");
    }
  }
}
