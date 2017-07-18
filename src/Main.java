import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Spider crawler = new Spider();
        try {
            Category categories[] = {new Category("11450", "Clothing & Accessories"),
                                        new Category("220", "Toys"),
                                        new Category("940", "Lines & Textiles"),
                                        new Category("293", "Electronics"),
                                        new Category("267", "Books"),
                                        new Category("15032", "Cellphones & Accessories"),
                                        new Category("1", "Collectibles"),
                                        new Category("237", "Dolls & Bears"),
                                        new Category("260", "Stamps"),
                                        new Category("26395", "Health and Beauty"),
                                        new Category("11700", "Home & Garden"),
                                        new Category("281", "Jewelry & Watches"),
                                        new Category("619", "Musical Instruments and Gear"),
                                        new Category("870", "Pottery & Glass"),
                                        new Category("888", "Sporting Goods"),
                                        new Category("3252", "Travel"),
                                        new Category("172008", "Gift Cards & Coupons"),
                                        new Category("99", "Everything else")};


            System.out.println("Choose category number to search in: \n");

            int index = 0;
            for (Category category : categories) {
                System.out.println((index + 1) + ". " + category.getCategory());
                index++;
            }

            System.out.println();
            Scanner reader = new Scanner(System.in);
            index = reader.nextInt() - 1;
            System.out.println();
            //System.out.println(categories[index].getCategory() + ", " + categories[index].getCategoryNumber());

            System.out.print("Choose number of pages to search: ");
            int numPages = reader.nextInt();
            System.out.println();

            crawler.crawl("http://www.ebay.com/sch/i.html?_nkw=&_in_kw=1&_ex_kw=&_sacat=" +
                    categories[index].getCategoryNumber() +
                    "&_udlo=&_udhi=&LH_BIN=1&_ftrt=901&_ftrv=1&_sabdlo=&_sabdhi=&_samilow=&_samihi=&_sadis=15" +
                    "&_stpos=&_sargn=-1%26saslc%3D1&_salic=1&_sop=15&_dmd=1&_ipg=50", numPages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
