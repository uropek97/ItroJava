import java.util.LinkedList;

//не совсем понял, это ли требуется во втором задании.
public class MyLinked implements MyQueue{
    LinkedList<Integer> linkedList;

    public MyLinked(LinkedList<Integer> linkL){
        this.linkedList = linkL;
    }

    @Override
    public void enqueue(int item) {
        this.linkedList.addLast(item);
    }

    @Override
    public int dequeue() {
        return this.linkedList.removeFirst();
    }

    @Override
    public int first() {
        return this.linkedList.getFirst();
    }

    @Override
    public String toString(){
        return this.linkedList.toString();
    }
}
