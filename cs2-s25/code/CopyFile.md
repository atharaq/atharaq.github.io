# CopyFile

This goes in a file CopyFile.java:

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyFile {
    private static final String FILENAME = "java.jpeg";
    private static final String OUTPUT_FILE = "src/output.jpeg";

    public static void main(String[] args) {
        InputStream stream = null;
        FileOutputStream out = null;

        try {
            stream = CopyFile.class.getResourceAsStream(FILENAME);
            out = new FileOutputStream(OUTPUT_FILE);

            int read;

            while ( (read = stream.read()) != -1) {
                out.write(read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

You will also need the [java image](java.jpeg).