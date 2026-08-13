import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    class MedianFinder {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        public MedianFinder() {
            max = new PriorityQueue<>(Collections.reverseOrder());
            min = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if(max.isEmpty() || num <= max.peek()){
                max.offer(num);
            }
            else{
                min.offer(num);
            }

            if(max.size() > min.size() + 1){
                min.offer(max.poll());
            }
            else if(min.size() > max.size()){
                max.offer(min.poll());
            }
        }
        
        public double findMedian() {
            if(max.size() > min.size()){
                return max.peek();
            }
            return (max.peek() + min.peek()) / 2.0;
        }
    }


    public void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(5);
        obj.addNum(1);
        obj.addNum(7);
        obj.addNum(2);

        System.out.println(obj.findMedian());
    }
}
