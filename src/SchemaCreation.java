import java.sql.*;

public class SchemaCreation {
    public static void main(String[] args){
        Connection con = null;
        Statement st = null;
        
        
        String database = "jdbc:mysql://jdbcassignment.cetn2jthwfls.us-east-1.rds.amazonaws.com/demo";
        String user = "root";
        String password = "abcd1234";
        
        try{
            con = DriverManager.getConnection(database,user,password);
            System.out.println("Connection Successful");
            
            st = con.createStatement();
            
            String sql = "CREATE TABLE demo.17IT093 (\r\n" + 
				" SemId INT NOT NULL AUTO_INCREMENT primary key,\r\n" + 
				" SGPA DECIMAL(10,2) not null,\r\n" + 
				" CGPA DECIMAL(10,2) DEFAULT NULL,\r\n" + 
				"class varchar(10) not null)";
            
            boolean tablecreated = st.execute(sql); //if this statement return false then table is created
            if(!tablecreated)
                System.out.println("Table Created"); 
            
        }catch(Exception e){
            System.out.println("Exception Occur");
            System.out.println(e.getMessage());
        }
    }
}
