package SimHashTest;

import cmdtest.SimHash.SimHash;
import org.junit.Test;

public class ShortStringTest {

    @Test
    //测试当文档长度过短时的情况
    public void shortStringExceptionTest(){
        System.out.println(SimHash.getSimHash("好爱看帅哥"));
    }

}
