class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Right-to-Left Pass 
        List<Integer> right = new ArrayList<>(); 
        
        int runningProd = 1;
        
        for(int i = nums.length-1; i >=0; i--){ //[1, 6, 24, 48]
            right.add(0, runningProd);
            runningProd *= nums[i];
        }

        // Final Output 
        int left = 1;
        int[] result = new int[nums.length];  
        for(int i =0; i < nums.length; i++){
            result[i] = left * right.get(i); 
            left *= nums[i];
        }
        return result;
    }
}  



