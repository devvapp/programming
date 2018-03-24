import java.lang.Integer;

/**
 * CircularQueueArray
 */
public class CircularQueueArray {

    private int front, rear, size, capacity;
    private int[] array;

    public CircularQueueArray(int capacity){
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size=this.front=0;
        this.rear=capacity-1;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getFront(){
        if(this.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    public int getRear(){
        if(this.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }


    public void enqueue(int item){
        if(isFull()){
            System.out.println("Queue full, item->" + item + " not inserted");
            return;
        }
        this.rear = (this.rear+1) % this.capacity;
        array[this.rear] = item;
        this.size++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue empty");
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front+1) % this.capacity;
        this.size--;

        System.out.println("item->" + item + "dequeued...");
        return item;
    }

    public void printQueue(){
        int x= this.front%this.capacity;
        int count=0;
        do{
            System.out.println(x + "->" + this.array[x] + " ");
            x=(x+1)%this.capacity;
            count++;
        } while(count<size);
        System.out.println();
    }
    
    public static void main(String[] args) {
        

        CircularQueueArray queue = new CircularQueueArray(8);

        queue.printQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(12);
        queue.enqueue(30);
        queue.enqueue(41);
        queue.enqueue(50);
        
        queue.printQueue();
        
    }
}