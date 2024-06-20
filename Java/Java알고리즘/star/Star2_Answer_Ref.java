package Java.Java알고리즘.star;

public class Star2_Answer_Ref {
    public static void main(String[] args) {

        int turnCnt = 7/2; 
        int spaceCnt = 0; 

        boolean spaceIncrease = true; 

        for (int i = 0; i < 7; i++) {
            
            /**
             * 더 많은 수행 조건을 줄여가보자!!!!!
             */
            // 굳이 7까지 돌아야할까? 출력하지 않을 부분까지 따진다. 별로 ~ 
            // for (int j = 0; j < 7; j++) {
            //     // 공백 출력 
            //     if ( j < spaceCnt ) System.out.print(" ");
            //     else if (j < 7 - spaceCnt) System.out.print("*");
            // }

            /**
             * 2. 출력할 부분까지만 다진다 
             */
            for (int j = 0; j < 7-spaceCnt; j++) {
                // 공백 출력 
                if ( j < spaceCnt ) System.out.print(" ");
                else if (j < 7 - spaceCnt) System.out.print("*");
            }


            /**
             * 3. 앞 공백, 뒤 별 출력 순서가 명백하므로 for문을 분리한다. 
             * if else 를 사용하지 않아도 된다. 
             */
            for (int j = 0; j < spaceCnt; j++) {
                System.out.print(" ");
            }

            for (int j = spaceCnt; j < 7-spaceCnt; j++) {
                System.out.print("*");
            }

            System.out.println();

            // 행 별 출력이 완료 => 공백 증가 감소 판단
            if ( spaceIncrease ) {
                spaceCnt++;
            } else {
                spaceCnt--;
            }

            // 도달 했음 다음행부터 감소로 변경
            if( spaceCnt == turnCnt ) {
                spaceIncrease = false; 
            }
        }
    }
}


/**
 * 오른쪽은 공백이 아니라 아예 없으
   *******
    *****
     ***
      *
     ***
    *****
   *******
 */