package cmdtest.SimHash;

import java.io.*;

public class readToString {

    //将目标文档读出
    public static String readFile(String FilePath) {
        String str = "";
        String strLine;
        //将文档读入str中，将文档内容转化为 String字符串输出。
        File file = new File(FilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //将字符串进行拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str += strLine;
            }
            //结束并关闭
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //将文档写入
    public static void writeFile(double FileElem,String FilePath){
        //将文档内容、文档路径写入
        String str = Double.toString(FileElem);
        File file = new File(FilePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            fileWriter.write("\r\n");
            //结束并关闭
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
