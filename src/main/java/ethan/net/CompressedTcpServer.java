package ethan.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by minxfeng on 2016/11/27.
 */
public class CompressedTcpServer {
    private int port;
    private ServerSocket serverSocket = null;


    public CompressedTcpServer(int localport) {
        this.port = localport;
        try {
            serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startListening() {
        Thread thread = new Thread(new TcpListenThread(this.serverSocket));
        thread.start();
    }

}
