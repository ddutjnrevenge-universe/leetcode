class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        } 
        while (n!=1) {
            if (n%2!=0)
                return false;
                n=n/2;
        }
        return true;
        // return (int)(Math.ceil((Math.log(n)/Math.log(2))))
        // == (int)(Math.floor((Math.log(n)/Math.log(2))));
    }
}