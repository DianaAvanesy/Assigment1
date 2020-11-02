package Utilities;

import Models.Epidemic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtility {
    private static String user="root";
    private static String password = "a368G2Gvnl6LI8N975aZFYG";

    /**
     * Function that returns list of all epidemics (as objects) from the database based on the query provided as a parameter
     * @return ObservableList<Epidemic>
     */
    public static ObservableList<Epidemic> getAllEpidemics(String query) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement  st = null;
        ResultSet rs = null;
        ObservableList<Epidemic> epidemics = FXCollections.observableArrayList();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assigment", user, password);
            String sql =  query;
             st = conn.createStatement();
             rs = st.executeQuery(sql);

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("EventName");
                String dateRange = rs.getString("DateRange");
                int startDate = rs.getInt("StartDate");
                String location = rs.getString("Location");
                String disease = rs.getString("Disease");
                int deathTollEstimate = rs.getInt("DeathTollEstimate");
                epidemics.add(new Epidemic(name,dateRange,startDate,location,disease,deathTollEstimate));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();
        }
        return epidemics;
    }



    /**
     * Function that prints to the console list of all epidemics from the database
     * @prints All of the epidemics
     */
    public static void printAllEpidemics() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement  st = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assigment", user, password);
            String sql = "SELECT * FROM epidemics2";
             st = conn.createStatement();
             rs = st.executeQuery(sql);

            System.out.println("|------------------------------------------------------------------|");
            System.out.println("|     This is the list of the worst epidemics known:               |");
            System.out.println("|------------------------------------------------------------------|");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("EventName");
                String dateRange = rs.getString("DateRange");
                String location = rs.getString("Location");
                String disease = rs.getString("Disease");
                int deathTollEstimate = rs.getInt("DeathTollEstimate");

                // print the results
                System.out.println( id + "  "+  name );
                System.out.println( "     Location: "+ location);
                System.out.println( "     Death Toll: "+ deathTollEstimate);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();

        }


    }

}
