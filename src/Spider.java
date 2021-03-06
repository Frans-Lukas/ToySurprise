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
    private List<Item> itemsToBuy = new ArrayList<>();


    public void crawl(String startSite, int numPages) throws IOException {
        Leg leg = new Leg();


        //TODO: Find "next" page address and iterate numPages times


        Document currentDocument = leg.getNextSite(startSite);

        for (int i = 0; i < numPages; i++) {


            Elements items = currentDocument.getElementsByClass("vip");

            for (Element item : items) {
                sites.add(item.attr("abs:href"));
            }

            System.out.println("number of items found: " + sites.size());

            currentDocument = leg.getNextSite(
                    currentDocument.getElementsByClass("pagn-next").first().select("a").first().attr("abs:href"));

        }
        int numDone = 0;
        for (String site : sites) {
            itemsToBuy.add(leg.getItem(site));
            numDone++;
            System.out.println("NumDone: " + numDone);
        }

        itemsToBuy.sort(Item.ItemComparator);

        /*for (Item item : itemsToBuy) {
            System.out.println(item.getName());
        }*/

        //TODO: Send list to stinger, to make purchase.
        Stinger stinger = new Stinger(itemsToBuy, 10);
        stinger.makePurchase();
        stinger.makePurchase();
        stinger.makePurchase();
        stinger.makePurchase();



        //Find current site

        //Find all items
        //Sort them by ratings and if affordable.
        //Choose item to buy.
        //buy item.
    }



}
