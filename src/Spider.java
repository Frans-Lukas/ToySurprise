import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Created by c16fld on 2017-05-30.
 */
public class Spider {
    private Set<String> visitedSites = new HashSet<>();
    private List<String> sites = new ArrayList<>();
    private ArrayList<Item> itemsToBuy = new ArrayList<>();


    public void crawl(String startSite) throws IOException {
        Leg leg = new Leg();
        Document currentDocument = leg.getNextSite(startSite);
        Elements items = currentDocument.getElementsByClass("vip");
        for (Element item : items) {
            sites.add(item.attr("abs:href"));
        }


        for (String site : sites) {
            itemsToBuy.add(leg.getItem(site));
        }
        itemsToBuy.sort(Item.ItemComparator);

        //Find current site

        //Find all items
        //Sort them by ratings and if affordable.
        //Choose item to buy.
        //buy item.
    }



}
