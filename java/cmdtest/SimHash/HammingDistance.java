package cmdtest.SimHash;

public class HammingDistance {
    //求海明距离，海明距离的求法：异或时，只有在两个比较的位不同时其结果是1 ，否则结果为0，两个二进制“异或”后得到1的个数即为海明距离的大小。
    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            //长度异常的情况
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                //对两个位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    //求相似度，输入simHash1和simHash2得到海明距离后计算得到。
    public static double getSimilarity(String simHash1, String simHash2) {

        int distance = getHammingDistance(simHash1, simHash2);
        //通过海明距离计算出相似度
        double similarity = 0.01 * (100 - distance * 100 / 128);
        return similarity;
    }
}
