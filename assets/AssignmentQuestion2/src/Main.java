////Sort out formatting
////Create a function store it in a 2d array and then display the 2d array to get a matrix format
//public class Main{//b1
//    public static void main(String[] args){//b2
//        int count = 0;
//        int num = 51;
//        for(int i = 0; i < num; i++){//forloopb
//            int pentagonNum = (i*(3*i-1))/2;
//            System.out.printf("%5d",pentagonNum );
//            count++;
//
//            if(count % 10 == 0){//ifb
//                System.out.println();
//            }//endifb
//        }//endforloopb
//    }//endb2
//}//endb1

    //Took 2d array approach to display properly in the matrix format

public class Main {//main-class-start
    public static void main(String[] args) {//main-start
        // Number of pentagonal numbers to display
        int count = 50;
        // Number of columns in the display
        int cols = 10;

        // Calculate rows needed
        int rows = (count + cols - 1) / cols;

        // Create and fill the 2D array
        int[][] pentMatrix = new int[rows][cols];
        int num = 1;

        for (int i = 0; i < rows; i++) {//row-loop-start
            for (int j = 0; j < cols; j++) {//col-loop-start
                if (num <= count) {
                    // Calculate pentagonal number: P(n) = n(3n-1)/2
                    pentMatrix[i][j] = (num * (3 * num - 1)) / 2;
                    num++;
                }
            }//col-loop-end
        }//row-loop-end

        // Display the matrix
        for (int i = 0; i < rows; i++) {//display-row-start
            for (int j = 0; j < cols; j++) {//display-col-start
                if ((i * cols + j + 1) <= count) {
                    //This %7d is used for the spacing because some of the pentagonal values are large.
                    System.out.printf("%7d", pentMatrix[i][j]);
                }
            }//display-col-end
            System.out.println();
        }//display-row-end
    }//main-end
}//main-class-end