import java.io.*;
import java.sql.*;


public class InsertMarksheet {
    public static void main(String[] args) throws IOException,SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        FileInputStream image = null;
        
        String database = "jdbc:mysql://jdbcassignment.cetn2jthwfls.us-east-1.rds.amazonaws.com/demo";
        String user = "root";
        String password = "abcd1234";
        
        try{
            
            con = DriverManager.getConnection(database,user,password);
            System.out.println("Connection Successful");
            
            pst = con.prepareStatement("UPDATE `17IT093` set marksheet=? where SemId = 4"); //change semid
            
            File result = new File("sem4.png"); //change image name
            image = new FileInputStream(result);
            pst.setBinaryStream(1, image);
            
            System.out.println("Reading input file: " + result.getAbsolutePath());
             pst.executeUpdate();
            
            System.out.println("Marksheet Image Inserted ");
            
        }catch(Exception e){
            System.out.println("Exception Occur");
            System.out.println(e.getMessage());
        }finally{
            if(image != null){
                image.close();
            }
            
            if(con != null){
                con.close();
            }
            
            if(pst != null){
                pst.close();
            }
        }
        
    }
}
