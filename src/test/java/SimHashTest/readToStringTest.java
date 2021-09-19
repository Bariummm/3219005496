package SimHashTest;

import cmdtest.SimHash.readToString;
import org.junit.Test;

public class readToStringTest {

    @Test
    //正常情况下读出文档
    public void readTxtTest() {
        String str = readToString.readFile("files/orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    //正常情况下写入文档
    public void writeTxtTest() {
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            readToString.writeFile(elem[i], "files/TheResultOfAll.txt");
        }
    }

    @Test
    //当路径无效时读出文档
    public void readTxtFailTest() {
        String str = readToString.readFile("files/none.txt");
    }

    @Test
    //当路径无效时写入文档
    public void writeTxtFailTest() {
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            readToString.writeFile(elem[i], "file/TheResultOfAll.txt");
        }
    }

}
