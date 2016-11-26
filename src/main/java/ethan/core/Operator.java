package ethan.core;

import ethan.algo.*;

/**
 * Created by minxfeng on 2016/11/27.
 */
public class Operator {
    ICompress compressor = null;
    IDecompress decompressor = null;

    public Operator(CompressAlgo algo) {
        switch (algo) {
            case ZIP:
                compressor = new ZipCompressor();
                decompressor = new ZipDecompress();
                break;
            case GZIP:
                compressor = new GzipCompressor();
                decompressor = new GzipDecompressor();
                break;
            default:
                break;
        }
    }

    public byte[] compress(String str) {
        return compressor.compress(str);
    }

    public String decompress(byte[] buf) {
        return decompressor.decompress(buf);
    }

}
