package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import vo.ActionForward;

public class MovieProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
		String name = request.getParameter("name");
		System.out.println(name+"MovieProAction name 파라미터 값");
		
		movie movie = new movie();
		String json = movie.getMovie(name);
//		
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
		
		
		JsonArray mo = (JsonArray) jsonObject.get("items");
		
//		for(int i = 0; i<mo.size(); i ++) {
//			JsonObject movieArray = (JsonObject) mo.get(i);
//			
//		}
		
		response.setContentType("application/json;charset=UTF-8");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(mo);
//		out.print("<script>location href='/member/test_list.jsp'</script>");
		out.flush();
		
		
		
//		ActionForward forward = new  ActionForward();
//		forward.setPath("/member/test_list.jsp");
		return null;
	}
	
}
