package modemedsite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

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
	
	private static final String BaseURL = "https://balazs-grill.ci.cloudbees.com/job/MODembed/lastSuccessfulBuild/artifact/core/hu.modembed.releng/repository/target/repository";
	
    /**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 771578936675722864L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
    {
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		String path = req.getPathInfo();
		System.out.println("Requesting "+path);
		if (path == null){
			resp.getWriter().println("This is an eclipse update site. Use an eclipse instance to access contents.");
		}else{
			String fullPath = BaseURL+path;
			HttpURLConnection connection = new sun.net.www.protocol.http.HttpURLConnection(new URL(fullPath),Proxy.NO_PROXY);
			connection.setInstanceFollowRedirects(false);
			try{
				connection.connect();
				for(Entry<String, List<String>> header : connection.getHeaderFields().entrySet()){
					StringBuilder headerValue = new StringBuilder();
					boolean first = true;
					for(String s : header.getValue()){
						if (first){
							first = false;
						}else{
							headerValue.append(", ");
						}
						headerValue.append(s);
					}
					System.out.println("-- "+header.getKey()+ " = "+ headerValue.toString());
					resp.addHeader(header.getKey(), headerValue.toString());
				}
				InputStream is = connection.getInputStream();
				OutputStream os = resp.getOutputStream();
				byte[] buffer = new byte[128];
				while(is.available() > 0){
					int r = is.read(buffer);
					os.write(buffer, 0, r);
					System.out.write(buffer, 0, r);
					System.out.flush();
				}
				
			}catch(Exception e){
				e.printStackTrace(resp.getWriter());
			}finally{
				connection.disconnect();
			}
		}
		
        //resp.getWriter().println("Hello Servlet World! "+req.getContextPath()+", "+req.getPathInfo()+", "+req.getQueryString());
    }
}
