package task_1;
import java.sql.*;
import java.util.List;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DAOimp implements productDAO{

 private Connection con;
 private Statement st;
 private ResultSet rs;

 public void insertNew (product Product){	
		checkConnection();
		try{
		String query="INSERT INTO `product_database`.`product` VALUES (?,?,?,?,?)";
		PreparedStatement psmt=con.prepareStatement (query);
		psmt.setInt(1,Product.getID());
		psmt.setString(2, Product.getType());
		psmt.setString(3, Product.getMan());
		psmt.setString(4, Product.getPdate());
		psmt.setString(5, Product.getExpdate());
		int i = psmt.executeUpdate();
		if (i > 0) {
			 System.out.println("Product was successfully added");
		}
		else {
			 System.out.println("Product wasn't added");
		}
	}
	catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
	}
}

 public void Update (product Product){	
		checkConnection();
		try{
		String query="UPDATE `product_database`.`product` SET `type` = (?), `manufacturer` =(?), `pdate` =(?), `expdate` =(?) WHERE `product`.`productID` =(?) ";
		
		PreparedStatement psmt=con.prepareStatement (query);
		psmt.setInt(5,Product.getID());
		psmt.setString(1, Product.getType());
		psmt.setString(2, Product.getMan());
		psmt.setString(3, Product.getPdate());
		psmt.setString(4, Product.getExpdate());
		int i = psmt.executeUpdate();
		if (i > 0) {
			 System.out.println("Product was successfully updated");
		}
		else {
			 System.out.println("Product wasn't updated" + "   Update error");
		}
		
		 query="SELECT * FROM `product` where productID = "+Product.getID();

		rs=st.executeQuery(query);

		System.out.println("The updated Product is :");
		while (rs.next())
		{
		int ID= rs.getInt("productID");
		String type= rs.getString("type");
		String manufacturer= rs.getString("manufacturer");
		String pdate= rs.getString("pdate");
		String expdate= rs.getString("expdate");
		System.out.println("ID = "+ ID +"   Type = "+type + "   manufacturer =" + manufacturer + "   Production date = " + pdate  +"   Expiration Date = " + expdate );
		}
		}
		catch(Exception ex)
		{System.out.println("Update Error: "+ex);
		}
		
}

 public void delete(int id){
	 
	 checkConnection();
 try{
 String sql = "DELETE FROM `product` WHERE productID = "+id;
st.executeUpdate(sql);
System.out.println("Product with ID : "+id+ "  is Deleted");

 }catch(Exception ex){
	 System.out.println("Delete  Error: "+ex);
 }
 
 }

 public product retrieve(int id){
		checkConnection();
		product my_product=null;
	 try{
String query="SELECT * FROM `product` where productID = "+id;

rs=st.executeQuery(query);
if (rs.next()==false){
	System.out.println("No such product");
}else{
{	System.out.println("Product :");

int ID= rs.getInt("productID");
String type= rs.getString("type");
String manufacturer= rs.getString("manufacturer");
String pdate= rs.getString("pdate");
String expdate= rs.getString("expdate");
System.out.println("ID = "+ ID +"   Type = "+type + "   manufacturer =" + manufacturer + "   Production date = " + pdate  +"   Expiration Date = " + expdate );
  my_product=new product (ID,type,manufacturer,pdate,expdate);
}
}
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Retrieve Error:"+ex);
	 }

	 	 return my_product;

 }
 
 public product search(String man){
		checkConnection();
		product my_product=null;
	 try{
		 PreparedStatement st = con.prepareStatement("SELECT * FROM `product` where manufacturer = (?)");
		 st.setString(1,man);
rs=st.executeQuery();
if (rs.next()==false){
	System.out.println("No such product");
}else{
{	System.out.println("Product :");

int ID= rs.getInt("productID");
String type= rs.getString("type");
String manufacturer= rs.getString("manufacturer");
String pdate= rs.getString("pdate");
String expdate= rs.getString("expdate");
System.out.println("ID = "+ ID +"   Type = "+type + "   manufacturer =" + manufacturer + "   Production date = " + pdate  +"   Expiration Date = " + expdate );
  my_product=new product (ID,type,manufacturer,pdate,expdate);
}
}	 }
	 catch(Exception ex)
	 {
		 System.out.println("Search Error:"+ex);
	 }

	 return my_product;

	 
}

 public product retrieveAll(){
		checkConnection();
		product my_product=null;

	 try{
String query="SELECT * FROM `product` ";

rs=st.executeQuery(query);

System.out.println("All Products are : ");
while (rs.next())
{
int ID= rs.getInt("productID");
String type= rs.getString("type");
String manufacturer= rs.getString("manufacturer");
String pdate= rs.getString("pdate");
String expdate= rs.getString("expdate");
System.out.println("ID = "+ ID +"   Type = "+type + "   manufacturer =" + manufacturer + "   Production date = " + pdate  +"   Expiration Date = " + expdate );
my_product=new product (ID,type,manufacturer,pdate,expdate);
}
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Retrieve all Error:"+ex);
	 }

	 return my_product;

	 
}
  
 private void checkConnection(){
	 try{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_database", "root", "");
		 st=con.createStatement();		 
		 System.out.println("Connection Established");

	 }
	 catch (Exception ex)
	 {
		 System.out.println("Connection Error:  "+ ex);
	 }
}

}
