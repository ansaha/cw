import java.util.Random;

public class SkipListNode {

    public String element;
    public SkipListNode[] next;

    // constructor for skip list node that adds an element to a higher lane
    // with a probability of 0.5
    public SkipListNode(String e) {
        element = e;

        Random r = new Random();
        int l = 1;
        while (r.nextFloat() < 0.5 && l<5) l++;
        next = new SkipListNode[l];
    }

    // constuctor specifically created for hard coded test list
    public SkipListNode(String e, int l) {
        element = e;
        next = new SkipListNode[l];
    }

}
