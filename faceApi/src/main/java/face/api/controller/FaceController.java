package face.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import face.api.pojo.HttpResult;
import face.api.service.FaceService;

/**
 * 调用摄像头控制层
 * 
 * @author 闫军
 *
 */
@Controller
public class FaceController {

	@Autowired
	private FaceService faceService;

	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@ResponseBody
	public HttpResult uploadImg(@RequestParam("image") String image) {

		HttpResult result = this.faceService.uploadImg(image);

		return result;
	}


	@RequestMapping(value = "/getPointByUploadImg", method = RequestMethod.POST)
	@ResponseBody
	public int getPointByUploadImg(@RequestParam("image") String image) {

		Integer result = this.faceService.getPointByUploadImg(image);
		System.out.println(result+"***************************");
		return result;
	}
}
