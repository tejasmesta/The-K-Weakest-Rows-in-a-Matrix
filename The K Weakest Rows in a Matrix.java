class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int added  = 0;
        
        int kk = 0;
        
        for(int m[]:mat)
        {
            int sum = 0;
            for(int i:m)
            {
                sum+=i;
            }
            
            Pair p = new Pair(sum,kk);
            
            if(added++<k)
            {
                pq.add(p);
            }
            else{
                Pair pp = pq.peek();
                if(pp.compareTo(p)<0)
                {
                    pq.remove();
                    pq.add(p);
                }
            }
            
            kk++;
        }
        
        int[] result = new int[k];
        
        for(int i=0; i<k; i++)
        {
            result[k-i-1] = pq.poll().i;
        }
        
        return result;
    }
    
    class Pair implements Comparable{
        int s;
        int i;
        
        Pair(int s,int i)
        {
            this.s = s;
            this.i = i;
        }
        
        @Override
        public int compareTo(Object o)
        {
            Pair v2 = (Pair) o;
            if(s<v2.s)
            {
                return 1;
            }
            if(s>v2.s)
            {
                return -1;
            }
            if(i<v2.i)
            {
                return 1;
            }
            if(i>v2.i)
            {
                return -1;
            }
            return 0;
        }
    }
}
