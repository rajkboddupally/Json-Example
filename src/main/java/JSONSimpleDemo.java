/* Raj Kumar Boddupally created on 8/2/2021 inside the package - json */

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JSONSimpleDemo {
    public static void main(String[] args) throws IOException {
        writeJson("books.json");

        readJson("books.json");
    }

    private static void readJson(String file) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(file);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            String title = (String) jsonObject.get("title");
            String ISBN = (String) jsonObject.get("ISBN");
            System.out.println("title:" + title + "; ISBN:" + ISBN);
            JSONArray jsonArray = (JSONArray) jsonObject.get("chars");
            Iterator<String> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ",");
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeJson(String file) throws IOException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "Atlas");
        jsonObject.put("price", 20);
        jsonObject.put("ISBN", "123-456");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("One");
        jsonArray.add("two");
        jsonArray.add("three");

        jsonObject.put("chars", jsonArray);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject));

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.flush();
        fileWriter.close();

    }
}
