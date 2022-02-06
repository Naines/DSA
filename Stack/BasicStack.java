import java.util.Arrays;

public class BasicStack {
    public static void main(String[] args) {
        Stack stk=new Stack(5);
        stk.push(10);
        stk.push(20);
        stk.push(50);
        stk.push(40);
        stk.push(30);
        System.out.println(stk);
        stk.push(60);
        System.out.println(stk);
        stk.pop();
        System.out.println(stk.pop());
        stk.push(90);
        System.out.println(stk);
        System.out.println( stk.isEmpty());
        System.out.println(stk.peek());
    }
    static class Stack{
        int top;
        int size;
        int arr[];
        Stack(int size){
            this.size=size;
            this.arr=new int[size];
            this.top=0;
        }
        public void push(int x){
            if(this.top==this.size){
                //make new array twice the size
                int newarr[]=new int[this.size*2];

                //copy elements
                for(int i=0;i<this.size;i++){
                    newarr[i]=arr[i];
                }
                this.arr=newarr;
                this.size*=2;
            }
            this.arr[this.top]=x;
            this.top++;
            
        }
        public int pop(){
            int popped=arr[--top];
            arr[top]=0;
            return popped;
        }
        public int peek(){
            return arr[top-1];
        }
        public boolean isEmpty(){
            if(top==0)
            return true;
            return false;
        }
        public String toString(){
            return Arrays.toString(arr);
        }
    }
}
