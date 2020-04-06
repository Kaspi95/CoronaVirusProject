package main.Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataBase {

    public String url;
    Connection connection = null;

    public interface Method {
        public void method(PreparedStatement stmt) throws SQLException;
    }

    private void executeUpdate(Method method, String sql) {
        try {
            // create a database connection, if there is no one yet, it will create one
            connection = DriverManager.getConnection(url);
            PreparedStatement stmt = connection.prepareStatement(sql);
            method.method(stmt);
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

    //----executeUpdate

    public DataBase(String filePath) {
        this.url = "jdbc:sqlite:" + filePath;
        class Preparator implements Method {
            @Override
            public void method(PreparedStatement stmt) throws SQLException {
            }
        }

        executeUpdate(new Preparator(), "CREATE TABLE IF NOT EXISTS familyTree (\n"
                + "    id text PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    birthDate DATE,\n"
                + "    deathDate DATE,\n"
                + "    birthPlace text,\n"
                + "    deathPlace text,\n"
                + "    parentID1 text,\n"
                + "    parentID2 text\n"
                + ");");
    }

    public void addNewPerson(Person person) {
        class Preparator implements Method {
            @Override
            public void method(PreparedStatement stmt) throws SQLException {
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
            }
        }
        executeUpdate(new Preparator(), "INSERT INTO familyTree(id,name,birthDate,deathDate,birthPlace,deathPlace,parentID1,parentID2) VALUES(?,?,?,?,?,?,?,?)");
    }

    public void modifyPeople(String conditionColumn, String conditionValue, String updateColumn, String updateValue) {
        //TODO a modifyPerson() alapján kibővíteni
    }

    /**
     * @param conditionValue
     * @param updateColumn   Should not be set by user!
     * @param updateValue
     */
    public void modifyPerson(String conditionValue, String updateColumn, String updateValue) {
        //There is no possibility of using a dynamic updateColumn name in jdbc
        class Preparator implements Method {
            @Override
            public void method(PreparedStatement stmt) throws SQLException {
                stmt.setString(1, updateValue);
                stmt.setString(2, conditionValue);
            }
        }
        executeUpdate(new Preparator(), "UPDATE familyTree SET " + updateColumn + " = ? WHERE id = ?");
    }

    public void modifyPerson(String conditionValue, String updateColumn, LocalDate updateValue) {

        class Preparator implements Method {
            @Override
            public void method(PreparedStatement stmt) throws SQLException {
                if (updateValue != null)
                    stmt.setDate(1, Date.valueOf(updateValue));
                else
                    stmt.setNull(1, Types.DATE);
                stmt.setString(2, conditionValue);
            }
        }

        executeUpdate(new Preparator(), "UPDATE familyTree SET " + updateColumn + " = ? WHERE id = ?");
    }

    //----executeQuery

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


    public void delete() {
    }

    public void dropTable() {
    }
}