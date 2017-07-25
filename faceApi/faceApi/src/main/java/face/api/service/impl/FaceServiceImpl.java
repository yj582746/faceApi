package face.api.service.impl;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import face.api.pojo.Emotion;
import face.api.pojo.FaceResult;
import face.api.pojo.HttpResult;
import face.api.service.FaceService;
import face.api.utils.B64ToImgUtils;
import face.api.utils.FaceApiUtils;
import face.api.utils.NumberUtils;

/**
 * 摄像头图片业务层
 * 
 * @author xh
 *
 */
@Service
public class FaceServiceImpl implements FaceService {

	/**
	 * 获取上传图片的Base64字符串二进制流
	 *
	 * @param image
	 */
	public HttpResult uploadImg(String image) {
		// 将二进制流对象做人脸识别,返回结果
		HttpResult face = FaceApiUtils.Face(new Base64().decode(image));
		String body = face.getBody();
		List<FaceResult> e = JSONObject.parseArray(body, FaceResult.class);
		if (e.size() > 0) {
			Emotion ee = e.get(0).getFaceAttributes().get("emotion");
			System.out.println(ee.toString());
			System.out.println("das");
		} else {

		}
		// 将base64转文件保存在本地
		boolean b = B64ToImgUtils.GenerateImage(image, "C:\\" + System.currentTimeMillis() + ".jpg");
		System.out.println(b + "是否保存成功");
		System.out.println(face.toString());
		return face;
	}

	/**
	 * 根据图片获取分数
	 * 
	 * @param image
	 * @return
	 */
	public int getPointByUploadImg(String image) {
		// 将二进制流对象做人脸识别,返回结果
		int result = 0;
		String body = FaceApiUtils.Face(new Base64().decode(image)).getBody();
		List<FaceResult> e = JSONObject.parseArray(body, FaceResult.class);
		if (e.size() > 0) {
			Emotion ee = e.get(0).getFaceAttributes().get("emotion");
			String happiness = ee.getHappiness();
			if (happiness.equals("0.0")) {
				result = (int) (Double.parseDouble("0.7") * 100);
			} else {
				result = (int) (Double.parseDouble(happiness) * 100);
			}
		}
		// result = NumberUtils.carteNumber();
		return result;
	}
}
