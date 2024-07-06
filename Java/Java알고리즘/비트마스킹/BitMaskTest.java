package Java.Java알고리즘.비트마스킹;

public class BitMaskTest {
    public static void main(String[] args) {
        // <<
        // System.out.println(1 << 1); // 0001 -> 0010
        // System.out.println(2 << 3); // 0010 -> 0001 0000 (16)
        // System.out.println(3 << 2); // 0011 -> 1100
        
        // & |
        System.out.println(3 & 1); // 0011 & 0001 -> 0001(1)

        // & <<
        // a & 1 << b : a를 bit로 표현하면 a의 b 자리가 1인지 0인지 알 수 있다.
        // 결과가 0이 아니면 a의 b번째 비트는 0이 아니다.
        System.out.println(3 & 1 << 2); // 0011 & 0100 -> 0000(0)
        System.out.println(7 & 1 << 1); // 0111 & 0010 -> 0010(2)
        System.out.println(2 & 1 << 1); // 0010 & 0010 -> 0010(2)

        // a | 1 << b : a를 bit로 표현하면 a의 b 자리를 1로 변경함을 알 수 있다.
        System.out.println(7 | 1 << 3); // 0111 | 1000 -> 1111(15)
    }
    
    
}
