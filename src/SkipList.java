class SkipList {

    private SkipListNode[] head;
    private int n = 0; // list size

    // constructor to initialise a new skip list with five lanes
    public SkipList() {
        head = new SkipListNode[5];
    }


    // this method sets up a skip list with five String elements
    // “Anne”, “Ben”, “Charlie”, “Don” and “Ernie” programmatically for testing
    // This is set up as follows:

    //   Anne                                          Ernie
    //o-------------------------------------------------> o---------------> o    Top level
    //   Anne                 Charlie                  Ernie
    //o--------------------------> o--------------------> o---------------> o    Middle level
    //   Anne       Ben       Charlie        Don       Ernie
    //o-------------> o----------> o---------> o--------> o---------------> o    Bottom level

    public void createTestList() {
        SkipListNode a = new SkipListNode("Anne", 3);
        SkipListNode b = new SkipListNode("Ben", 1);
        SkipListNode c = new SkipListNode("Charlie", 2);
        SkipListNode d = new SkipListNode("Don", 1);
        SkipListNode e = new SkipListNode("Ernie", 3);

        head[0] = a;
        head[1] = a;
        head[2] = a;

        a.next[0] = b;
        a.next[1] = c;
        a.next[2] = e;

        b.next[0] = c;

        c.next[0] = d;
        c.next[1] = e;

        d.next[0] = e;
    }

    //  this method prints out the list elements of each of the lanes that make up the skip list, in ascending order
    //  'print' should first print out the elements of the highest lane, separated by commas without line breaks,
    //  and then proceed downwards to the lower lanes analogously
    public void print() {
        for (int i = 4; i >= 0; i--) {
            SkipListNode node = head[i];
            if (node == null) ;
            else {
                System.out.print(node.element);
                if (node.next.length >= i+1){
                    node = node.next[i];
                    while (node != null) {
                        System.out.print(", " + node.element);
                        node = node.next[i];
                    }
                }
            }
            System.out.println();
        }
    }


    // this method checks whether the given String s is part of the list and returns true if it is,
    // otherwise false; the method makes use of the different lanes to optimize runtime
    public boolean inList(String s) {

        int lane = 4;

        SkipListNode node = new SkipListNode(null);
        node.next = head;

        while (lane >= 0) {
            if (node.next[lane] != null) {
                int j = s.compareTo(node.next[lane].element);
                if (j == 0) return true;
                if (j > 0) {
                    node = node.next[lane];
                } else {
                    if (lane == 0) return false;
                    lane--;
                }
            } else lane--;
        }

        return false;
    }

    //  this method inserts the given element into the skip list, making use of the different lanes to optimize runtime
    //  and inserting the string correctly into all relevant lanes
    public void insert(String s) {
        int lane = 4;

        SkipListNode node = new SkipListNode(null);
        node.next = head;

        SkipListNode insertion = new SkipListNode(s);
        int size = insertion.next.length;

        while (lane >= 0) {
            if (node.next[lane] != null) {
                int j = s.compareTo(node.next[lane].element);
                if (j > 0) {
                    node = node.next[lane];
                } else {
                    if (size >= lane+1 ){ // this lane is in the 'next' array for s
                        insertion.next[lane] = node.next[lane];
                        node.next[lane] = insertion;
                    }
                    if (lane == 0) return;
                    lane--;
                }
            } else {
                if (size >= lane+1) {
                    node.next[lane] = insertion;
                }
                lane--;
            }
        }
    }

}
