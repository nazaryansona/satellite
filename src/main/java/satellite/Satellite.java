package satellite;
import java.io.*;

public class Satellite {

    static int[][] oldImage, newImage; static int R, C;
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        String[] first = r.readLine().trim().split("\\s+"); R = Integer.parseInt(first[0]); C = Integer.parseInt(first[1]);
        oldImage = readImage(r); newImage = readImage(r); r.close();
        int[] corners = findCorners(); printResult(corners);
    }

    static int[][] readImage(BufferedReader r) throws Exception {
        int[][] img = new int[R][C];
        for (int i = 0; i < R; i++) { String[] p = r.readLine().trim().split("\\s+"); for (int j = 0; j < C; j++) img[i][j] = Integer.parseInt(p[j]); }
        return img;
    }

    static int[] findCorners() {
        int minR = R, minC = C, maxR = -1, maxC = -1;
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (oldImage[i][j] != newImage[i][j]) {
            minR = Math.min(minR, i); maxR = Math.max(maxR, i); minC = Math.min(minC, j); maxC = Math.max(maxC, j);
        }
        return new int[]{minR, minC, maxR, maxC};
    }

    static void printResult(int[] c) {
        if (c[2] == -1) System.out.println("0 0 0 0");
        else System.out.printf("%d %d %d %d%n", c[0]+1, c[1]+1, c[2]+1, c[3]+1);
    }
}