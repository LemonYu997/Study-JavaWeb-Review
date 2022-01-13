package demo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //创建对象，在内存中画图（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width - 1, height - 1);
        //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        //写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机小标
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();  //存储验证码
        for (int i = 1; i <= 4; i++) {
            //在str长度中挑选一个随机数字
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);    //随机字符
            stringBuilder.append(ch);   //存储验证码
            //写字符在图片上
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        //存储验证码
        String checkCode_session = stringBuilder.toString();
        //将验证码存入session
        req.getSession().setAttribute("checkCode_session", checkCode_session);
        //画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3、将图片输出到页面展示
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
