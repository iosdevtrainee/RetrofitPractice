package pursuit.iosdevtrainee.com.retrofitpractice.models;

public class Company {
    private String ticker;
//    private String id;
    private String name;


    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() { return ticker; }

//    public String getId() {
//        return id;
//    }

    public String getName() { return name; }
}
