package Java.Java알고리즘.sort;

import java.util.*;

public class CollectionSortTest {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        //new Item(3,"666"), new Item(5,"333"), new Item(3,"111"
        list.add(new Item(3,"666"));
        list.add(new Item(5,"333"));
        list.add(new Item(3,"111"));
        System.out.println(list);

        /**
         * 1. 
         */
        Collections.sort(list);
        System.out.println(list); // [3  111, 3  666, 5  333]

        /**
         * 2. lambda
         */
        Collections.sort(list, (o1, o2) -> o1.itemId - o2.itemId);
        System.out.println(list); // [3  111, 3  666, 5  333]

        Collections.sort(list, (o1, o2) -> o1.itemNm.compareTo(o2.itemNm));
        System.out.println(list); // [3  111, 5  333, 3  666]

        Collections.sort(list, (o1, o2) -> o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);
        System.out.println(list); // [3  111, 3  666, 5  333]

    }

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
            return this.itemId == item.itemId ? this.itemNm.compareTo(item.itemNm) : this.itemId - item.itemId; // [3  111, 3  666, 5  333]
        }
    }
}
