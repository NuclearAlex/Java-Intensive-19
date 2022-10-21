import model.MyArrayList;
import model.QuickSortMyArrayList;

public class Runner {
    public static QuickSortMyArrayList quickSort = new QuickSortMyArrayList();

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        System.out.println("Create:");
        System.out.println("Size is " + myArrayList.size());
        System.out.println(myArrayList + "\n");

        myArrayList.add(2);
        myArrayList.add(6);
        myArrayList.add(1);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(5);

        System.out.println("Added 6 digits:");
        System.out.println("Size is " + myArrayList.size());
        System.out.println(myArrayList + "\n");

        myArrayList.add(1, 8);
        myArrayList.add(5, 16);

        System.out.println("Added some digits by index:");
        System.out.println("Size is " + myArrayList.size());
        System.out.println(myArrayList + "\n");

        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);

        System.out.println("Added digits more than init capacity:");
        System.out.println("Size is " + myArrayList.size());
        System.out.println(myArrayList + "\n");

        System.out.println("Remove element by index:");
        myArrayList.remove(3);
        System.out.println("Size is " + myArrayList.size());
        System.out.println(myArrayList + "\n");

        System.out.println("Sorted list:");
        quickSort.sort(myArrayList, 0, myArrayList.size() - 1);
        System.out.println(myArrayList + "\n");
    }
}