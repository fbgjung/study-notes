package Java.Java알고리즘.star;

public class Star1_Answer {
    public static void main(String[] args) {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
}

/**
   *****
    ****
     ***
      **
       *
 */