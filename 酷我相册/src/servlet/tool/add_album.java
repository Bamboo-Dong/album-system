package servlet.tool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Tb_AlbumDao;

public class add_album {
	
	private static final long serialVersionUID = -3157201516082556521L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=(String) request.getSession().getAttribute("albumname");
		//String attentionaccount=request.getParameter("attentionaccount");
		Tb_AlbumDao f=new Tb_AlbumDao();
		Object[] par={id};
		f.add_album(par);
	}

}
