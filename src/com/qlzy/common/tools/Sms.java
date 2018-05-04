package com.qlzy.common.tools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/** 
 * @author
 * @version
 * 类说明 
 */
public class Sms {
	
	//产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI8G79YvXNYFRY";
    static final String accessKeySecret = "a98zBFkr0klFlvGmTZvmnIASUpQsXV";
    /***
     * 短信验证码使用
     * @param mobile
     * @param code
     * @param  m=1用户注册验证 m=2修改密码验证码 m=3身份验证 m=4异常登录验证 m=5信息变更验证
     * @return
     * @throws ClientException
     */
    public static boolean Send(String mobile,String code,String m) throws ClientException {
    	boolean dd = true;
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("颐佳商城");
        //必填:短信模板-可在短信控制台中找到
        String modelCode = "";
        if("1".equals(m)){
            modelCode="SMS_131030080";
        }else if("2".equals(m)){
            modelCode="SMS_131030079";
        }else if("3".equals(m)){
            modelCode="SMS_131030083";
        }else if("4".equals(m)){
            modelCode="SMS_131030081";
        }else{
            modelCode="SMS_131030082";
        }
        request.setTemplateCode(modelCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println(sendSmsResponse);
        if("OK".equals(sendSmsResponse.getCode())){
        	
        }else {
        	dd=false;
		}

        return dd;
    }
	
    public static void main(String[] args) throws ClientException, InterruptedException {
        //发短信
    	String mobile = "18668967553";
    	String code = "259700";
    	Sms sms = new Sms();
        boolean response = sms.Send(mobile,code,"2");
        System.out.println(response);

    }

}
 