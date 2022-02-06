import java.util.HashSet;

/**
 * sumofNnumbers
 */
public class basics {

    static int sum(int n)
    {
        if(n==1)
        return 1;
        return n+sum(n-1);
    }
    static int fact(int n)
    {
        if(n==1)
        return 1;
        return n*fact(n-1);
    }
    static int fib(int n)
    {
        if(n==1 || n==0)
        return n;
        return fib(n-1)+fib(n-2);
    }
    static void printN(int n)
    {
        if(n==1){
            System.out.println(1);
            return;
        }   
        System.out.println(n);
        printN(n-1);
        System.out.println(n);
    }
    static int minSteps(int n)
    {
        if(n==1)
        return 0;
        int a1=0, a2=Integer.MAX_VALUE, a3=Integer.MAX_VALUE;
        a1=minSteps(n-1);

        if(n%2==0)  a2=minSteps(n/2);
        if(n%3==0)  a3=minSteps(n/3);

        return 1+ Math.min(a1, Math.min(a2, a3));
    }
    static int pow(int a, int b)
    {

        if(b==0)    return 1;
        if(b==1)    return a;
        int temp=pow(a, b/2);
        if(b%2!=0) return a*temp*temp;;
        return temp*temp;
    }
    static int exp(int a, int b)
    {
        if(b==0)    return 1;
        if(b%2==0)  return exp(a*exp(a*a, b/2), b/2);
        return exp(a*a, (b-1)/2);

    }
    static int knapsack(int val[], int wt[], int W, int n)
    {
        if(n==0 || W==0)    return 0;

        if(W>=wt[n-1])
        {
            //a-take it
            int p1=val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);

            //or we may leave it
            int p2=knapsack(val, wt,W, n-1);

            return Math.max(p1, p2);
        }
        else{//leave it
            return knapsack(val, wt,W, n-1);
        }
    }
    static void patt(int n)
    {
        if(n==0)    return;
        patt1(n);
        System.out.println();
        patt(n-1);
    }
    static void patt1(int n)
    {
        if(n==0)    return ;
        System.out.print("*");
        patt1(n-1);
    }

    static void patt2(int n, int i)
    {
        if(n==0)    return;
        if(i<n){
            System.out.print("*");
            patt2(n, i + 1);
        }
        else{
            System.out.println();
            patt2(n - 1, 0);
            
        }

    }
    static void subsets(int arr[], int index, String s)
    {
        if(index==arr.length)
        {
            System.out.println(s);
            return;
        }

        subsets(arr,index+1,s+arr[index]);
        subsets(arr,index+1,s);
        
    }
    //no consecutive 1s
    static void binaryStrings(int index,int n, String s)
    {
        if(index==n)
        {
            boolean zero=true, print=true;
            for(int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(ch=='1' && zero==false)
                {
                    print=false;
                    break;
                } 
                
                
                if(ch!='0') 
                zero=false;
                else zero=true;
            }
            if(print) System.out.println(s);
            return;
        }
        binaryStrings(index+1, n, s+"0");
        binaryStrings(index+1, n, s+"1");
    }
    //check if array is sorted
    static boolean isSorted(int arr[], int index)
    {
        if(index+1==arr.length)
        return true;

        if(arr[index]< arr[index+1])
        return isSorted(arr, index+1);
        return false;
    }

    static int ans=0;
    static void maze(int cr, int cc,int er, int ec, String s)
    {
        //reach destination
        if(cr==er && cc==ec)
        {
            ans+=1;
            System.out.println(s);
            return;
        }
        //invalid
        if(cr>er || cc>ec)
        return ;
        //System.out.println(cr+" "+cc+" "+s);
        maze(cr, cc+1, er, ec, s+"R");
        maze(cr+1, cc, er, ec, s+"D");
    }

    //we can jump from 1..6 moves from a cell
    //give all the jumps 
    static void jumps(int i, int n, String s)
    {
        if(i>=n)    return;
        if(i==n-1)    {
            System.out.println(s);
            return;
        }

        for(int k=1;k<=6;k++)
        {
            jumps(i+k, n, s+k);
        }
    }

    static void lexicoNumPrint(int n, int x)
    {
        if(x>n) return;
        if(x<=n)
        {
            System.out.println(x);
        }
        for(int i=x==0?1:0;i<=9;i++)
        {
            lexicoNumPrint(n, 10*x+i);
        }
    }

    static void perm(String str, String res)
    {
        if(str.length()==0)
        {
            System.out.println(res);
            return;
        }

        for(int i=0;i<str.length();i++)
        {
            String ros=str.substring(0, i)+str.substring(i+1);
            perm(ros, res+str.charAt(i));
        }
    }

     
    static void UniquePerm(String str, String res) {
        if (str.length() == 0) 
        {
            System.out.println(res);
            return;
        }
        HashSet<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) 
        {
            char ch=str.charAt(i);
            if(!s.contains(ch))
            {
                String ros=str.substring(0, i)+str.substring(i+1);
                s.add(ch);
                UniquePerm(ros, res+ch);
            }
           
        }
    }
    public static void main(String[] args) {
        //int n;
        System.out.println(sum(3));
        System.out.println(fact(5));
        System.out.println(fib(10));

        System.out.println(minSteps(10));


         int val[] = { 60, 100, 120 };
         int wt[] = { 10, 20, 30 };
         int W = 50;
         System.out.println(knapsack(val, wt, W, wt.length));
         printN(5);
         
         System.out.println(pow(2,6));
         
         patt(4);
         patt2(4, 0);
        

         subsets(new int[]{1,2,3}, 0, "");

         binaryStrings(0,3,"");

         //isSorted
         System.out.println(isSorted(new int[]{1,2,3,4}, 0));
         System.out.println(isSorted(new int[]{5,1,2,3,4}, 0));


         //totalPathsInAGrid
         //here 2,2 is the cell position
         maze(0, 0, 2, 2, "");;
         System.out.println(ans);

        
        jumps(0, 4,"");

        System.out.println("lexico Order of numbers from 1..N");
        lexicoNumPrint(105, 0);


        System.out.println("Permuations of string: ");
        perm("ABC", "");

        System.out.println("Unique Permuations of string: ");
        UniquePerm("AAC", "");
        }
}