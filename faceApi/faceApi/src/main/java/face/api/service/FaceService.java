package face.api.service;

import face.api.pojo.HttpResult;

public interface FaceService {
	/**
	 * 获取上传图片的Base64字符串二进制流
	 * 
	 * @param image
	 */
	public HttpResult uploadImg(String image);

	/**
	 * 根据图片获取分数
	 * @param image
	 * @return
	 */
	public int getPointByUploadImg(String image);


}
