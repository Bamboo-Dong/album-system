package login;
/*
 * ”√ªß±Ì
 */
public class Tb_Userinfo {
	private String account;
	private String name;
	private String qq;
	private String password;
	

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
	
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public Tb_Userinfo(){
		 
	 }
	 
	 public Tb_Userinfo(String account, String password,String name,String qq){
	    this.account = account;
	    this.password = password;
	    this.name=name;
	    this.qq=qq;
	 }
	
}

