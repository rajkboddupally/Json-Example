

/* Raj Kumar Boddupally created on 8/2/2021 inside the package - json */

import lombok.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Format {
    public static void main(String[] args) throws IOException {
        int[] scores = {12, 3, 123, 456, 232};
        Player player = new Player("virat", "cricket", 32, 123, scores);
        ObjectMapper om = new ObjectMapper();
        //print as string
        System.out.println(om.writeValueAsString(player));

        //pretty format
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(player));
    }


}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
class Player {
    private String name;
    private String sport;
    private int age;
    private int id;
    private int[] lastScores;
}
