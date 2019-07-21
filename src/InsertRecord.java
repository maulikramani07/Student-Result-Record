import java.sql.*;

public class InsertRecord {
    public static void main(String[] args){
         Connection con = null;
         PreparedStatement pst = null;
        
        
        String database = "jdbc:mysql://jdbcassignment.cetn2jthwfls.us-east-1.rds.amazonaws.com/demo";
        String user = "root";
        String password = "abcd1234";
        
        try{
            con = DriverManager.getConnection(database,user,password);
            System.out.println("Connection Successful");
            
           con.setAutoCommit(false);
           pst = con.prepareStatement("INSERT INTO `17IT093`(`SGPA`, `CGPA`, `class`) VALUES (?,?,?)");
           pst.setDouble(1,8.96);
           pst.setDouble(2,8.86);
           pst.setString(3,"DIST");
           
           pst.execute();    
           con.commit(); 
            
        }catch(Exception e){
            System.out.println("Exception Occur");
            System.out.println(e.getMessage());
        }
    }
}
