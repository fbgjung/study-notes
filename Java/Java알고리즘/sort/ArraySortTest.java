package Java.Java알고리즘.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 자바는 정렬 API를 제공
 * 문제에서 정렬이 필요한 경우, 적절하게 대응
 */
public class ArraySortTest {
    public static void main(String[] args) {
        // 정수 정렬
        int[] intArray = {3, 5, 2, 7, 9, 4};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // 문자열 정렬
        String[] strArray = {"Hello", "ABC", "wordl", "UPLUS"};
        Arrays.sort(strArray, Collections.reverseOrder()); // 내림차순 정렬
        Arrays.sort(strArray); 
        System.out.println(Arrays.toString(strArray));


        Item[] itemArray = {
            new Item(3,"666"), new Item(5,"333"), new Item(3,"111")
        };
        
        /**
         * 1. implements Comparable
         */
        Arrays.sort(itemArray); // 객체 3개를 어떤 기준으로 정렬할지 모르겠다는 에러 발생  CompareTo 재정의하자~
        

        /**
         * 정렬 하기 위한 방법 2: Comparator interface 객체 전달(익명)
         * Arrays.sort(itemArray, [정렬조건]); 
         * 대상 객체에 Comparable 구현 없어도 된다. 
         */
        Arrays.sort(itemArray, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                // return o1.itemId - o2.itemId; // [3  666, 3  111, 5  333]
                return o1.itemNm .compareTo(o2.itemNm); // [3  111, 5  333, 3  666]
            }
        });


        /**
         * 정렬 하기 위한 방법 3: Comparator 객체 전달(Lambda)
         * functional Interface 라 ..... 메소드가 하나밖에없다?
         */
        Arrays.sort(itemArray, (o1, o2) -> o1.itemId - o2.itemId); // [3  666, 3  111, 5  333]
        Arrays.sort(itemArray, (o1, o2) -> o2.itemId - o1.itemId); // [5  333, 3  666, 3  111]
        

        System.out.println(Arrays.toString(itemArray));
    }

    /**
     * 정렬이 되기 위한 방법 1. Comparable interface를 구현
     */
    static class Item implements Comparable<Item>{
        int itemId;;
        String itemNm;

        Item(int itemId, String itemNm) {
            this.itemId = itemId;
            this.itemNm = itemNm;
        }

        @Override
        public String toString() {
            return itemId + "  " + itemNm;
        }

        @Override
        public int compareTo(Item item) {
            /**
             * ItemId asc 정렬 오름차순 앞-뒤
             */

            // return this.itemId - item.itemId; // 음수: this가 앞 [2  666, 3  111, 5  333]
            // return -(this.itemId - item.itemId); // [5  333, 3  555, 2  111]
            
            /**
             * ItemNm 정렬
             */
            // return this.itemNm.compareTo(item.itemNm); // [3  111, 5  333, 2  666]

            /**
             * ItemId가 같다면, ItemNm으로 정렬하고 싶다.
             */
            return this.itemId == item.itemId ? this.itemNm.compareTo(item.itemNm) : this.itemId - item.itemId; // [3  111, 3  666, 5  333]
        }
    }
    
}
