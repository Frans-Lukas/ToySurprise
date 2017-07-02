import java.util.Comparator;

/**
 * Created by c16fld on 2017-05-30.
 */
public class Item {
    private String name;
    private int price;
    private int rating;
    private int address;

    public Item(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getAddress() {
        return address;
    }

    public int compareTo(Item i){
        int compareRating = i.getRating();
        return compareRating - this.rating;
    }


    public static Comparator<Item> ItemComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.compareTo(o2);
        }
    };




}
