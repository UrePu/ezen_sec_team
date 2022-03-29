package project;

public class Member {
	
	//�ʵ�
	private String id;
	private String password;
	private int count;
	private String name;
	private String phone;	
	
	//������
	public Member() {}
	
	public Member(String id, String password, String name, String phone) { // ȸ������
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	public Member(String id, int count) { // ��ŷ
		this.id = id;
		this.count = count;
	}
	
	public Member(String id, String password, String name, String phone, int count) { // Ǯ
		this.id = id;
		this.password = password;
		this.count = count;
		this.name = name;
		this.phone = phone;
	}

	//�޼ҵ�[get/set]
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
