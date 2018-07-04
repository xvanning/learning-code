package cn.mldn.interceptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandler implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, 
			Object handler,Exception ex)throws Exception {
		 
		 System.out.println("###### 执行处理完毕 ######");
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, 
			Object handler,ModelAndView modelAndView) throws Exception {
		 System.out.println("###### 执行中拦截 ######");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HandlerMethod hanm = (HandlerMethod) handler;
		System.out.println("###### 执行前拦截 ######");
		System.out.println("操作的Action对象： " + hanm.getBean() + ", 类型： " + hanm.getBeanType()
		+ "方法名称： " + hanm.getMethod());
		MethodParameter mp[] = hanm.getMethodParameters();
		for (int i = 0; i < mp.length; i++) {
			System.out.println("方法： " + mp[i].getMethod() + ", 参数名称: " + mp[i].getParameterName() + "参数类型： " + mp[i].getParameterType());
	}
		//定义一个专门用于保存错误信息的Map集合
		Map<String, String> errors = new HashMap<String, String>();
		
		//取得每一个Action中验证规则的名字
		String fieldName = hanm.getMethod().getName() + "Rule"; //取得验证规则
		System.out.println("*** 取得fieldName *** " + fieldName);
		try {
				Field field = hanm.getBean().getClass().getDeclaredField(fieldName);
				//System.out.println("*** 取得hanm.getBean().getClass() *** " + hanm.getBean().getClass());
				//System.out.println("*** 取得field *** " + field);
				field.setAccessible(true);//取消封装
				String rules = (String) field.get(hanm.getBean());//取得规则信息
				System.out.println("*** 取得规则信息 *** " + rules);
				String result[] = rules.split("\\|");
				for (int i = 0; i < result.length; i++) {
					String temp[] = result[i].split(":");
					String paramvalue = request.getParameter(temp[0]);
					System.out.println("参数名称： " + temp[0] + "， 参数内容： " + paramvalue + ", 验证规则： " + temp[1]);
				if(paramvalue == null){//有错误
					errors.put(temp[0], "数据内容不允许为空"); //可以用反射继续找到对象
					return false;
				}else {
					if ("int".equalsIgnoreCase(temp[1])) {
						if (!paramvalue.matches("\\d+")) {
							errors.put(temp[0], "数据类型必须为整数"); 
						}
					}
				}
				}
			} catch (Exception e) {}	
		boolean flag = true;
		if (errors.size() > 0) { //有错误信息
			flag = false;
		}else {//表示现在基础的验证操作完成，下面需要判断是否有上传文件
			MultipartResolver mr = new CommonsMultipartResolver();
			if (mr.isMultipart(request)) { //，判断是否有文件上传，如果现在有文件上传，则要取得上传的表单数据
				MultipartRequest mreq = (MultipartRequest) request; //为了取得上传表单内容
				Map<String, MultipartFile> map = mreq.getFileMap(); //取得所有的上传文件
				if (map.size() > 0) {
					Field field = hanm.getBean().getClass().getDeclaredField("mimeRule");
					field.setAccessible(true);//取消封装
					String mimeRule = (String) field.get(hanm.getBean());//取得规则信息
					String resultMime[] = mimeRule.split(",");
					System.out.println("resultMime: " + resultMime[2]);
					Iterator<Map.Entry<String, MultipartFile>> iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<String, MultipartFile> me = iter.next();
						String paramName = me.getKey(); //取得文件名字
						MultipartFile file = me.getValue(); //取得文件内容
						System.out.println("file.getContentType(): " + file.getContentType());
						System.out.println("文件名称： " + paramName + "， 文件内容： " + file);
						for (int i = 0; i < resultMime.length; i++) {
							if (!this.isExists(resultMime, file.getContentType())) {//符合规则
								errors.put(paramName, "上传了非法文件");
								flag = false;
								break;
							}
						}
					}
				}
				
			}
		}
		if (flag == false) {
			System.out.println(errors);
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
		}
		return true;
	}

	public boolean isExists(String data[], String str) {
		for (int i = 0; i < data.length; i++) {
			if (str.equals(data[i])) {
				return true;
			}
		}
		return false;
	}
	
}
