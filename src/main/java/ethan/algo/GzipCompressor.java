package ethan.algo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by minxfeng on 2016/11/27.
 */
public class GzipCompressor implements ICompress {
    @Override
    public byte[] compress(String strbuf) {
        if (strbuf == null)
            return null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        GZIPOutputStream zipOutputStream = null;
        byte[] arrayOfBytes = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
//            zipOutputStream.putNextEntry(new ZipEntry("default "));
            zipOutputStream.write(strbuf.getBytes());
//            zipOutputStream.closeEntry();
            zipOutputStream.finish();
            arrayOfBytes = byteArrayOutputStream.toByteArray();
        } catch (IOException exce) {
            arrayOfBytes = null;
        } finally {
            if (zipOutputStream != null)
                try {
                    zipOutputStream.close();
                } catch (IOException exce1) {
                }
            if (byteArrayOutputStream != null)
                try {
                    byteArrayOutputStream.close();
                } catch (IOException exce2) {
                }
        }


        return arrayOfBytes;
    }
}
