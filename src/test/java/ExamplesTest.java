
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExamplesTest {
    private HttpResponse<String> getResponse(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest getRequest = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            return client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test1() {
        HttpResponse<String> response = getResponse("https://rickandmortyapi.com/api/character/40");
        System.out.println(response.body());
        System.out.println(response.statusCode());

        //  client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void test2() throws IOException, InterruptedException {

        HttpResponse<String> response = getResponse("https://rickandmortyapi.com/api/character/76543");
        System.out.println(response.body());
        System.out.println(response.statusCode());

        Assertions.assertEquals(404, response.statusCode());
    }

    @Test
    public void contentTestWithJson() throws IOException {

        final String expected = Files.readString(Path.of("src/test/resources/expectedCharacter.json"));
        HttpResponse response = getResponse("https://rickandmortyapi.com/api/character/40");
        System.out.println(response.body());
        System.out.println("____________________");
        System.out.println(expected);
        System.out.println("____________________");
        Assertions.assertEquals(expected, response.body());
    }

    @Test
    public void contentTestWithObject() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        HttpResponse<String> response = getResponse("https://rickandmortyapi.com/api/character/40");
        Character actual = objectMapper.readValue(response.body(), Character.class);
        System.out.println("to string: " + actual.toString());
//        Character expected = createBethMytholog();
//        Assertions.assertEquals(expected, actual);
    }

    static Character createBethMytholog() {

        return Character.builder()
                .id(40)
                .name("Beth's Mytholog")
                .status("Dead")
                .species("Mythological Creature")
                .type("Mytholog")
                .gender("Female")
                .build();
    }
}
