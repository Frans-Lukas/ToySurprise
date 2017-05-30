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
        String price = doc.select(".notranslate").text();
        StringBuilder sb = new StringBuilder(price);
        System.out.println("name " + name);
        System.out.println("price  " + price);
        return new Item(name, 0, 0, 0);
    }

    public Document getNextSite(String currentSite) throws IOException {
        Connection connection = Jsoup.connect(currentSite);
        Document htmlDocument = connection.get();
        return htmlDocument;
    }

}
