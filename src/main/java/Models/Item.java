package Models;

/**
 * Created with IntelliJ IDEA.
 * User: meghaagr
 * Date: 5/4/17
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    int id;
    String name;
    String quality;
    Double price;

    public Item(String name, String quality, Double price) {
        this.name = name;
        this.quality = quality;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

    public Double getPrice() {
        return price;
    }
}
