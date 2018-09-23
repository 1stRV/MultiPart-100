package hello;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class GreetingController {
  private String UPLOAD_DIR = "/Users/Roman/IdeaProjects/ExampleProject/complete/src/UploadDir/";

  @PostMapping("/upload")
  public void importFile(@RequestParam("file") MultipartFile file) throws IOException {
    byte[] bytes = file.getBytes();
    Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
    Files.write(path, bytes);
  }
}
