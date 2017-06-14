import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c16fld on 2017-05-30.
 */
public class Leg {

    private List<Item> items = new ArrayList<>();

    public Item getItem(String site) throws IOException {
        Document doc = getNextSite(site);
        String name = doc.select("h1").text();
        String priceInfo = doc.select(".notranslate").text();

        //TODO: Search for integer desicribing price.
        String priceString = priceInfo.split(" ")[1].substring(1);
        float priceInteger = Float.parseFloat(priceString);

        System.out.println("name: " + name);
        System.out.println("price:  " + priceInteger);

        return new Item(name, 0, 0, 0);
    }

    public Document getNextSite(String currentSite) throws IOException {
        Connection connection = Jsoup.connect(currentSite);
        Document htmlDocument = connection.get();
        return htmlDocument;
    }

}
