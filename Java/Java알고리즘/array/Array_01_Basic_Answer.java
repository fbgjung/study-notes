package Java.Java알고리즘.array;

public class Array_01_Basic_Answer {
    public static void main(String[] args) {

        {
            int[] alphaCnt = new int[26];
            String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
            int strLen = str.length();
            for(int i = 0; i <strLen; i++) {
                alphaCnt[str.charAt(i) - 'a']++;
            }
    
            for (int i = 0; i < 26; i++) {
                System.out.println((char)(i + 'a') + " " + alphaCnt[i]);
            }
        }

        {
            int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
            int wrongCnt = 0;
            
            for (int i = 0; i <intArray.length - 2 ; i+=3) {
                // 1. i, i+1, i+2
                if(intArray[i] * intArray[i+1] != intArray[i+2]) {
                    wrongCnt++;
                }

            }
            System.out.println(wrongCnt);
            

        }
 
        {
            String str1 = "XYZEBFFGQOVVPWGFFCEAYX";  // 22개
            int wrongCnt = 0;
            char[] chArray = str1.toCharArray();
            
            int center = str1.length() / 2;
            
            for (int l = 0, r = chArray.length-1; l < center; l++, r--) {
                if (chArray[l] != chArray[r]) {
                    System.out.println(chArray[l] + " " + chArray[r]);
                    wrongCnt++;
                }
                
            }
            System.out.println(wrongCnt);

        }        

    }
}
