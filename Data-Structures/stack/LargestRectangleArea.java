package stack;
import java.util.*;
public class LargestRectangleArea {
	public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ps = previousSmaller(heights , n);
        int[] ns = nextSmaller(heights , n );
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            int width = ns[i] - ps[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area , maxArea);
        }
        return maxArea;
    }
    public static int[] previousSmaller(int[] heights , int n ){
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(stack.isEmpty() == false && heights[i] <= heights[stack.peek()])
                stack.pop();
            if(stack.isEmpty())
                res[i] = -1;
            else 
                res[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
     public static int[] nextSmaller(int[] heights , int n ){
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1  ; i >= 0; i--){
            while(stack.isEmpty() == false && heights[i] <= heights[stack.peek()])
                stack.pop();
            if(stack.isEmpty())
                res[i] = n;
            else 
                res[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {2,1,5,6,2,3};
		int res = largestRectangleArea(heights);
		System.out.println(res);
		

	}

}
