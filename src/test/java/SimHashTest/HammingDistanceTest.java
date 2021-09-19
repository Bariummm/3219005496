package SimHashTest;

import cmdtest.SimHash.HammingDistance;
import cmdtest.SimHash.SimHash;
import cmdtest.SimHash.readToString;
import org.junit.Test;

public class HammingDistanceTest {

    @Test
    public void getHammingDistanceTest() {
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_add.txt");
        int distance = HammingDistance.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);
        System.out.println("相似度: " + (100 - distance * 100 / 128) + "%");
    }

    @Test
    //测试两个文档长度不一时是否会返回-1
    public void getHammingDistanceFailTest() {
        String str0 = "11111111";
        String str1 = "1111111";
        System.out.println(HammingDistance.getHammingDistance(str0, str1));
    }

    @Test
    public void getSimilarityTest() {
        String str0 = readToString.readFile("files/orig.txt");
        String str1 = readToString.readFile("files/orig_0.8_add.txt");
        int distance = HammingDistance.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        double similarity = HammingDistance.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("文档1和文档2的海明距离: " + distance);
        System.out.println("文档1和文档2的相似度:" + similarity);
    }

}
