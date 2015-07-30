package servlet.tool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Tb_AttentionDao;;

public class Insert_Attention extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -27491402355155187L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=(String) request.getSession().getAttribute("id");
		String attentionaccount=request.getParameter("attentionaccount");
		Tb_AttentionDao f=new Tb_AttentionDao();
		Object[] par={id,attentionaccount};
		f.insert_attention(par);
	}
}
