import java.util.Stack;

public class ReverseString {
    static String reverse(String str){
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            stk.push(ch);
        }
        String revStr="";
        while(!stk.isEmpty()){
            revStr+=stk.pop();
        }
        return revStr;
    }
    public static void main(String[] args) {
        System.out.println(reverse("Nainesh"));
    }
}
