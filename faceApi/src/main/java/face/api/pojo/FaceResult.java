package face.api.pojo;

import java.util.HashMap;

/**
 * faceAPI返回json字符串 body转 对象
 * 
 * @author xh
 *
 */
public class FaceResult {

    private String faceId;

    private Object faceRectangle;

    private HashMap<String, Emotion> faceAttributes;

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public Object getFaceRectangle() {
        return faceRectangle;
    }

    public void setFaceRectangle(Object faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    public HashMap<String, Emotion> getFaceAttributes() {
        return faceAttributes;
    }

    public void setFaceAttributes(HashMap<String, Emotion> faceAttributes) {
        this.faceAttributes = faceAttributes;
    }
}
