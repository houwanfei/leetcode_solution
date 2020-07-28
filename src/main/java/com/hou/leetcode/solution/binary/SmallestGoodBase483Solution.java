package com.hou.leetcode.solution.binary;

public class SmallestGoodBase483Solution {
    public String smallestGoodBase(String n) {
        long nNUm = Long.valueOf(n);
        int maxBit = (int) (Math.log(nNUm)/Math.log(2))+1;
        for (int i=maxBit; i>=2; i--) {
            long left = 2,right= (long) Math.pow(nNUm, 1.0/(i-1))+1;
            while (left <= right) {
                long mid = left + (right-left)/2;
                long sum = 0;
                int j=0;
                while (j < i) {
                    sum = sum*mid + 1;
                    j++;
                }
                if (sum == nNUm) {
                    return String.valueOf(mid);
                } else if (sum > nNUm){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return String.valueOf(nNUm-1);
    }
    private static void count(long num, int n) {
        StringBuilder sb = new StringBuilder();
        while (num >= n) {
            long m = num%n;
            num /= n;
            sb.insert(0, ","+m);
        }
        if (num > 0) {
            sb.insert(0,num);
        }
        System.out.println("n:" + n+ " " + sb.toString());
    }

    public static void main(String[] args) {
        SmallestGoodBase483Solution solution = new SmallestGoodBase483Solution();
        System.out.println(solution.smallestGoodBase("1000000000000000000"));
//        System.out.println(solution.checkValid(2, 999999999999999999L, 1000000000000000000L));
//        count(919818571896748567L, 986);
//        checkValid(7, 986, 919818571896748567L);
    }
}
