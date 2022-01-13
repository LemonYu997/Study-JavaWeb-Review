package file.upload;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName = "气泡.jpg";

        //2、读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();
        //3、在回传前，通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/img/" + downloadFileName);
        System.out.println("下载的文件类型:" + mimeType);
        resp.setContentType(mimeType);

        //4、告诉客户端收到的数据是用于下载使用（还是使用响应头）
        //Content-Disposition表示收到的数据怎么处理
        //attachment表示附件，表示下载使用
        //filename=表示指定的文件名，可以与原文件名不同，是下载时的文件名

        //判断用户使用的浏览器
        if (req.getHeader("User-Agent").contains("Firefox")) {
            //解决火狐浏览器中文名乱码问题，使用Base64编码
            resp.setHeader("Content-Disposition",
                    "attachment;filename==?charset?B?"
                            + new BASE64Encoder().encode(downloadFileName.getBytes(StandardCharsets.UTF_8))
                            + "?=");
        } else {
            //chrome和IE解决中文乱码问题：对文件名使用URL编码
            resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFileName, "utf-8"));
        }

        //5、把下载的文件内容回传给客户端
        //获取响应的输出流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + downloadFileName);
        ServletOutputStream os = resp.getOutputStream();
        //把resourceAsStream流中的内容（文件）复制到响应输出流中
        IOUtils.copy(resourceAsStream, os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
