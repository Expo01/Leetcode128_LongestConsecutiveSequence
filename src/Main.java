import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// mine but better
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {return 0;}
        int curLong = 1;
        int longestSeq = 1;
        Arrays.sort(nums);
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                continue;
            } else if (m.containsKey(nums[i] - 1)) {
                m.put(nums[i], 1);
                curLong++;
                if (curLong > longestSeq) {
                    longestSeq = curLong;
                }
            } else {
                curLong = 1;
                m.put(nums[i],1);
            }
        }
        return longestSeq;
    }
}
//[0,1,1,2,5,6]
//class Solution {
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) {return 0;}
//        int curLong = 1;
//        int longestSeq = 1;
//        Arrays.sort(nums);
//        HashMap<Integer, Integer> m = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                m.put(nums[i], 1);
//            } else if (m.containsKey(nums[i])) {
//                continue;
//            } else if (m.containsKey(nums[i] - 1)) {
//                m.put(nums[i], 1);
//                curLong++;
//                if (curLong > longestSeq) {
//                    longestSeq = curLong;
//                }
//            } else {
//                curLong = 1;
//                m.put(nums[i],1);
//            }
//        }
//        return longestSeq;
//    }
//}

// fails with [1,2,1,0]. says longest sequence of 3. when ordered it if no redundant characters
// it would appear to be max of 2. but i think the array can be ordered howevere necessary such
// as [0,1,2,1] would = 3 sequential and just tack the other on the end. So really need a storage
// mechanism. array would work but suppose values of [1,2,3,999]. we would then have 995 empty spaces
// best to use Map.
//class Solution {
//    public int longestConsecutive(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//
//        Arrays.sort(nums);
//
//        int curLong = 1;
//        int longestSeq = 1;
//
//        for(int i = 0; i<nums.length-1; i++){
//            if(nums[i] == nums[i+1]-1){
//                curLong++;
//                if(curLong > longestSeq){
//                    longestSeq = curLong;
//                }
//            } else{
//                curLong = 1;
//            }
//        }
//        return longestSeq;
//    }
//}

