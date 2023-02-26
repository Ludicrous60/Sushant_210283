class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res=new ArrayList<>();
        
        List<int[]> heights=new ArrayList<>();
        
        transformBuilding(buildings,heights);
        
        //if heights of 2 points are same then place the point with smaller height first else place point with smaller starting point
        
        Collections.sort(heights,(a,b)->(a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);// TC->O(nlog n)
        
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->(b-a));
        
        //seeding the Priority Queue
        pq.add(0);
        int prevMax=0;
        
        for(int[] height:heights){ //O(n)
            
            if(height[1]<0){
                pq.add(-height[1]);
            }
            else{
                pq.remove(height[1]); //O(log n)
            }
            
            int CurrentMax=pq.peek();
            if(CurrentMax!=prevMax)
            {