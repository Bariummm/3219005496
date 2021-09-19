
import cmdtest.SimHash.HammingDistance;
import cmdtest.SimHash.readToString;
import cmdtest.SimHash.HammingDistance;
import cmdtest.SimHash.SimHash;
import cmdtest.SimHash.readToString;
import org.junit.Test;

public class MainTest {

    @Test
    public void origAndAllTest(){
        //读入文档
        String[] str = new String[6];
        str[0] = readToString.readFile("files/orig.txt");
        str[1] = readToString.readFile("files/orig_0.8_add.txt");
        str[2] = readToString.readFile("files/orig_0.8_del.txt");
        str[3] = readToString.readFile("files/orig_0.8_dis_1.txt");
        str[4] = readToString.readFile("files/orig_0.8_dis_10.txt");
        str[5] = readToString.readFile("files/orig_0.8_dis_15.txt");
        String ResultFileName = "files\\TheResultOfAll.txt";
        //逐个求出原文档与抄袭文档的相似度后输出到指定路径。
        for(int i = 0; i <= 5; i++){
            double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str[0]), SimHash.getSimHash(str[i]));
            readToString.writeFile(Result, ResultFileName);
        }
    }

    //分别求原文档与各个抄袭文档的相似度

    @Test
    public void origAndOrigTest(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig.txt");
        String ResultFileName = "files/TheResultOfOrigAndOrigTest.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result, ResultFileName);
    }

    @Test
    public void origAndAddTest(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_add.txt");
        String ResultFileName = "files/TheResultOfOrigAndAddTest.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result, ResultFileName);
    }

    @Test
    public void origAndDelTest(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_del.txt");
        String ResultFileName = "files/TheResultOfOrigAndDelTest.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result, ResultFileName);
    }

    @Test
    public void origAndDis1Test(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_dis_1.txt");
        String ResultFileName = "files/TheResultOfOrigAndDis1Test.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result, ResultFileName);
    }

    @Test
    public void origAndDis10Test(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_dis_10.txt");
        String ResultFileName = "files/TheResultOfOrigAndDis10Test.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result, ResultFileName);
    }

    @Test
    public void origAndDis15Test(){
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_dis_15.txt");
        String ResultFileName = "files/TheResultOfOrigAndDis15Test.txt";
        double Result = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        readToString.writeFile(Result,ResultFileName);
    }


}
