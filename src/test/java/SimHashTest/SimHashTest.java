package SimHashTest;

import cmdtest.SimHash.SimHash;
import cmdtest.SimHash.readToString;
import org.junit.Test;

public class SimHashTest {

    @Test
    public void getHashTest(){
        String[] strings = {"我", "是", "粑粑"};
        for (String string : strings) {
            String stringHash = SimHash.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    public void getSimHashTest(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_add.txt");
        System.out.println(SimHash.getSimHash(str0));
        System.out.println(SimHash.getSimHash(str1));
    }

}
