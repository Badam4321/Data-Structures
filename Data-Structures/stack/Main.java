package stack;

class Stack{
    int top;
    static final int MAX = 1000;
    int[] arr ;
    public Stack(){
        arr = new int[MAX];
        top = -1;
    }

    boolean push(int x){
        if(top >= MAX){
            System.out.println("Stack Overflow");
            return false;
        }
        top++;
        arr[top] = x;
        System.out.println(x + " pushed into the stack");
        return true;

    }

    boolean isEmpty(){
        if(top == -1)
            return true;
        return false;
    }
    int pop(){
        if(top == -1 ){
            System.out.println("stack underflow");
            return 0;
        }
        int x = arr[top];
        top--;
        return x;

    }
    int peek(){
        if(top == -1 ){
            System.out.println("stack underflow");
            return 0;
        }
        int x = arr[top];
        return x;
    }
    int size(){
        return top + 1;
    }
    void print() {
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }
    

}
public class Main {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        st.print(); // Print the stack elements
        System.out.println("Popped element: " + st.pop());
        st.print(); // Print the stack elements after popping
        System.out.println("peek element : " + st.peek());
        System.out.println("size of the stack : "  + st.size());
    }
    
}




