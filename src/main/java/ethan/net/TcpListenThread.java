package ethan.net;

import ethan.algo.CompressAlgo;
import ethan.core.CompressorFactory;
import ethan.core.Operator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by minxfeng on 2016/11/27.
 */
public class TcpListenThread implements Runnable {

    ServerSocket serverSocket = null;

    public TcpListenThread(ServerSocket server) {
        serverSocket = server;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                Operator opt = CompressorFactory.getSpecAlgo(CompressAlgo.ZIP);

            } catch (IOException e) {
                System.out.println("Accept socket failed!");
                e.printStackTrace();
            }

        }
    }
}
