public class Dequeue {
    private int[] queue;
    private int front;
    private int back;
    private boolean used;

    public Dequeue() {
        this.queue =  new int[1];
        this.front = 0;
        this.back = 0;
        this.used = false;
    }

    public void pushBack(int item) {
        if ((!used) || (front != back)) {
            queue[back % queue.length] = item;
            back = (back + 1) % queue.length;
            used = true;
        }
        else {
            int[] newArray = new int[2 * queue.length];
            for (int i = 0; i < this.queue.length; i++) {
                newArray[i] = this.queue[(this.front + i) % this.queue.length];
            }
            newArray[queue.length] = item;
            back = (queue.length + 1) % newArray.length;
            queue = newArray;
            front = 0;
        }
    }

    public void pushFront(int item) {
        if ((!used) || (front != back)) {
            queue[(front - 1 + queue.length) % queue.length] = item;
            front = (front - 1 + queue.length) % queue.length;
            used = true;
        }
        else {
            int[] newArray = new int[2 * queue.length];
            for (int i = 0; i < this.queue.length; i++) {
                newArray[i + 1] = this.queue[(this.front + i) % this.queue.length];
            }
            newArray[0] = item;
            back = (queue.length + 1) % newArray.length;
            queue = newArray;
            front = 0;
        }
    }

    //remove and return the front item from the Queue
    //throw EmptyQueueException if the Queue is empty
    //reduce the array capacity by half if the size
    //of the Queue falls below 1/4 full
    public int popBack() throws Exception {
        if (!used) {
            throw new Exception();
        }
        int result = queue[(back - 1 + queue.length) % queue.length];
        back = (back - 1 + queue.length) % queue.length;
        if (back == front) {
            used = false;
        }
        return result;
    }
    public int popFront() throws Exception {
        if (!used) {
            throw new Exception();
        }
        int result = queue[front];
        front = (front + 1) % queue.length;
        if (back == front) {
            used = false;
        }
        return result;
    }

    public int get(int index) {
        return queue[(front + index) % queue.length];
    }

    public int size() {
        //To be implemented
        if (!used) {
            return 0;
        }
        if (this.front < this.back) {
            return this.back - this.front;
        }
        return  this.queue.length - (this.front - this.back);
    }

}
