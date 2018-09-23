package hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
private String UPLOAD_DIR = "/Users/Roman/IdeaProjects/ExampleProject/complete/src/UploadDir/";
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    @RequestMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
saveUploadFiles(file);
    }
    private void saveUploadFiles(MultipartFile file) throws IOException{
byte[] bytes = file.getBytes();
Path path = Paths.get(UPLOAD_DIR+"_WE_UPLOADED_THIS_"+file.getOriginalFilename());
        Files.write(path, bytes);
    }
}
