package task_1;


public class product {
	private  int product_id;
	private  String type;
	private String manufacture;
	private String pdate;
	private String expdate;
	
	public product(int product_id,String type,String manufacture, String pdate,String expdate){
		this.product_id = product_id;
		this.type = type;
		this.manufacture = manufacture;
		this.pdate = pdate;
		this.expdate = expdate;
	}
	
	public void setID(int product_id){
		this.product_id = product_id;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setMan(String manufacture){
		this.manufacture = manufacture;
	}
	public void setPdate(String pdate){
		this.pdate = pdate;
	}
	public void setExpdate(String expdate){
		this.expdate = expdate;
	}
	
	public int getID(){
		return(this.product_id);
	}
	public String getType(){
		return(this.type);
	}
	public String getMan(){
		return(this.manufacture);
	}
	public String getPdate(){
		return(this.pdate);
	}
	public String getExpdate(){
		return(this.expdate);
	}



}
