class MinJumps
{

    /**dp solution which takes n*n+1 /2 time 
     * first initialize jumps and then optimize to get minim jumps
     * but gives TLE(Greedy approach preferred)
     * T=n2
     * space=n
     */
    static void solveDP(int arr[], int n)
    {
        int jumps[]=new int[n];
        jumps[n-1]=0;
        int min=Integer.MAX_VALUE;
        for(int i=n-2;i>=0;i--)
        {
            
            if(arr[i]==0)   // no more jumps
            jumps[i]=Integer.MAX_VALUE;
            else if(arr[i] >n-i-1) //curr ele greater than remaining number of ele
            jumps[i]=1;
            else{
                //finding min number of jumps needed from curr pos= i to reach arr[n-1]

                min=Integer.MAX_VALUE;
                for(int j=i+1; j<n && j<=arr[i]+i ;j++)//j<=arr[i]+i to check till reachable nodes
                {
                    if(min> jumps[j])
                    min=jumps[j];
                }

                if(min!=Integer.MAX_VALUE)
                jumps[i]=min+1;
                else
                jumps[i]=min;
            }

        }
        System.out.println(jumps[0]);
    }
    /**This implementation is basically well understood by pict. hills and valleys
     * Greedy algo has been used. 5,2,1,0,0,1,2, shows nodes 1,2 not reached.
     * TIme=n
     * space=o(1).
     */
    static void solveGreedy(int arr[], int n)
    {
        int ans=0;
        int farlimit=0, currEnd=0, jumps=0;
        for(int i=0;i<n;i++)
        {
            farlimit=Math.max(farlimit, arr[i]+i);

            if(farlimit >=n-1) //overflow at some i
            {
                ans=1+jumps;
                break;
            }

            if(i==farlimit) //end not reached as cannot cross valley or 0 might have been encountered
            {
                ans=-1;
                break;
            }

            if(i==currEnd) //if currEnd is approached increase currEnd to max farlimit possible
            {
                jumps++;
                currEnd=farlimit;
                ans=jumps;
            }

        }
        
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int arr[]={1,0,0, 1, 3,5, 8, 9, 2, 6, 7 ,6,8, 9 };
        solveDP(arr, arr.length);
    }
}