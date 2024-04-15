class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        
        return hours <= h;
    }
    
    private int getMax(int[] piles) {
        int max = 0;
        
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        
        return max;
    }
}