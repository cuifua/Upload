package cuifua.controller;

import cuifua.pojo.DataJson;
import cuifua.utils.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
@RequestMapping("upload")
public class UploadController
{
    @RequestMapping("image")
    @ResponseBody
    public DataJson uploadImage(MultipartFile file)
    {
        //调用工具类完成文件上传
        String imagePath = UploadUtils.upload(file);
        System.out.println(imagePath);

        DataJson dataJson = new DataJson();
        if (imagePath != null)
        {
            //创建一个HashMap用来存放图片路径
            HashMap hashMap = new HashMap();
            hashMap.put("src",imagePath);

            dataJson.setCode(0);
            dataJson.setMsg("上传成功");
            dataJson.setData(hashMap);
        }
        else
        {
            dataJson.setCode(0);
            dataJson.setMsg("上传失败");
        }
        return dataJson;
    }

    @RequestMapping("addImage")
    @ResponseBody
    public String addImage(String imagePath,String imageDescribe)
    {
        //把图片访问路径添加到数据库中
        System.out.println("图片描述："+imageDescribe);
        System.out.println("图片地址："+imagePath);

        return"1";
    }
}
