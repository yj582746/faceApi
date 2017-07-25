package face.api.utils;

import java.io.*;

import org.apache.commons.codec.binary.Base64;

/**
 * 文件和二进制流的转换工具类
 * 
 * @author 闫军
 *
 */
public class B64ToImgUtils {
    /**
     * 文件转二进制
     *
     * @param imgFilePath
     * @return
     */
    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        Base64 encoder = new Base64();
        return encoder.encodeToString(data);// 返回Base64编码过的字节数组字符�?
    }

    /**
     * 二进制流对象输出文件
     *
     * @param imgStr
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图�?
        if (imgStr == null) // 图像数据为空
            return false;
        try {
            // Base64解码
            byte[] bytes = new Base64().decode(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
