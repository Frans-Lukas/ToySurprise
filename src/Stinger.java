import java.util.ArrayList;
import java.util.List;

/**
 * Created by c16fld on 2017-05-30.
 */
public class Stinger {
    private List<Item> items;
    private int moneyLeft;
    private List<Item> itemsBought = new ArrayList<>();

    public Stinger(List<Item> items, int moneyLeft){
        this.items = items;
        this.moneyLeft = moneyLeft;
    }

    public void makePurchase(){

        int index = 0;
        boolean purchased = false;

        while(!purchased && index < items.size()){
            String currentItemName = items.get(index).getName();

            boolean canBuy = true;

            for (Item item : itemsBought) {
                if(currentItemName.equals(item.getName())){
                    canBuy = false;
                }
            }

            Item itemToBuy = items.get(index);

            if(itemToBuy.getPrice() > moneyLeft){
                canBuy = false;
                System.out.println("Can't afford more items!");
            }

            if(canBuy){
                itemsBought.add(itemToBuy);
                moneyLeft = moneyLeft - itemToBuy.getPrice();
                purchased = true;
            }

            index++;
        }
        if(itemsBought.size() > 0) {
            System.out.println();
            System.out.println("Purchased item: " + itemsBought.get(itemsBought.size() - 1).getName());
            System.out.println("Money left: " + moneyLeft);
        }
    }

}
