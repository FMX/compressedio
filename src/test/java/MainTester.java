import ethan.algo.CompressAlgo;
import ethan.algo.ZipCompressor;
import ethan.algo.ZipDecompress;
import ethan.core.CompressorFactory;
import ethan.core.Operator;
import junit.framework.TestCase;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

/**
 * Created by minxfeng on 2016/11/26.
 */
public class MainTester extends TestCase {
    public String testBuf = null;
    DecimalFormat formatter = new DecimalFormat("0.00");

    @Override
    protected void setUp() throws Exception {
        testBuf = RandomStringUtils.randomAlphabetic(8000);
    }

    @Override
    protected void tearDown() throws Exception {

    }

    @Test
    public void testRun1() {
        ZipCompressor compress = new ZipCompressor();

        String strbuf = RandomStringUtils.randomAlphabetic(50000);

        byte[] buf = compress.compress(strbuf);

//        if (buf != null)
//            System.out.println(new String(buf));
        int len1, len2;
        len1 = buf.length;
        len2 = strbuf.getBytes().length;

        System.out.println("Start Running test1====================");

        System.out.println("String length:" + strbuf.length());
        System.out.println("String 1:" + len1);
        System.out.println("String 2:" + len2);

        System.out.println("compress ratio:" + formatter.format((double) len1 / len2 * 100) + "%");
        ZipDecompress decompress = new ZipDecompress();
        String out = decompress.decompress(buf);

        System.out.println("Finish Running test1==================");

    }

    @Test
    public void testRun2() {
        System.out.println("Start Running test2====================");
        Operator opt = CompressorFactory.getSpecAlgo(CompressAlgo.GZIP);
        System.out.println("String length:" + testBuf.length());
        int len1, len2;
        byte[] buf = opt.compress(testBuf);
        len1 = buf.length;
        len2 = testBuf.getBytes().length;
        System.out.println("compressed length:" + len1);
        System.out.println("original length:" + len2);
        System.out.println("compress ratio : " + formatter.format((double) len1 / len2 * 100) + "%");
        System.out.println();
        try {
            String buf1 = new String(buf, "utf-8");
            int len3 = buf1.length();
            System.out.println("compressed length:" + len3);
            System.out.println("Convert into compress ratio :" + formatter.format((double) len3 / testBuf.length() * 100) + "%");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Finish Running test2==================");
    }


    @Test
    public void testRun3() {
//        fail();

    }
}
