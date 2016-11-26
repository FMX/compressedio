package ethan.core;

import ethan.algo.CompressAlgo;

/**
 * Created by minxfeng on 2016/11/27.
 */
public class CompressorFactory {
    public static Operator getSpecAlgo(CompressAlgo algo){
        return new Operator(algo);
    }
}
