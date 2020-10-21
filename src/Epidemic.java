import java.sql.SQLException;

public class Epidemic {
    public int id;
    public String title, dateRange, location, disease, deathToll;

    public Epidemic(String title, String dateRange, String location, String disease, String deathToll) {
        this.title = title;
        this.dateRange = dateRange;
        this.location = location;
        this.disease = disease;
        this.deathToll = deathToll;
        try {
            int id = DBUtility.insertNewEpidemic(this);
            setId(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDeathToll() {
        return deathToll;
    }

    public void setDeathToll(String deathToll) {
        this.deathToll = deathToll;
    }
}
