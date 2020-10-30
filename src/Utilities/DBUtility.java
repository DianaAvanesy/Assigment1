package Utilities;

import Models.Epidemic;

import java.sql.*;

public class DBUtility {
    private static String user="root";
    private static String password = "a368G2Gvnl6LI8N975aZFYG";

    /**
     * Function that prints to the console list of all epidemics from the database
     * @prints All of the epidemics
     */
    public static void getAllEpidemics(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assigment", user, password);
            String sql = "SELECT * FROM epidemics2";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

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
                String deathTollEstimate = rs.getString("DeathTollEstimate");

                // print the results
                System.out.println( id + "  "+  name );
                System.out.println( "     Location: "+ location);
                System.out.println( "     Death Toll: "+ deathTollEstimate);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    /**
     * Adds Models.Epidemic to the database
     * @param newEpidemic
     * @return id
     */
    public static int insertNewEpidemic(Epidemic newEpidemic) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int epidemicId = -1;

        try{
            //connect to the DB
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys",user,password);
            // create SQL String
            String sql = "INSERT INTO epidemics (EventName, DateRange, Location, Disease, DeathTollEstimate) VALUES (?,?,?,?,?)";
            // prepare the query
            ps = conn.prepareStatement(sql, new String[] {"id"});
            // bind values
            ps.setString(1, newEpidemic.getTitle());
            ps.setString(2, newEpidemic.getDateRange());
            ps.setString(3, newEpidemic.getLocation());
            ps.setString(4, newEpidemic.getDisease());
            ps.setString(5, newEpidemic.getDeathToll());
            // execute
            ps.executeUpdate();
            // get Id returned
            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()){
                epidemicId = rs.getInt(1);
            }


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                conn.close();}
            if(ps != null){
                ps.close();
            }
            return epidemicId;
        }

    }
}
