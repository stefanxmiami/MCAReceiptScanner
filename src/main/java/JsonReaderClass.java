import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;


public class JsonReaderClass {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, JSONException {
        Total total = new Total();
        
        //Url for the json array
        String url = "https://interview-task-api.mca.dev/qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1";

        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            final ObjectMapper objectMapper = new ObjectMapper();
            Item[] items = objectMapper.readValue(jsonText, Item[].class);
            List<Item> itemList = new ArrayList<>(Arrays.asList(items));

            //Sort the list Alphabetically
            itemList = itemList.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());

            //Iterate through the list
            System.out.println(".Domestic");
            for (Item item : itemList) {
                if (item.getDomestic()) {
                    printItem(item);
                    total.addDomesticCost(item.getPrice());
                    total.addDomesticCount();
                }
            }
            System.out.println(".Imported");
            for (Item item : itemList) {
                if (!item.getDomestic()) {
                    printItem(item);
                    total.addImportedCost(item.getPrice());
                    total.addImportedCount();
                }
            }
            total.printTotal();
        }
    }

    public static void printItem(Item item) {
        System.out.println("..." + item.getName());
        System.out.println("   Price: $" + item.getPrice());

        //If the description is longer than 10 characters, it gets truncated
        if(item.getDescription().length() > 10){
            System.out.println("   " + item.getDescription().substring(0, 10) + "...");
        } else {
            System.out.println("   " + item.getDescription());
        }

        //If there's no available weight for the product, print N/A instead
        if (item.getWeight() == null) {
            System.out.println("   Weight: N/A");
        } else {
            System.out.println("   Weight: " + item.getWeight());
        }
    }


}