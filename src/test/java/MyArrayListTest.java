import model.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void myArrayListMustHaveInitSizeZero() {
        MyArrayList<Integer> myArrayList = new MyArrayList();

        Assert.assertEquals(0, myArrayList.size());
    }

    @Test
    public void myArrayListMustAddedItemsCorrectly() {
        MyArrayList<Integer> myArrayList = new MyArrayList();

        myArrayList.add(1);

        Assert.assertEquals(1, myArrayList.size());
    }

    @Test
    public void myArrayListMustGetItemsCorrectly() {
        MyArrayList<Integer> myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(8);

        Assert.assertEquals(2, (int) myArrayList.get(1));
        Assert.assertNull(myArrayList.get(3));
    }

    @Test
    public void myArrayListMustDeleteCorrectly() {
        MyArrayList<Integer> myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(8);
        myArrayList.remove(1);

        Assert.assertEquals(1, (int) myArrayList.get(0));
        Assert.assertEquals(8, (int) myArrayList.get(1));
        Assert.assertEquals(2, myArrayList.size());
    }

    @Test
    public void myArrayListMustSortedCorrectly() {
        MyArrayList<Integer> myArrayList = new MyArrayList();

        for (int i = 0; i < 8; i++) {
            myArrayList.add(8 - i);
        }

        myArrayList.sort(0, myArrayList.size() - 1);

        Assert.assertEquals(2, (int) myArrayList.get(1));
        Assert.assertEquals(4, (int) myArrayList.get(3));
        Assert.assertEquals(8, (int) myArrayList.get(myArrayList.size() - 1));
    }
}
