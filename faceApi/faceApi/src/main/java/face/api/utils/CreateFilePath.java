package face.api.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

@SuppressWarnings("all")
public class CreateFilePath {

    // C:\\heima21\\taotao-upload\\images\\2016\\03\\28\\yyyyMMddHHmmssSSSSXXXX.jpg
    private String getPicPath(String originalFilename) {
        // File.separator路径分隔符，相当于\\，作用跨平台，window和Linux
        // C:\\heima21\\taotao-upload\\images
        String fileFolder = "C:\\oohdear" + File.separator + "images";
        
        Date nowDate = new Date();

        // C:\\heima21\\taotao-upload\\images\\2016\\03\\28
        String filePath = fileFolder + File.separator + new DateTime(nowDate).toString("yyyy")
                + File.separator + new DateTime(nowDate).toString("MM") + File.separator
                + new DateTime(nowDate).toString("dd");
        
        File file = new File(filePath);

        // 判断是否有该路径，如果有则掠过，如果没有则创建
        if (!file.isDirectory()) {
            // 创建路径
            file.mkdirs();
        }

        // yyyyMMddHHmmssSSSSXXXX.jpg
        String fileName = new DateTime(nowDate).toString("yyyyMMddHHmmssSSSS")
                + RandomUtils.nextInt(1000, 9999) + "."
                + StringUtils.substringAfterLast(originalFilename, ".");

        // C:\\heima21\\taotao-upload\\images\\2016\\03\\28\\yyyyMMddHHmmssSSSSXXXX.jpg
        return filePath + File.separator + fileName;
    }
}
