package model;


/*
 * ��ע��
 */
public class Tb_Attention {
	private int id;
	private String useraccount;//�û�
	private String attentionaccount;//��ע�û�

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
