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



        String qtyInfo[] = doc.select(".qtyTxt").text().split(" ");
        int numSold;

        numSold = findNumSold(qtyInfo);



        int price = findfloatInString(priceInfo);
        if(price == 0){
            throw new IOException("Price not found in string: " + priceInfo);
        }
        //Remove first two words, i.e. "Details about" string
        name = name.split(" ", 3)[2];


        /*System.out.println("num sold: " + numSold);
        System.out.println("name: " + name);
        System.out.println("price:  " + price + " dolla!"); */

        //String name, int price, int rating
        return new Item(name, price, numSold);
    }

    public Integer findfloatInString(String s){
        int f = 0;
        for (String word : s.split(" ")) {
            if(word.toCharArray()[0] == '$'){
                word = word.substring(1, word.length());
                try{

                    f = (int) Math.ceil(Float.parseFloat(word));

                    break;
                } catch(NumberFormatException e){

                }
            }

        }

        return f;
    }

    public Integer findNumSold(String words[]){
        int numSold = 0;
        boolean firstInt = false;
        for (String word : words) {
            if(isNumber(word) && !firstInt) {
                firstInt = true;
            } else if(isNumber(word)){
                numSold = Integer.parseInt(word);
            }
        }
        return numSold;
    }
    
    public boolean isNumber(String s){
        boolean isNumber = true;
        for (char c : s.toCharArray()) {
            if(!Character.isDigit(c)){
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }


    public Document getNextSite(String currentSite) throws IOException {
        Connection connection = Jsoup.connect(currentSite);
        Document htmlDocument = connection.get();
        return htmlDocument;
    }

}
