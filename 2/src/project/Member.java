package project;

public class Member {
	
	// field
	private String id, pw, name, contact;
	private int count;
	
	// constructor
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String pw, String name, String contact, int count) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.contact = contact;
		this.count = count;
	}

	public Member(String id, String pw, String name, String contact) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.contact = contact;
	}

	public Member(String id, int count) {
		super();
		this.id = id;
		this.count = count;
	}

	
	// method
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	
	
	
	
	

}
