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

    public Item getItem(String site){
        return new Item();
    }

    public Document getNextSite(String currentSite) throws IOException {
        Connection connection = Jsoup.connect(currentSite);
        Document htmlDocument = connection.get();
        return htmlDocument;
    }

}
