package crm_project_02.entity;

public class Role {
	private int id;
	private String name;
	private String desc;
	private int stt;
	
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
