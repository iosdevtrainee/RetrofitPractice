package pursuit.iosdevtrainee.com.retrofitpractice.models;

public class CompanyDetail {
    private String ticker;
    private String name;
    private String short_description;
    private String long_description;

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getTicker() {

        return ticker;
    }

    public String getName() {
        return name;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getLong_description() {
        return long_description;
    }
}
