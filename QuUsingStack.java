import java.util.Stack;

public class QuUsingStack {
    class MyQueue {
        Stack <Integer> st1;
        Stack <Integer> st2;
        public MyQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }
        
        public void push(int x) {
            st1.push(x);
        }
        
        public int pop() {
            check();
            return st2.pop();
        }
        
        public int peek() {
            check();
            return st2.peek();
        }
        
        public boolean empty() {
            return st2.isEmpty() && st1.isEmpty();
        }

        private void check(){
            if(st2.isEmpty()){
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
            }
        }
    }

    public void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(10);
        obj.peek();
        System.out.println(obj.peek());
    }
}
