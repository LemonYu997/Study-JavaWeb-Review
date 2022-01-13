package demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Base64Demo {
    public static void main(String[] args) throws IOException {
        String content = "这是需要Base64编码的内容";

        //1、编码操作
        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //这里支持的是字节数组，要先进行转换
        String ss = base64Encoder.encode(content.getBytes(StandardCharsets.UTF_8));
        System.out.println(ss);     //6L+Z5piv6ZyA6KaBQmFzZTY057yW56CB55qE5YaF5a65

        //2、解码操作
        //创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //获得解码后的字节数组
        byte[] bytes = base64Decoder.decodeBuffer(ss);
        //还原为字符串
        System.out.println(new String(bytes, "utf-8"));
    }
}
