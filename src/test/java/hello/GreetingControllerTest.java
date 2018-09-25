package hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class GreetingControllerTest {
  @Test
  public void importFile() throws IOException {
    String DIR = "/Users/Roman/IdeaProjects/project85/12MultiPart/src/test/resources/dictionary.txt";
    Path path = Paths.get(DIR);
    byte[] temp = Files.readAllBytes(path);
    MockMultipartFile file = new MockMultipartFile("dictionary", "dictionary.txt", MediaType.TEXT_PLAIN_VALUE, temp);
    GreetingController greetingController = new GreetingController();
    List<String> testList = new ArrayList<>();
    testList.add("bob");
//    Assertions.assertThat(greetingController.importFile(file)).isEqualTo(testList);
  }

  @Test
  public void exportDictionary() throws IOException {
    GreetingController greetingController = new GreetingController();
    greetingController.exportFile("dictionary", "txt");
    String DIR = "/Users/Roman/IdeaProjects/project85/12MultiPart/src/test/resources/";
    Path path = Paths.get(DIR + "dictionary.txt");
    byte[] temp = Files.readAllBytes(path);
    String value = new String(temp);
    Assertions.assertThat(value.trim()).isEqualTo("bob");
  }
}