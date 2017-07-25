package face.api.utils;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import face.api.pojo.HttpResult;

/**
 * 人脸识别API调用
 * 
 * @author 闫军
 *
 */
public class FaceApiUtils {

    // 人脸识别api路径
    private static final String URL = "https://api.cognitive.azure.cn/face/v1.0/detect";

    /**
     * // 人脸识别对应的key // 请求头 key 由azure提供 // 账号:admin@hua1.partner.onmschina.cn // 密码:Ad12345678
     */
    private static final String Key = "fe80dc52bfe44e68b4348d2f605a35c8";

    public static HttpResult Face(byte[] file2byte) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder(URL);

            // 设置请求参数,详见API https://docs.azure.cn/zh-cn/cognitive-services/

            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");
            builder.setParameter("returnFaceAttributes", "emotion");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", Key);

            ByteArrayEntity byEntity = new ByteArrayEntity(file2byte);
            request.setEntity(byEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 返回结果不为空,封装返回结果集中,便于二次开发
                String result = EntityUtils.toString(entity, "UTF-8");
                System.out.println(result);
                return new HttpResult(response.getStatusLine().getStatusCode(), result);
            }
            // 如果响应体为空
            return new HttpResult(response.getStatusLine().getStatusCode(), "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}