package by.mlend.data.to;

public class StorageLocationTO implements TransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StorageLocationTO [id=" + id + ", name=" + name + "]";
	}

}
