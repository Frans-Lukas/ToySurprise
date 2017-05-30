import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Spider crawler = new Spider();
        try {
            crawler.crawl("http://www.ebay.com/sch/i.html?_nkw=&_in_kw=1&_ex_kw=&_sacat=220&_udlo=&_udhi=&LH_BIN=1&_ftrt=901&_ftrv=1&_sabdlo=&_sabdhi=&_samilow=&_samihi=&_sadis=15&_stpos=&_sargn=-1%26saslc%3D1&_salic=1&_sop=15&_dmd=1&_ipg=50");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
