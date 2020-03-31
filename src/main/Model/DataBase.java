package main.Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
                    + "    birthDate DATE,\n"
                    + "    deathDate DATE,\n"
                    + "    birthPlace text,\n"
                    + "    deathPlace text,\n"
                    + "    parentID1 text,\n"
                    + "    parentID2 text\n"
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
        //System.out.println(person.getDeathDate());
        //System.out.println(Date.valueOf(person.getDeathDate()));
        String sql = "INSERT INTO familytree(id,name,birthDate,deathDate,birthPlace,deathPlace,parentID1,parentID2) VALUES(?,?,?,?,?,?,?,?)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getId());
            stmt.setString(2, person.getName());
            stmt.setDate(3, Date.valueOf(person.getBirthDate()));
            if (person.getDeathDate() != null)
                stmt.setDate(4, Date.valueOf(person.getDeathDate()));
            else
                stmt.setNull(4, Types.DATE);
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

    public void printDataBase() {
        String sql = "SELECT * FROM familytree";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getDate("birthDate") + "\t" +
                                rs.getDate("deathDate") + "\t" +
                                rs.getString("birthPlace") + "\t" +
                                rs.getString("deathPlace") + "\t" +
                                rs.getString("parentID1") + "\t" +
                                rs.getString("parentID2"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Person selectPerson(String id) {

        String sql = "SELECT * FROM familyTree WHERE id=?";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Person temp = null;
            while (rs.next()) {
                temp = new Person(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthDate").toLocalDate(),
                        rs.getString("birthPlace"),
                        rs.getString("parentID1"),
                        rs.getString("parentID2"),
                        rs.getDate("deathDate") == null ? null : rs.getDate("deathDate").toLocalDate(),
                        rs.getString("deathPlace")
                );
            }
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
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

    public ArrayList<Person> selectChildren(String parentID) {
        String sql;
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt;
            if (parentID == null) {
                sql = "SELECT * FROM familyTree WHERE parentID1 IS NULL OR parentID2 IS NULL";
                stmt = connection.prepareStatement(sql);
            } else {
                sql = "SELECT * FROM familyTree WHERE parentID1=? OR parentID2=?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, parentID);
                stmt.setString(2, parentID);
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<Person> tempList = new ArrayList<Person>();
            while (rs.next()) {
                Person temp = new Person(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDate("birthDate").toLocalDate(),
                        rs.getString("birthPlace"),
                        rs.getString("parentID1"),
                        rs.getString("parentID2"),
                        rs.getDate("deathDate") == null ? null : rs.getDate("deathDate").toLocalDate(),
                        rs.getString("deathPlace")
                );
                tempList.add(temp);
            }
            return tempList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
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

    /**
     * @param id
     * @param column Should not be set by user!
     * @param value
     */
    public void modifyPerson(String id, String column, String value) {
        //There is no possibility of using a dynamic column name in jdbc
        String sql = "UPDATE familyTree SET " + column + " = ? WHERE id = ?";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, value);
            stmt.setString(2, id);
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

    public void modifyPerson(String id, String column, LocalDate value) {
        String sql = "UPDATE familyTree SET " + column + " = ? WHERE id = ?";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            if (value != null)
                stmt.setDate(1, Date.valueOf(value));
            else
                stmt.setNull(4, Types.DATE);
            stmt.setString(2, id);
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

    public void delete() {
    }

    public void droptable() {
    }

}