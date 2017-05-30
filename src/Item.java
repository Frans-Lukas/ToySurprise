/**
 * Created by c16fld on 2017-05-30.
 */
public class Item {
    private String name;
    private int price;
    private int rating;
    private int address;

    public Item(String name, int price, int rating, int address) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.address = address;
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
}
