package task_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main_prog {

	public static void main(String args[]) {
				
		System.out.println("Welcome to the System Kindly press :");
		System.out.println("1) to Add a new product");
		System.out.println("2) to Delete  a product");
		System.out.println("3) to Edit a  product");
		System.out.println("4) to retrieve all products");
		System.out.println("5) to Search for a product");
		
		Scanner  scan = new Scanner(System.in);

		try
		{
		  int respond = scan.nextInt();
		respond(respond);  
		}
	
		catch(InputMismatchException exception)
		{
		  System.out.println("This is not an integer \n");
		  main(args);
		}
		
	}

	static void respond(int respond){
		
		Scanner  scan = new Scanner(System.in);

	  switch(respond){
		case 1:
			add();
			break;
		case 2:
			delete();
			break;

		case 3:
			update();
			break;

		case 4:
			retrieveAll();
			break;
		case 5:
			search();
			break;
		default:
			System.out.println("please enter a choice from 1 to 5");
			   respond = scan.nextInt();
			   respond(respond);
			break;
			}
	  main(null);
	}

static void add()

{
	Scanner  scan = new Scanner(System.in);

	  System.out.println("Please enter the Product's ID");
	  int id = scan.nextInt();

	  System.out.println("Please enter the Product's type");
	  String type = scan.next();

	  System.out.println("Please enter the Product's Manufacturer");
	  String manu = scan.next();

	  System.out.println("Please enter the Product's production Date");
	  String pdate = scan.next();

	  System.out.println("Please enter the Product's expiration date");	
	  String expdate = scan.next();
	  System.out.println("\n");	
	  
	   product new_product= new product(id,type,manu,pdate,expdate);
	  	
	  	DAOimp DAO= new DAOimp();
		DAO.insertNew(new_product);
		System.out.println("Product added :");
		System.out.println("ID: "+id + "|\t" +"Type:  "  +type +"|\t" + "Manufacturer:  "+ manu +"|\t" + "Production Date:  " + pdate +"|\t" + "Expiration Date:  "+ expdate);
		 main(null );
		
}

static void delete(){
	Scanner  scan = new Scanner(System.in);
	  System.out.println("Please enter the Product's ID you want to delete ");
	  int id = scan.nextInt();
	  	DAOimp DAO= new DAOimp();
	  product edit_product=DAO.retrieve(id);
	while(edit_product!=null)
	{
	  System.out.println("Are you sure you want to delete that product? ");
	  int del = scan.nextInt();
	  if (del==1){
		DAO.delete(id);  
		edit_product=null;
	  }
	  else{
		  main(null);
	  }
	}


}

static void update()
{
	Scanner  scan = new Scanner(System.in);
	
	  System.out.println("Please enter the Product's ID");
	  int id = scan.nextInt();
	  
	  	DAOimp DAO= new DAOimp();

	  product edit_product=DAO.retrieve(id);
		while(edit_product!=null)
		{
	  System.out.println("What Do you want to edit : ");
	  System.out.println("1) Type \n 2) Manufacturer \n 3) Production Date \n 4) Expiration Date ");
	  int edit = scan.nextInt(); 
	  
	  switch(edit){
		case 1:
			  System.out.println("What is the new type");
			  edit_product.setType(scan.next())  ; 

			break;
		case 2:
			  System.out.println("What is the new Manufacturer");
			  edit_product.setMan(scan.next())  ; 
				break;
		case 3:
			  System.out.println("What is the new production date");
			  edit_product.setPdate(scan.next())  ; 
				break;
		case 4:
			  System.out.println("What is the new Expiration date");
			  edit_product.setExpdate(scan.next())  ; 
				break;
		default:
			System.out.println("please enter a chice from 1 to 4");
			   edit = scan.nextInt();
			   update();
			break;
			}

		DAO.Update(edit_product);
		System.out.println("Product updated :");
		 main(null);
		}
	
}

static void search(){
	
	System.out.println("Please enter the manufacturer of the required Product:");
	Scanner  scan = new Scanner(System.in);

	  String man = scan.next();

  	DAOimp DAO= new DAOimp();
  	product Product=DAO.search(man);
  	
}

static void retrieveAll(){
  	DAOimp DAO= new DAOimp();
  	product all=DAO.retrieveAll();
  	
}

}
