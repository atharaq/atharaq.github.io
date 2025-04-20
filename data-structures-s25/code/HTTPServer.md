# HTTP Server

```java
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting a local server");
        try (ServerSocket server  = new ServerSocket(8000)) {
            System.out.println("Listening on " + server.getInetAddress().getHostAddress());
            while (true) {
                try (Socket clientSocket = server.accept();
                     InputStream is = clientSocket.getInputStream();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());) {
                    handleResponse(is, out);
                } catch (IOException e) {
                    System.out.println("Except caught when trying to listen for a conn");
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 80"
                    + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static void handleResponse(InputStream is, PrintWriter out) throws IOException, InterruptedException {
        out.println("HTTP/1.1 200 OK\r");
        out.println("Content-Type: text/html");
        out.println("");
        out.println("<html><body><h1>What is happening?</h1></body></html>");
        byte[] input = new byte[is.available()];
        is.read(input);
        String message = new String(input);
        System.out.println(message);
        out.close();
        System.out.println("Done reading?");
        // simulates working for 5 seconds
        // until the next connection can be accepted.
        Thread.sleep(5000); 
    }
}
```