package Java.Java알고리즘.star;

public class Star2_Answer {
    public static void main(String[] args) {
        // 반복문 + 출력 = 반전 시점
        // 반전 : 정확히 반인 곳에서 공백 기준으로 점점 증가 점점 감소 판단 => 밑으로 가면서
        // 옆으로 가면서 공백 개수 출력  나머지 조건 (전체 7중 공백 뺀 만큼)에 별 출력
        int turnCnt = 7/2; // 반 언제 나눠 3
        int spaceCnt = 0; // 공백 

        boolean spaceIncrease = true; // 공백문자 수 증가? 감소?

        for (int i = 0; i < 7; i++) {
            
            for (int j = 0; j < 7; j++) {
                // 공백 출력 
                if ( j < spaceCnt ) System.out.print(" ");
                else if (j < 7 - spaceCnt) System.out.print("*");
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