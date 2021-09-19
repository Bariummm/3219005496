package cmdtest;

import cmdtest.SimHash.HammingDistance;
import cmdtest.SimHash.SimHash;
import cmdtest.SimHash.readToString;
import sun.util.locale.provider.JRELocaleProviderAdapter;

public class cmdMain {

    public static void main(String[] args) {
        //从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = readToString.readFile(args[0]);
        String str1 = readToString.readFile(args[1]);
        String resultFileName = args[2];
        //由字符串得出对应的 simHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        //由 simHash值求出相似度
        double similarity = HammingDistance.getSimilarity(simHash0, simHash1);
        //把相似度写入最后的结果文件中
        readToString.writeFile(similarity, resultFileName);
        //退出程序
        System.exit(0);
    }

}