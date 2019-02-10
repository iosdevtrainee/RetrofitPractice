package pursuit.iosdevtrainee.com.retrofitpractice.models;

import java.util.ArrayList;

public class PriceData {
    private ArrayList<AssetPrice> stock_prices;

    public ArrayList<AssetPrice> getStock_prices() {
        return stock_prices;
    }

    public void setStock_prices(ArrayList<AssetPrice> stock_prices) {
        this.stock_prices = stock_prices;
    }
}
