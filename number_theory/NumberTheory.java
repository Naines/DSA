
 import java.util.*;
 class NumberTheory
 {

    /**
    * Modular Arithmetic:
    *  1. (a+b)%c=(a%c+b%c)%c
    *  2. (a*b)%c=(a%c*b%c)%c
    *  3. (a-b)%c=(a%c-b%c+c)%c
    *  4. (a/b)%c=(a%c*(b^-1)%c)%c -- (b^-1 is multiplicative modulo inverse)
    */
    //Modular Addition
    public int modularAddition(int a,int b,int MOD){
      return (a%MOD+b%MOD)%MOD;
    }
    public long modularAddition(long a,long b,long MOD){
      return (a%MOD+b%MOD)%MOD;
    }
    //Modular Multiplication
    public int modularMultiplication(int a,int b,int MOD){
      return ((a%MOD)*(b%MOD))%MOD;
    }
    public long modularMultiplication(long a,long b,long MOD){
      return ((a%MOD)*(b%MOD))%MOD;
    }
    //Modular Subtraction
    public int modularSubtraction(int a,int b,int MOD){
      return (a%MOD-b%MOD+MOD)%MOD;
    }
    public long modularSubtraction(long a,long b,long MOD){
      return (a%MOD-b%MOD+MOD)%MOD;
    }

    /**
    * Binary Exponentiation
    */
    public int binaryExponentiation(int x,int n){
      if(n==0)return 1;
      else if(n%2==0)return binaryExponentiation(x*x,n/2);
      else return x*binaryExponentiation(x*x,(n-1)/2);
    }
    public long binaryExponentiation(long x,long n){
      long result=1;
      while(n>0){
        if(n%2==1)result*=x;
        x=x*x;
        n/=2;
      }
      return result;
    }

    /**
    * Modular Exponentiation
    */
    public int modularExponentiation(int x,int n,int MOD){
      if(n==0)
      return 1%MOD;
      else if(n%2==0)
      return modularExponentiation(modularMultiplication(x,x,MOD),n/2,MOD);
      else
      return modularMultiplication(x,modularExponentiation(modularMultiplication(x,x,MOD),(n-1)/2,MOD),MOD);
    }
    public long modularExponentiation(long x,long n,long MOD){
      long result=1;
      while(n>0)
      {
        if(n%2==1)result=modularMultiplication(result,x,MOD);
        x=modularMultiplication(x,x,MOD);
        n/=2;
      }
      return result;
    }

    /**
    * Factorial of a number
    */
    public long factorials(long n){
      if(n==0)return 1;
      return n*factorials(n-1);
    }

    /**
    * Prime factors of a number
    */
    public ArrayList<Integer> distinctPrimeFactors(int n){
      ArrayList<Integer> factorials=new ArrayList<>();
      int limit=(int)Math.sqrt(n);
      if(n%2==0){
        factorials.add(2);
        while(n%2==0)n/=2;
      }
      for(int i=3;i<=limit;i+=2){
        if(n%i==0){
          factorials.add(i);
          while(n%i==0)n/=i;
        }
      }
      if(n>2)factorials.add(n);
      return factorials;
    }

    public ArrayList<Long> distinctPrimeFactors(long n){
      ArrayList<Long> factorials=new ArrayList<>();
      long limit=(long)Math.sqrt(n);
      if(n%2==0){
        factorials.add((long)2);
        while(n%2==0)n/=2;
      }
      for(long i=3;i<=limit;i+=2){
        if(n%i==0){
          factorials.add(i);
          while(n%i==0)n/=i;
        }
      }
      if(n>2)factorials.add(n);
      return factorials;
    }

    public ArrayList<Integer> primeFactors(int n){
      ArrayList<Integer> factorials=new ArrayList<>();
      int limit=(int)Math.sqrt(n);
      if(n%2==0){
        factorials.add(2);
        while(n%2==0)n/=2;
      }
      for(int i=3;i<=limit;i+=2){
        if(n%i==0){
          factorials.add(i);
          while(n%i==0)n/=i;
        }
      }
      if(n>2)factorials.add(n);
      return factorials;
    }

    public ArrayList<Long> primeFactors(long n){
      ArrayList<Long> factorials=new ArrayList<>();
      long limit=(long)Math.sqrt(n);
      if(n%2==0){
        factorials.add((long)2);
        while(n%2==0)n/=2;
      }
      for(long i=3;i<=limit;i+=2){
        if(n%i==0){
          factorials.add(i);
          while(n%i==0)n/=i;
        }
      }
      if(n>2)factorials.add(n);
      return factorials;
    }

    /**
    * Combination: nCr
    */
    //Naive version
    //(n,r)=(n-1,r-1)+(n-1,r) for r!=0 or r!=n
    //(n,0)=(n,n)=1
    public int binomialCoefficientRecursive(int n,int k){
      if(k==0 || k==n)return 1;//base case
      return binomialCoefficientRecursive(n-1,k-1)+binomialCoefficientRecursive(n-1,k);//recursion
    }

    //Dynamic Programming version(Uses bottom up approach to fill the table)
    //Time complexity: O(n*k)
    //Space complexity: O(n*k)
    public long binomialCoefficientIterative(int n,int k){
      long[][] C=new long[n+1][k+1];
      for(int i=0;i<=n;++i){
        for(int j=0;j<=Math.min(n,k);++j){
          if(j==0 || j==i)C[i][j]=1;
          else C[i][j]=C[i-1][j-1]+C[i-1][j];
        }
      }
      return C[n][k];
    }

    //Pascal's Triangle version(Space efficient program)
    //Time complexity: O(n*k)
    //Space complexity: O(k)
    public long nCr(int n,int r){
      int[] C=new int[r+1];
      C[0]=1;//nC0=1
      for(int i=1;i<=n;++i)
      for(int j=Math.min(i,r);j>0;--j)
      C[j]=C[j]+C[j-1];
      return C[r];
    }

    /**
    * Catlan number:
    *  - Time complexity: O(n*n)
    *  - Auxiliary space: O(n)
    *
    *  NOTE: Time complexity could be reduced to O(n) but it is
    *        possible if and only if n is small or else there is
    *        a chance of getting an overflow. To decrease the time
    *        complexity to O(n) just remember nCr=nCn-r
    */
    public long catlanNumber(int n){
      long[] catlan=new long[n+1];
      catlan[0]=catlan[1]=1;
      for(int i=2;i<=n;++i)
      for(int j=0;j<i;++j)
      catlan[i]+=catlan[j]*catlan[i-1-j];

      return catlan[n];
    }

    /**
    * Greatest Common Divisor(GCD)
    *  - It is also known as Highest Common Factor(HCF)
    *  - Time complexity: log(min(a,b))
    *  - Auxiliary Space: O(1)
    */
    public int gcd(int a,int b){
      if(b==0)return a;
      return gcd(b,a %b);
    }

    public long gcd(long a,long b){
      if(b==0)return a;
      return gcd(b,a%b);
    }

    /**
    * Extended Euclid's Algorithm:
    *  - ax+by=gcd(a,b)
    *  - Time complexity:
    *  -
    */


    /**
    * Least Common Multiple(LCM):
    *  - Time complexity: log(min(a,b))
    *  - Auxiliary Space: O(1)
    */
    public long lcm(long a,long b){
      return (a*b)/gcd(a,b);
    }

  }
