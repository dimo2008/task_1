package task_1;

public interface productDAO {
	
	public void insertNew(product Product);
	public void delete(int id);
	public void Update(product Product);
	public product retrieve(int id);
	public product search(String man);
	public product retrieveAll();

}
