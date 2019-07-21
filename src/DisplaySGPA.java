import java.sql.*;
import java.util.Scanner;

public class DisplaySGPA {
    public static void main(String[] args) throws SQLException{
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String database = "jdbc:mysql://jdbcassignment.cetn2jthwfls.us-east-1.rds.amazonaws.com/demo";
        String user = "root";
        String password = "abcd1234";
        
        Scanner s = new Scanner(System.in);
        int sem;
        while(true){
            System.out.println("Enter Semester b/w 1 to 4");
            sem=s.nextInt();
            if(sem >=1 && sem<=4)
                break;
        }
        try{
            
            con = DriverManager.getConnection(database,user,password);
            System.out.println("Connection Successful");
            String sql = "SELECT SGPA from `17IT093` where SemId = "+sem;
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println(rs.getString("SGPA"));
            
        }catch(Exception e){
            System.out.println("Exception Ocuur");
            System.out.println(e.getMessage());
        }finally {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {
				st.close();
			}

			if (con != null) {
				con.close();
			}
		}
        
    }
}
