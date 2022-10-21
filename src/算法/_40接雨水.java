package 算法;

public class _40接雨水 {
	public static void main(String[] args) {
		int[] height = {0,1,4,2,8,3,2,5,7};
		System.out.println(trap(height));
	}
    public static int trap(int[] height) {
    	if (height.length <=1) return 0;
    	int left = 0;
    	int right = height.length-1;
    	int lMax = height[left];
    	int rMax = height[right];
    	int water = 0;
    	while (left <= right) {
    		if (height[left] < height[right]) {
    			if (height[left] < lMax) {
    				water =+ lMax - height[left];
    			} else {
    				lMax = height[left];
    			}
    			left++;
			} else {
				 if (height[right] < rMax) {
					water += rMax - height[right];
				} else {
					rMax = height[right];
				}
				right--;
			}
		}
    	return water;
    }
    
}
