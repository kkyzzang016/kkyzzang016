package bankSystem;

public class BankClientInfo {

	private String id;
	private String pw;
	private String name;
	private String address;
	private String account;
	private String phone;
	private String birth; 
	private int money;
	
	public BankClientInfo(String id, String pw, String name, String address, String account, String phone, String birth, int money) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.address=address;
		this.account=account;
		this.phone=phone;
		this.birth=birth;
		this.money=money;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
