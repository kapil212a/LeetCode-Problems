import java.util.Stack;

public class Stacks{
    static Stack <Integer> stack;
    static Stack <Integer> minStack;

    public Stacks() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public static void push(int value) {
        stack.push(value);
        
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        else{
            minStack.push(Math.min(value , minStack.peek()));
        }
    }
    
    public static void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public static int top() {
        return stack.peek();
    }
    
    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stacks obj = new Stacks();

        obj.push(5);
        obj.push(9);
        obj.push(4);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
