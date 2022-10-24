import model.MyArrayList;

public class Runner {
    public static final String BLUE = "\u001b[34m";
    public static final String GREEN = "\u001b[32m";
    public static final String DEFAULT = "\u001b[0m";

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        System.out.println("Create myArrayList...");
        System.out.println("myArrayList size is " + GREEN + myArrayList.size() + DEFAULT);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);

        myArrayList.add(2);
        myArrayList.add(6);
        myArrayList.add(1);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(5);

        System.out.println("Added 6 digits:");
        System.out.println("myArrayList size is " + GREEN + myArrayList.size() + DEFAULT);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);

        myArrayList.add(1, 8);
        myArrayList.add(5, 16);

        System.out.println("Added digits 8 and 16 by index \"1\" and \"5\":");
        System.out.println("myArrayList size is " + GREEN + myArrayList.size() + DEFAULT);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);

        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);

        System.out.println("Added digits more than init capacity:");
        System.out.println("myArrayList size is " + GREEN +  myArrayList.size() + DEFAULT);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);

        System.out.println("Remove element by index \"3\":");
        myArrayList.remove(3);
        System.out.println("myArrayList size is " + GREEN +  myArrayList.size() + DEFAULT);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);

        System.out.println("Sorted list:");
        myArrayList.sort(0, myArrayList.size() - 1);
        System.out.println("myArrayList elements:\n" + BLUE + myArrayList + "\n" + DEFAULT);


        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 50_000; i++) {
            testList.add(50_000 - i);
        }
        System.out.println("testList size is: " + testList.size());
        long startTime = System.currentTimeMillis();
        testList.sort(0, testList.size() - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Spent time for quick sort: " + GREEN + (endTime - startTime) + DEFAULT);
    }
}