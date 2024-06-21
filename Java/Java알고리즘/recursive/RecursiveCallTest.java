package Java.Java알고리즘.recursive;

public class RecursiveCallTest {
    public static void main(String[] args) {
        // m1();
        // m1_2(0);
        m2();
        m3();
        m4();
        m5(5);
    }
    
    static int m1_cnt = 0;
    static void m1() {
        // local 변수와 값은 항상 초기화된다.
        // int i = 0;
        // System.out.println("m1" + i);
        // m1();

        if(m1_cnt == 5) return;
        System.out.println("m1 " + m1_cnt++); // static 변수는 공유된다. 
        m1();
    }

    // 파라미터 공유
    static void m1_2(int i) {
        System.out.println("m1_2 " + i);
        i++;
        m1_2(i);
    }

    /**
     * stack overflow가 나지 않도록 해보자
     */
    static int m2_cnt = 5;
    static void m2() {
        System.out.println("앞 m2 cnt : " + m2_cnt);

        // m2_cnt가 0이 되면 m2() 호출 종료 
        if(m2_cnt > 0) {
            m2_cnt--;
            m2();
        }

        System.out.println("뒤 m2 cnt : " + m2_cnt);
    }

    // 뒤가 5번만 찍힌다  0일때 뒤가 안찍히기 때문에 (return)
    static int m3_cnt = 5;
    static void m3() {
        System.out.println("앞 m3 cnt : " + m3_cnt); // 기저조건 check 전에 항상 수행

        if(m3_cnt == 0) {
            return;
        }
        m3_cnt--;
        m3();

        System.out.println("뒤 m3 cnt : " + m3_cnt); // 기저조건 check 후에 있어서 기저조건에 의해 return 되면 수행 x
    }

    /*
    앞 m3 cnt : 5
    앞 m3 cnt : 4
    앞 m3 cnt : 3
    앞 m3 cnt : 2
    앞 m3 cnt : 1
    앞 m3 cnt : 0
    뒤 m3 cnt : 0
    뒤 m3 cnt : 0
    뒤 m3 cnt : 0
    뒤 m3 cnt : 0
    뒤 m3 cnt : 0
     */

    

    static int m4_cnt = 5;
    static void m4() {
        // 기저 조건: 더이상 진행하면 안되는 
        if(m4_cnt == 0) {
            return;
        }

        // 앞 뒤 출력을 쌍으로 맞추려면 기저 조건이 맨 위로 이동해야 한다. 
        System.out.println("앞 m4 cnt : " + m4_cnt);

        m4_cnt--;
        m4();
        m4_cnt++; // 재귀 호출 전후에 동일한 static 변수의 값을 가지려면 변화량에 반대로 처리를 해줘야한다. 
        System.out.println("뒤 m4 cnt : " + m4_cnt);
    }
    /*
    앞 m4 cnt : 5
    앞 m4 cnt : 4
    앞 m4 cnt : 3
    앞 m4 cnt : 2
    앞 m4 cnt : 1
    뒤 m4 cnt : 1
    뒤 m4 cnt : 2
    뒤 m4 cnt : 3
    뒤 m4 cnt : 4
    뒤 m4 cnt : 5
    */


    // static 대신 파라미터 공유 
    static void m5(int m5_cnt) {
        if(m5_cnt == 0) {
            return;
        }

        System.out.println("앞 m5 cnt : " + m5_cnt);

        // 1. 줄였다 원복.
        // m5_cnt--;
        // m5(m5_cnt);
        // m5_cnt++;
        
        // 2. 줄이지 않고 줄이는 연산을 통해서 전달 m5_cnt는 변하지 않는다 
        // m5(m5_cnt - 1);

        // 3. -- 연산자 뒤
        // stack overflos 발생!! 뒤에 --가 붙어서 m5_cnt가 재귀호출하는 순간 줄지 않는다. 꼐속 5가 전달됨!!
        // m5(m5_cnt--); 

        // 4. -- 연산자 앞
        // 안맞음
        m5(--m5_cnt);
        m5_cnt++; // 이거 해주면 된다.. 원복이 필요하다

        System.out.println("뒤 m5 cnt : " + m5_cnt);
    }

}
