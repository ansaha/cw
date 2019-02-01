public class SkipListTests {
    public static void main(String[] args) {
        SkipList l = new SkipList();
        l.createTestList();
        l.print();

        System.out.println();
        System.out.println("Should be: ");
        System.out.println("Anne, Ernie");
        System.out.println("Anne, Charlie, Ernie");
        System.out.println("Anne, Ben, Charlie, Don, Ernie");

        System.out.println();
        System.out.print(l.inList("Anne"));
        System.out.println(" should be true");

        System.out.print(l.inList("Ernie"));
        System.out.println(" should be true");


        System.out.print(l.inList("Alice"));
        System.out.println(" should be false");


        l.insert("Dermot");
        l.insert("Catherine");
        l.insert("Agatha");
        l.insert("Frasier");
        l.insert("Miriam");

        System.out.println();
        System.out.println("The list is currently as follows:  ");
        l.print();

        System.out.println();
        System.out.print(l.inList("Agatha"));
        System.out.println(" should be true");
        System.out.print(l.inList("Dermot"));
        System.out.println(" should be true");
        System.out.print(l.inList("Miriam"));
        System.out.println(" should be true");
    }
}
