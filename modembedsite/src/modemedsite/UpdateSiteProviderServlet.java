package modemedsite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Hello world!
 *
 */
public class UpdateSiteProviderServlet extends HttpServlet
{
	
	//private static final String BaseURL = "https://balazs-grill.ci.cloudbees.com/job/MODembed/lastSuccessfulBuild/artifact/core/hu.modembed.releng/repository/target/repository";
	
    /**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 771578936675722864L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		String path = req.getPathInfo();
		System.out.println("Requesting "+path);
		if (path == null){
			resp.getWriter().println("This is an eclipse update site. Use an eclipse instance to access contents.");
		}else{
			InputStream is = getServletContext().getResourceAsStream("data/"+path);
			try{
				OutputStream out = resp.getOutputStream();
				byte[] buffer = new byte[128];
				while(is.available() > 0){
					int r = is.read(buffer);
					out.write(buffer, 0, r);
				}
			}finally{
				is.close();
			}
		}

		//resp.getWriter().println("Hello Servlet World! "+req.getContextPath()+", "+req.getPathInfo()+", "+req.getQueryString());
	}

}
