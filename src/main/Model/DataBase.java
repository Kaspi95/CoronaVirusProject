package main.Model;

import java.sql.*;

public class DataBase {

    public String url;
    Connection connection = null;

    public DataBase(String filePath) {
        this.url = "jdbc:sqlite:" + filePath;
        try {
            // create a database connection, if there is no one yet, it will create one
            connection = DriverManager.getConnection(url);
            //create a table
            String sql = "CREATE TABLE IF NOT EXISTS familytree (\n"
                    + "    id text PRIMARY KEY,\n"
                    + "    name text NOT NULL,\n"
                    + "    birthDate DATE \n"
                    + "    deathDate DATE \n"
                    + "    birthPlace text \n"
                    + "    deathPlace text \n"
                    + "    parentID1 text \n"
                    + "    parentID2 text \n"
                    + ");";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();


        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public void addNewPerson(Person person) {
        person.getDetails();
        //System.out.println(Date.valueOf(person.getDeathDate()));
        String sql = "INSERT INTO familytree(id,name,birthDate,deathDate,birthPlace,deathPlace,parentID1,parentID2) VALUES(?,?,?,?,?,?,?,?)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getId());
            stmt.setString(2, person.getName());
            stmt.setDate(3, Date.valueOf(person.getBirthDate()));
            stmt.setDate(4, Date.valueOf(person.getDeathDate()));
            stmt.setString(5, person.getBirthPlace());
            stmt.setString(6, person.getDeathPlace());
            stmt.setString(7, person.getParentID1());
            stmt.setString(8, person.getParentID2());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public void printDataBase(){
        String sql="SELECT * FROM familytree";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDate("birthDate"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void select() {


    }

    public void delete() {
    }

    public void droptable() {
    }

}