
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Test1 {
    @Test
    public void test0(){


//        int[][] a = {
//                {1, 2, 3}, {1, 2, 3}
//        };
//
//        System.out.println(a.length);
//        System.out.println(a[0].length);
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//
//        q.offer(1);
//        q.offer(2);

//        System.out.println(q.pollLast());
//        int[] ints = new int[3];
//        System.out.println(ints[1]);
//        String[] strings = new String[2];
//        strings[0]="12334";
//



//        char[] a = {'1','2'};
//        System.out.println(a.toString());
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        HashSet<Integer> list = new HashSet<>();
//        list.add(1);
//        list.add(2);
//
//        res.add(new ArrayList<>(list));
//
//        list.remove(1);
//        list.remove(0);
//
//        list.add(2);
//        list.add(1);
//
//
//
//        System.out.println(res.contains(list));


//        ArrayDeque<Integer> integers = new ArrayDeque<>();
//        integers.offer(null);

//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(2,"s");
//        map.put(2,"a");
//        System.out.println(map);
//        int[][] a = new int[2][3];
//        System.out.println(a.length);
//        System.out.println(a[1].length);


//        List<List<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        res.add(list);
//        ArrayList<Object> list1 = new ArrayList<>();
//        list.add(2);
//        list1.add(1);
//        System.out.println(res.contains(list1));
//        HashMap<Integer, Integer> ma = new HashMap<>();

//
//        list.add(1);
//        list.add(1);
//
//        res.add(list);
////        System.out.println(res);
//        list.clear();
//        list.add(2);
//        list.add(2);
//        System.out.println(res);
//        list.add(0,1);
//        list.add(0,2);
//        System.out.println(list);


//        System.out.println(Integer.parseInt("5e2"));
//        System.out.println(new StringBuilder("abcde").delete(3,7));
//        System.out.println("-12".length());
//        int[][] a = new int[][]{{1,2,3},{2,3,4}};
//        System.out.println(a.length);
//        char a='a';
//        char b='b';
//        System.out.println(a^=b);
////        System.out.println(b^=a);
//        System.out.println(a^=b);
//        System.out.println(0^1);

//        System.out.println(5^2);

//
//        System.out.printf("2");
//        System.out.printf("2+ \n");
//        System.out.printf("2");
//        System.out.println(removeDuplicates(new int[]{1, 1,1,2,2}));

    }
        public int removeDuplicates(int[] nums) {
            int a=0,b=1;
            int len = nums.length;
            while (b<len){
                if (nums[a]!=nums[b] && b-a>1){
                    nums[++a] = nums[b];
                }
                b++;
            }
            return a+1;
        }

        public int removeDuplicates1(int[] nums) {
            if(nums.length <2) return nums.length;
            int l = nums.length;
            for (int i = 0; i <l-1 ;) {
                if (nums[i]==nums[i+1]){
                    for (int j = i; j <l-1 ; j++) {
                        nums[j] = nums[j+1];
                    }
                    l--;

                }
                if(nums[i]!=nums[i+1]) i++;
            }
            return l;
        }


    @Test
    public void test5(){
        int a=0b001111;
        System.out.println(Integer.bitCount(a));
        System.out.println(a);
    }





//    @Test
//    public void test1(){
//
//        int[] n = {1, 2, 3, 2, 1,2};
//        int l=0,r=n.length-1;
//        while (r>l){
//            if (n[l]!=n[r]){
//                System.out.println("false");
//            }
//            r--;l++;
//        }
//        System.out.println("right");
//
//
//    }
    @Test
        public  void test3isPalindrome() {
            ArrayList<Integer> list = new ArrayList<>();
           list.add(-129);
           list.add(-129);

            int l=0,r=list.size()-1;
            while (r>l){
                if (list.get(l)!=list.get(r)){
                    System.out.println(list.get(l)+"x"+list.get(r));
                    System.out.println( false);
                }
                r--;l++;
            }
        System.out.println( true);
        }




    @Test
    public void test(){
        int[] nums = {2,1};
        System.out.println(findUnsortedSubarray(nums));
    }


    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int r = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    l = Math.min(l, i);
                    r = Math.max(j, r);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
