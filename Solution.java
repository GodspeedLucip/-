package 力扣.LY_01_数组.二分法;

public class Solution {
    public static void main(String[] args) {
//        String []ops = new String[]{"5","2","C","D","+"};
//        System.out.println(calPoints(ops));
//        int []a = new int[]{1,3};
//        System.out.println(searchInsert(a,2));
//        int []a = new int[]{1,3,5,6,6,7,10};
//        searchRange(a,6);
//        System.out.println(mySqrt(2147395599));
        System.out.println(isPerfectSquare(37));
    }
    public static int calPoints(String[] ops) {
        int sum = 0;
        int i = 0;
        int length = 0;
        for (int j = 0; j < ops.length; j++) {
            if(ops[i]!=""){
                length++;
            }
        }
        while(i<length){
            String index = ops[i];
            switch (index){
                case"D":{
                    ops[i] = (Integer.parseInt(ops[i-1]))*2+"";
                    break;
                }
                case "C":{
                    //然后把i到length的数据移动到i-1到length-1去
                    for(int j=i;j<ops.length-1;j++){
                        ops[j-1] = ops[j+1];
                    }
                    i-=2;
                    length-=2;
                    break;
                }
                case"+":{
                    int result = Integer.parseInt(ops[i-1])+Integer.parseInt(ops[i-2]);
                    ops[i] = result+"";
                    break;
                }
                default:{
                    break;
                }
            }
            i++;
        }
        for (int j = 0; j < length; j++) {
            int result =Integer.parseInt(ops[j]);
            sum+=result;
        }
        return sum;
    }
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else {
                return mid;
            }
        }
        System.out.println(mid);
//        if(target<nums[0]){
//            System.out.println("11");
//            return 0;
//        }
//        else if(nums[mid]>target){
//            System.out.println("22");
//            return mid-1;
//        }
//        else{
//            System.out.println("33");
//            return mid+1;
//        }
        return high+1;
        //判定条件是high<low时就退出。
    }
    public static int[] searchRange(int[]nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        int left = -2;
        int right = -2;
        int[] posi = new int[2];
        if(nums.length==0){
            posi[0]=-1;
            posi[1]=-1;
            return posi;
        }
        while(low<=high){
            mid = low+(high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            else{
                break;
            }
        }
        if(nums[mid]!=target){
            posi[0]=posi[1]=-1;
            return posi;
        }
        left = mid;
        while(left>=0&&nums[left]==target){
            left--;
        }
        right = mid;
        while(right<nums.length&&nums[right]==target){
            right++;
        }
        posi[0] = left+1;
        posi[1] = right-1;
        return posi;
    }
    public static int mySqrt(int x) {
        //本质上，是在1-x中按顺序找到一个数，其平方等于x。
        if(x==0||x==1){
            return x;
        }
        long low = 0;
        long high = x;
        long mid=0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(mid*mid>x){
                high = mid-1;
            }
            else if(mid*mid<x){
                low = mid+1;
            }
            else{
                return (int) mid;
            }
        }
        return (int) high;
    }
    public static boolean isPerfectSquare(int num) {
        if(num==0||num==1){
            return true;
        }
        long low = 0;
        long high = num;
        long mid=0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(mid*mid>num){
                high = mid-1;
            }
            else if(mid*mid<num){
                low = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
