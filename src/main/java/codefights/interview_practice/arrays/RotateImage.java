package codefights.interview_practice.arrays;

public class RotateImage {

    public static void main(String args[]) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = rotateImage(a);
    }

    static int[][] rotateImage(int[][] a) {
        int[][] res = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                res[j][a[i].length-1-i] = a[i][j];
            }
        }
        return res;
    }
}
