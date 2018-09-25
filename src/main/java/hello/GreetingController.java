package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;
//import Multipart

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GreetingController {
  private String DIR = "/Users/Roman/IdeaProjects/project85/12MultiPart/src/test/resources/";

  @PostMapping("/upload")
  public String importFile(@RequestParam("file") MultipartFile file) throws IOException {

      String dsd;
      try {
//        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
//        String strLine;
//        while ((strLine = br.readLine()) != null) {
//          words.add(strLine);
//        }
        byte[] temp = file.getBytes();
         dsd = new String(temp);

      } catch (IOException e) {
        log.error("Не удалось прочитать файл");
        throw new IOException("Не удалось прочитать файл");
      }
      return dsd;
    }


  @GetMapping("/download")
  public void exportFile(@RequestParam("fileName")String fileName, @RequestParam("fileType")String fileType) throws IOException {
    List<String> words = new ArrayList<>();
    words.add("bob");
    Path path = Paths.get(DIR + fileName + "." + fileType);
    Files.write(path, words);
  }
}
