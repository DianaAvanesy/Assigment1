package Models;

public class Epidemic {
    private int id,deathToll, startDate;
    private String title, location, disease,dateRange;

    public Epidemic(String title, String dateRange,int startDate ,String location, String disease, int deathToll) {
        setTitle(title);
        setDateRange(dateRange);
        setStartDate(startDate);
        setLocation(location);
        setDisease(disease);
        setDeathToll(deathToll);
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartDate() {
        return startDate;
    }

    /**
     * Sets the Start Date if its between 50 and 2020
     * @param startDate
     * @trows IllegalArgumentException
     */
    public void setStartDate(int startDate) {
        if(startDate>50 && startDate<=2020 ) {
            this.startDate = startDate;
        }
        else
            throw new IllegalArgumentException("Start day should be in 50-2020 range. Not: " + startDate);
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

    /**
     * Method sets the DateRange with the String value. Because of the many formats dateRange represented in the original data set this field just for the table representation of the range.
     * @param dateRange
     */
    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
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

    public int getDeathToll() {
        return deathToll;
    }

    /**
     * Method sets deathToll if the number >0, otherwise thows IllegalArgumentException
     * @param deathToll
     * @throws IllegalArgumentException
     */
    public void setDeathToll(int deathToll) {
        if(deathToll>0) {
            this.deathToll = deathToll;
        }
        else
            throw new IllegalArgumentException("Start day should be more then 0. Not: " + deathToll);
    }
}
