import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  char[][] maze;
  public Maze (File f) {
    try {
      Scanner inf = new Scanner (f);
      while (inf.hasNextLine()) {
        String line = inf.nextLine ();
        //go through each line
      }
    }catch (FileNotFoundException e) {
    }
  }
}
