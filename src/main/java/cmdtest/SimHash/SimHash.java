package cmdtest.SimHash;

import com.hankcs.hanlp.HanLP;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHash{
    public static String getHash(String str){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");//hash值用MD5计算得到
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }


    public static String getSimHash(String str){
        //判断所读文本长度是否太短
        try{
            if(str.length() < 200) throw new ShortString("文本长度太短！");
        }catch (ShortString e){
            e.printStackTrace();
            return null;
        }
        //定义特征向量/数组，为128位。
        int[] v = new int[128];
        //1.分词，此处用的是HanLP分词
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        //2.获取hash值
        int size = keywordList.size();
        int i = 0;//以i做外层循环
        for(String keyword : keywordList){
            String keywordHash = getHash(keyword);
            //若hash值少于128位时在低位以0补齐
            if (keywordHash.length() < 128) {
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            //3.加权和合并
            //当遇到keywordHash的1则hash值和权值正相乘，遇到0则hash值和权值负相乘，并累加合并。
            for (int j = 0; j < v.length; j++) {
                if (keywordHash.charAt(j) == '1') {
                    //将权重分10级，根据词频的高到低赋权值10到0.
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        //4.降维
        String simHash = "";
        //遍历得到的simHash值，如果大于0则置1，否则置0.
        for (int j = 0; j < v.length; j++) {
            if (v[j] > 0) {
                simHash += "1";
            } else {
                simHash += "0";
            }
        }
        return simHash;
    }
}
