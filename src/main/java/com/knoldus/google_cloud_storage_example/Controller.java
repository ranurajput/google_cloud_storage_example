/**
 * Google Cloud Storage Example in Spring Cloud GCP
 */
package com.knoldus.google_cloud_storage_example;
import com.google.api.client.util.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * The RestController allows to handle all REST APIs such as GET, POST, Delete, PUT requests.
 * REST Controller offers read and write actions on a Google Cloud Storage file
 * using Spring Resource Abstraction.
 */
@RestController
public class Controller {
    @Value("gs://${gcs-resource-test-bucket}/MyFile.txt")
    private Resource gcsFile;

    /**
     * @GetMapping for read the file i.e. MyFile.txt
     * @return gcs file
     * @throws IOException
     */
    @GetMapping("/")
    public String readGcsFile() throws IOException {
        return StreamUtils.copyToString(this.gcsFile.getInputStream(), Charset.defaultCharset()) + "\n";
    }

    /**
     * @PostMapping for writing data
     * @param data string type data for writing in the file
     * @return updated file
     * @throws IOException
     */
    @PostMapping("/")
    public String writeGcsFile(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) this.gcsFile).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "file was updated\n";
    }
}
