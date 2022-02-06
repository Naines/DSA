import java.util.Stack;

public class longestValid {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int res=0;
        Stack<Integer> st= new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
                st.pop();
                if(st.isEmpty())
                {
                    st.push(i);
                }
                else{
                int l=i-st.peek();
                res=Math.max(res,l);
                }
            }
        }
        return res;
    }
}
