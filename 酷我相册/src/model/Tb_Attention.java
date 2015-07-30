package model;


/*
 * 关注表
 */
public class Tb_Attention {
	private int id;
	private String useraccount;//用户
	private String attentionaccount;//关注用户

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserAccount() {
		return useraccount;
	}
	public void setUserAccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public String getAttentionAccount() {
		return attentionaccount;
	}
	public void setAttentionAccount(String attentionaccount) {
		this.attentionaccount = attentionaccount;
	}
}
