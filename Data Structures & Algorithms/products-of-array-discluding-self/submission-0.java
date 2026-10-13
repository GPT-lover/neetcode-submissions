class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Left-to-Right Pass
        List<Integer> left = new ArrayList<>(); //[1, 1, 2, 8]

        int runningProduct = 1;

        for(int i = 0; i < nums.length; i++){
            left.add(runningProduct);
            runningProduct *= nums[i];
        }

        // Right-to-Left Pass 
        List<Integer> right = new ArrayList<>(); 
        
        int runningProd = 1;
        
        for(int i = nums.length-1; i >=0; i--){ //[1, 6, 24, 48]
            right.add(0, runningProd);
            runningProd *= nums[i];
        }

        // Final Output 
        int[] result = new int[nums.length];  
        for(int i =0; i < nums.length; i++){
            result[i] = left.get(i) * right.get(i); 
            
        }
        return result;
    }
}  



