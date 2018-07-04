package cn.mldn.util;

import java.io.IOException;  
import java.io.OutputStream;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.util.Random;  
  
import javax.imageio.ImageIO;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
@WebServlet(urlPatterns = "/ImageCode" )  
public class VerifyCodeServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 3398560501558431737L;  
  
    @Override  
    protected void service(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    // 获得 当前请求 对应的 会话对象  
    HttpSession session = request.getSession();  
  
    // 从请求中获得 URI ( 统一资源标识符 )  
    String uri = request.getRequestURI();  
    System.out.println("hello : " + uri);  
  
    final int width = 180; // 图片宽度  
    final int height = 40; // 图片高度  
    final String imgType = "jpeg"; // 指定图片格式 (不是指MIME类型)  
    final OutputStream output = response.getOutputStream(); // 获得可以向客户端返回图片的输出流  
                                // (字节流)  
    // 创建验证码图片并返回图片上的字符串  
    String code = GraphicHelper.create(width, height, imgType, output);  
    System.out.println("验证码内容: " + code);  
  
    // 建立 uri 和 相应的 验证码 的关联 ( 存储到当前会话对象的属性中 )  
    session.setAttribute(uri, code);  
  
    System.out.println(session.getAttribute(uri));  
    System.out.println(request.getRemoteAddr());
  
    }  
  
}  

class GraphicHelper {  
	  
    /** 
     * 以字符串形式返回生成的验证码，同时输出一个图片 
     *  
     * @param width 
     *            图片的宽度 
     * @param height 
     *            图片的高度 
     * @param imgType 
     *            图片的类型 
     * @param output 
     *            图片的输出流(图片将输出到这个流中) 
     * @return 返回所生成的验证码(字符串) 
     */  
    public static String create(final int width, final int height, final String imgType, OutputStream output) {  
    StringBuffer sb = new StringBuffer();  
    Random random = new Random();  
  
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
    Graphics graphic = image.getGraphics();  
  
    graphic.setColor(Color.getColor("F8F8F8"));  
    graphic.fillRect(0, 0, width, height);  
  
    Color[] colors = new Color[] { Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,  
        Color.CYAN };  
    // 在 "画板"上生成干扰线条 ( 50 是线条个数)  
    for (int i = 0; i < 50; i++) {  
        graphic.setColor(colors[random.nextInt(colors.length)]);  
        final int x = random.nextInt(width);  
        final int y = random.nextInt(height);  
        final int w = random.nextInt(20);  
        final int h = random.nextInt(20);  
        final int signA = random.nextBoolean() ? 1 : -1;  
        final int signB = random.nextBoolean() ? 1 : -1;  
        graphic.drawLine(x, y, x + w * signA, y + h * signB);  
    }  
  
    // 在 "画板"上绘制字母  
    graphic.setFont(new Font("Comic Sans MS", Font.BOLD, 30));  
    for (int i = 0; i < 6; i++) {  
        final int temp = random.nextInt(26) + 97;  
        String s = String.valueOf((char) temp);  
        sb.append(s);  
        graphic.setColor(colors[random.nextInt(colors.length)]);  
        graphic.drawString(s, i * (width / 6), height - (height / 3));  
    }  
    graphic.dispose();  
    try {  
        ImageIO.write(image, imgType, output);  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
    return sb.toString();  
    }  
  
}  