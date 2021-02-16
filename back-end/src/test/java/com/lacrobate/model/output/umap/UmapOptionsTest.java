import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        int xMax = W;
        int yMax = H;

        int xMin = 0;
        int yMin = 0;

        System.err.println("W, H: " + W + ", " + H);

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println(("[before] (X0, Y0) : (" + X0 + ", " + Y0 + ")"));
            System.err.println("bombDir: " + bombDir);

            if (bombDir.contains("U")) {
                System.err.println("contains 'U'...");
                yMax = Y0;
                Y0 = (Y0 + yMin) / 2;
            } else if (bombDir.contains("D")) {
                System.err.println("contains 'D'...");
                yMin = Y0;
                Y0 = (Y0 + yMax) / 2;
            }

            if (bombDir.contains("R")) {
                System.err.println("contains 'R'...");
                xMin = X0;
                X0 = (X0 + xMax) / 2;
            } else if (bombDir.contains("L")) {
                System.err.println("contains 'L'...");
                xMax = X0;
                X0 = (X0 + xMin) / 2;
            }

            System.err.println(("[after] (X0, Y0) : (" + X0 + ", " + Y0 + ")"));

            // the location of the next window Batman should jump to.
            System.out.println(X0 + " " + Y0);
        }
    }
}