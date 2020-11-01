package Models;

public class Epidemic {
    private int id;
    private String title, dateRange, location, disease, deathToll;

    public Epidemic(String title, String dateRange, String location, String disease, String deathToll) {
        setTitle(title);
        setDateRange(dateRange);
        setLocation(location);
        setDisease(disease);
        setDeathToll(deathToll);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateRange() {
        return dateRange;
    }

    // The date range might or might not be an integer.
    public void setDateRange(String dateRange) {

        this.dateRange = dateRange;

        // check if the date in the range of 400 - 2020
        //if(dateRange.matches("^([1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)$")){
            // set the date
         //   this.dateRange = dateRange;
        //}
        //else if (dateRange.matches("^([4-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)-([4-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)")){
            //get the number
        //}
        //else{
            //just ignore
        //}
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDeathToll() {
        return deathToll;
    }

    public void setDeathToll(String deathToll) {
        this.deathToll = deathToll;
    }
}
