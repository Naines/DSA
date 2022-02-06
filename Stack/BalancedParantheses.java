import java.util.Stack;

public class BalancedParantheses {
    static boolean check(String str){
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            switch(ch){
                case '(':
                case '{':
                case '[':
                            stk.push(ch);
                            break;
                case ']':   if(stk.isEmpty() || stk.peek()!='[') return false;
                            stk.pop();
                            break;

                case '}':   if(stk.isEmpty() || stk.peek()!='{') return false;
                            stk.pop();
                            break;
                case ')':   if(stk.isEmpty() || stk.peek()!='(') return false;
                            stk.pop();
                            break; 

                default:
                            break;
            }
        }
        if(!stk.isEmpty()) return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(check("[()]{}{[()()]()}"));//true
        System.out.println(check("[(])"));//false
        System.out.println(check("]()"));//fasle
        System.out.println(check("{ ( [ ] ) }"));//true
        System.out.println(check("[()"));//fasle
    }
}
