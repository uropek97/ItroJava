import java.util.Iterator;
import java.util.LinkedList;

public class lesson4 {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < 11; i++)
            linkedList.add(i);

        System.out.println(linkedList);

        var newLL = reverseLL(linkedList);

        System.out.println(linkedList);
        System.out.println(newLL);

        var myLinked = new MyLinked(newLL);

        System.out.println("MyLinked: ");
        System.out.println(myLinked);
        myLinked.enqueue(0);
        System.out.println("Enqueue method: ");
        System.out.println(myLinked);
        var a = myLinked.dequeue();
        System.out.println("Dequeue method: ");
        System.out.println(a);
        System.out.println(myLinked);
        var b = myLinked.first();
        System.out.println("First method: ");
        System.out.println(b);
        System.out.println(myLinked);

        System.out.println("Сумма элементов списка");
        System.out.println(linkedList);
        System.out.println(sumItems(linkedList));
    }

    public static LinkedList<Integer> reverseLL(LinkedList<Integer> linkedList){
        var reverse = new LinkedList<Integer>();
        if (linkedList.size() > 0){
            var iterator = linkedList.listIterator(linkedList.size()-1);
            reverse.add(linkedList.getLast());
            while (iterator.hasPrevious()){
                reverse.add(iterator.previous());
            }
        }
        return reverse;
    }


    public static int sumItems(LinkedList<Integer> linkedList){
        Iterator<Integer> iterator = linkedList.iterator();
        var result = 0;
        while (iterator.hasNext())
            result += iterator.next();
        return result;
    }
}
