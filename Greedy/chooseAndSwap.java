import java.util.Arrays;

/**
 * chooseAndSwap
 */
public class chooseAndSwap {

    static String solve(String input){
       
        int n=input.length();
        char str[]=input.toCharArray();
        int left[]=new int[26];
        Arrays.fill(left, -1);

        for(int i=0;i<n;i++){
            if(left[str[i]-'a']==-1)
            left[str[i]-'a']=i;
        }
        int i=0, j=0;
        outer: for(i=0;i<n;i++){
            for(j=0;j<str[i]-'a';j++){
                if(left[j]>left[str[i]-'a'])
                {
                    break outer;
                }
            }
        }

        if(i<n){
            char ch1=str[i];
            char ch2=(char)(j+'a');
            //replace all occurances
            for(i=0;i<n;i++){
                if(str[i]==ch1) str[i]=ch2;
                else if(str[i]==ch2) str[i]=ch1;
            }
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {

        System.out.println(solve("ccad"));
    }

    
}