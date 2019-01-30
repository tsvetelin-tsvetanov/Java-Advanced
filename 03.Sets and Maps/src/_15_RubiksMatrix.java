import java.util.Arrays;
import java.util.Scanner;

public class _15_RubiksMatrix {
    //Rubik’s cube – everyone’s favorite head-scratcher. Writing a program to solve it will be quite
    // a difficult task for an exam, though. Instead, we have a Rubik’s matrix prepared for you.
    // You will be given a pair of dimensions: R and C. To prepare the matrix, fill each row with
    // increasing integers, starting from one. For example, 2 x 4 matrix must look like this:
    //1 2 3 4
    //5 6 7 8
    //Next, you will receive series of commands, indicating which row or column you must move, in
    // which direction, and how many times. For example, 1 up 1 means: column 1, direction: up,
    // 1 move. After executing it, the matrix should look like:
    //1 6 3 4
    //5 2 7 8
    //Directions left and right mean you must move the corresponding row, while up and down and
    // related to the columns. After shuffling the Rubik’s matrix, you have to rearrange it
    // (meaning that the values in each cell should be in increasing order, such as the ones in
    // the original matrix). The rearranging process should start at top-left and end at bottom-right.
    // Find the position of the value you need, and print the swap command on the console, in the
    // format described below.
    //Input
    //    • On the first line, you are given the integers R and C, separated by a space.
    //    • On the second line, you are given an integer N, indicating the number of commands to
    //    follow
    //    • On the next N lines, you are given commands in format {row/col} {direction} {moves}
    //Output
    //    • On R * C number of lines, print the swap commands needed to rearrange the matrix, either:
    //        ◦ Swap ({row}, {col}) with ({row}, {col})   or
    //        ◦ No swap required
    //Constraints
    //    • R, C, N are integers in range [1 … 100]
    //    • {row} and {col} will always be inside the matrix
    //    • {moves} is in range [0 … 231-1]

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.next());
        int cols = Integer.parseInt(scan.next());
        int moves = Integer.parseInt(scan.next());
        int[][] matrix = new int[rows][cols];
        int index = 1;
        scan.nextLine();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = index;
                index ++;
            }
        }

        for(int i = 0; i < moves; i++){
            String[] command = scan.nextLine().split("\\s+");
            int position = Integer.parseInt(command[0]);
            int turns = Integer.parseInt(command[2]);
            switch (command[1]){
                case "up":
                    moveUp(matrix, position, turns);
                    break;
                case "down":
                    moveDown(matrix, position, turns);
                    break;
                case "left":
                    moveLeft(matrix, position, turns);
                    break;
                case "right":
                    moveRight(matrix, position, turns);
                    break;
                    default: break;
            }
        }

        index = 1;
        for(int row = 0, col = 0; col < matrix.length; col++){
            if(!(matrix[row][col] == index)){
                int current = matrix[row][col];
                for(int cRow = 0, cCol = 0; cCol < matrix.length; cCol++){
                    if(matrix[cRow][cCol] == index){
                        System.out.printf("Swap (%d, %d) with (%d, %d)\n",
                                row, col, cRow, cCol);
                        swap(matrix, row, col, cRow, cCol);
                        break;
                    }
                    if(cCol == matrix.length - 1){
                        cCol = -1;
                        cRow++;
                    }
                }
            } else {
                System.out.println("No swap required");
            }

            index++;
            if(col == matrix.length - 1){
                col = -1;
                row++;
            }
            if(row >= matrix.length){
                break;
            }
        }
    }

    private static void swap(int[][] matrix, int rowA, int colA, int rowB, int colB){
        int temp = matrix[rowA][colA];
        matrix[rowA][colA] = matrix[rowB][colB];
        matrix[rowB][colB] = temp;
    }

    private static void moveUp(int[][] matrix, int col, int rotations){
        for(int r = 0; r < rotations; r++) {
            for (int i = 0; i < matrix.length - 2; i++) {
                swap(matrix, i, col, i + 1, col);
            }
            swap(matrix, matrix.length - 1, col, matrix.length - 2, col);
        }
    }

    private static void moveDown(int[][] matrix, int col, int rotations) {
        for(int r = 0; r < rotations; r++) {
        swap(matrix, 0, col, matrix.length - 1, col);
            for (int i = 1; i < matrix.length - 1; i++) {
                swap(matrix, i, col, i + 1, col);
            }
        }
    }

    private static void moveLeft(int[][] matrix, int row, int rotations){
        for(int r = 0; r < rotations; r++) {
            swap(matrix, row, 0, row, matrix.length - 1);
            for(int i = 1; i < matrix.length - 1; i++ ) {
                swap(matrix, row, i, row, i - 1);
            }
        }
    }

    private static void moveRight(int[][] matrix, int row, int rotations){
        for(int r = 0; r < rotations; r++) {
            for (int i = 0; i < matrix.length - 2; i++) {
                swap(matrix, row, i, row, i + 1);
            }
            swap(matrix, row, matrix.length - 1, row, 0);
        }
    }
}
