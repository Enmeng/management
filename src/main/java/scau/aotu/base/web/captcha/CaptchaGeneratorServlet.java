package scau.aotu.base.web.captcha;


import scau.aotu.base.utils.RandomUtil;
import scau.aotu.base.utils.VerifyCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * 生成校验码的servlet
 *
 */
public class CaptchaGeneratorServlet extends HttpServlet {

    private static final long serialVersionUID = -7096260607103855841L;

    //校验码在session中的key
    public static final String VALIDATE_CODE = "_validateCode_";
//    private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();  
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse resp = (HttpServletResponse)res;
        
      //清除缓存，每次访问该页面时都从服务器端读取
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0); // 定义显示图片的宽度和高度
//        String  randCode = RandomUtils.getRandom(4);
        String randCode = VerifyCodeUtils.generateVerifyCode(4);
        // 保存进session  
        request.getSession().setAttribute(VALIDATE_CODE, randCode);
        drawCaptcha2(request, resp, randCode);

    }

    /**
     * @param resp
     * @param randCode
     * @throws IOException
     */
    private void drawCaptcha1(HttpServletRequest httpServletRequest, HttpServletResponse resp, String randCode) throws IOException {
        int width = 120, height = 42;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 画图画板 
        Graphics g = image.getGraphics();
        try{
            RandomUtil.drawRandomPicture(g, width, height, randCode);
        }finally{
            g.dispose();
        }
        // 显示图片
        g.dispose();
        //转换成一张图片，格式为JPEG  
        final ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "JPEG", outputStream);
    }
    
    private void drawCaptcha2(HttpServletRequest httpServletRequest, HttpServletResponse resp, String randCode) throws IOException {
    	int width = 120, height = 42;
		ServletOutputStream outputStream = resp.getOutputStream();
		VerifyCodeUtils.outputImage(width, height, outputStream, randCode);
    }
}
 
