import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final String USERNAME = "scott";
    private static final String PASSWORD = "tiger";
    private static final String HOST = "localhost"; // Host
    private static final String PORT = "1521"; // Default port
    private static final String SID = System.getenv("ORACLE_SID"); // Oracle SID


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Please choose one Question(1-10,Input 'Q' quit):");
            String line = sc.nextLine().trim();
            if (line.toUpperCase().equals("Q")){
                break;
            }
            switch (line) {
                case "1": {
                    Q1();
                    break;
                }
                case "2": {
                    Q2();
                    break;
                }
                case "3": {
                    Q3();
                    break;
                }
                case "4": {
                    Q4();
                    break;
                }
                case "5": {
                    Q5();
                    break;
                }
                case "6": {
                    Q6();
                    break;
                }
                case "7": {
                    Q7();
                    break;
                }
                case "8": {
                    Q8();
                    break;
                }
                case "9": {
                    Q9();
                    break;
                }
                case "10": {
                    Q10();
                    break;
                }
            }
        }
    }

    public static void Q1() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select *\n" +
                "from item");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "itemID", "name", "type", "payment", "Renewtimes", "borrowtime", "Amount", "Fine"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData  = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i+1)+"\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q2() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select p.*\n" +
                "from borrow b\n" +
                "left join patrons p\n" +
                "on p.libraryCardID = b.libraryCardID\n" +
                "where TrueReturnDate = null\n" +
                "and ExpReturnDate > sysdate");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "LibrarycardID", "PatronAdderss", "Name", "phoneNumber", "ExpDate"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData  = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i+1)+"\t";
            }
            System.out.println(lineData);
        }




    }

    public static void Q3() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select b.libraryCardID,sum(cost) as sum\n" +
                "from borrow b, patrons p\n" +
                "where p.libraryCardID = b.libraryCardID\n" +
                "and b.checks = 0\n" +
                "group by b.libraryCardID");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "libraryCardID", "sum"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q4() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select b.libraryCardID,b.cost_Detail,b.cost\n" +
                "from borrow b, patrons p\n" +
                "where p.libraryCardID = b.libraryCardID\n" +
                "and b.checks = 1");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "libraryCardID", "cost_Detail","cost"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q5() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select i.*\n" +
                "from borrow b,item i\n" +
                "where i.itemid = b.itemid\n" +
                "and TrueReturnDate = null\n" +
                "and ExpReturnDate > sysdate");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "itemID", "name", "type", "payment", "Renewtimes", "borrowtime", "Amount", "Fine"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q6() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select *\n" +
                "from request\n" +
                "where checks = 0");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "RequestID", "itemid", "LibrarycardID", "RequestDetail", "checks"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q7() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select sum(cost) as sum\n" +
                "from borrow b\n" +
                "where b.checks = 1\n" +
                "and b.TrueReturnDate > to_date('2012-03-01','yyyy-mm-dd')\n" +
                "and b.TrueReturnDate < to_date('2012-03-21','yyyy-mm-dd')");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "sum"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q8() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select itemid,renewtimes,borrowtime\n" +
                "from item ");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "itemid", "renewtimes", "borrowtime"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q9() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("select i.itemid,i.name,count(*) as borrowsum,sum(b.renewtimes) as renewsum\n" +
                "from borrow b,item i\n" +
                "where b.itemid = i.itemid\n" +
                "group by i.itemid,i.name");

        // Cursor
        ResultSet rs = psmt.executeQuery();

        System.out.println("\n\nthe number of copies of a particular library item are--");
        String tiles[] = {
                "itemid", "name", "borrowsum","renewsum"
        };
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < tiles.length; i++) {
            line1 += tiles[i] + "\t";
            line2 += "------\t";
        }
        System.out.println(line1);
        System.out.println(line2);

        // Use the cursor like a normal ResultSet
        while (rs.next()) {
            String lineData = "";
            for (int i = 0; i < tiles.length; i++) {
                lineData += rs.getString(i + 1) + "\t";
            }
            System.out.println(lineData);
        }
    }

    public static void Q10() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(USERNAME);
        ods.setPassword(PASSWORD);
        ods.setURL("jdbc:oracle:thin:" + "@" + HOST
                + ":" + PORT
                + ":" + SID);

        Connection conn = ods.getConnection();

        // Statement
        PreparedStatement psmt;
        ResultSet cursor;

        psmt = conn.prepareStatement("insert into request(RequestID,itemid,LibrarycardID,RequestDetail,checks)\n" +
                "values(5, 1, 1, 'Can I buy this book',0)");

        // Cursor
        int count = psmt.executeUpdate();
        System.out.println("update "+ count+" data");



    }


}
