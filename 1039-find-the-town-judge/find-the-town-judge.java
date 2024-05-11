class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n+1];
        for (int[] relation:trust){
            trustCounts[relation[0]]--;
            trustCounts[relation[1]]++;
        }
        for (int i=1; i<=n;i++){
            if(trustCounts[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}