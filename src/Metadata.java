import java.sql.*;

public class Metadata {
    public static void main(String[] args) throws SQLException{
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String database = "jdbc:mysql://jdbcassignment.cetn2jthwfls.us-east-1.rds.amazonaws.com/demo";
        String user = "root";
        String password = "abcd1234";
        
        try{
            
            con = DriverManager.getConnection(database,user,password);
            System.out.println("Connection Successful");
            
            System.out.println("Vendor: " + con.getMetaData().getDatabaseProductName());
            
            String sql = "SELECT COUNT(`SemId`)  FROM `17IT093`";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            
            System.out.println("Number Of Rows :"+rs.getString(1));
            
            
        }catch(Exception e){
            System.out.println("Exception Occur");
            System.out.println(e.getMessage());
        }finally{
            if(con != null)
                con.close();
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
        }
    }
}
