package Main;

public class Data {
	private String id;
	private String name;
	private String kelamin;
	private String jabatan;
	private int flag;
	
	

	public Data(String id, String name, String kelamin, String jabatan, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.kelamin = kelamin;
		this.jabatan = jabatan;
		this.flag=flag;
	}
	
	
	
	

	public String getid() {
		return id;
	}





	public void setID(String id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getKelamin() {
		return kelamin;
	}





	public void setKelamin(String kelamin) {
		this.kelamin = kelamin;
	}





	public String getJabatan() {
		return jabatan;
	}





	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	
	public int getFlag(){
		return flag;
	}
	
	public void setFlag(int flag) {
		flag=flag;
	}


}
