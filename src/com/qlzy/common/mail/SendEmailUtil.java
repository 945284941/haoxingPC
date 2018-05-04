package com.qlzy.common.mail;

/**
 * @ClassName: SendEmailUtil 
 * @Description: TODO(发送邮件方法实现类) 
 * @date 2013-9-29 上午11:00:52 
 *
 */
public class SendEmailUtil {

	/**
	 * @Title: sendEmailCode
	 * @Description: TODO(发送邮箱验证码) 
	 * @param @param userName
	 * @param @param email
	 * @param @param emailCode    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public static void sendEmailCode(String userName, String email,
			String emailCode) {
		String title = "颐佳---邮箱验证！";
		String content = "<div style=\"width:650px; border:1px solid #cccccc; margin-top:20px;\">" +
				"<div style=\" background:url(http://www.sanguhuivip.com/images/yzbg.gif) repeat-x; height:67px; padding-top:1px; padding-left:20px\">" +
				"<div style=\" background:url(http://www.sanguhuivip.com/images/logoyz.gif) no-repeat; height:67px; line-height:67px; padding-left:230px; color:#ffffff; font-size:22px; " +
				"font-weight:bold\">中国有机粮食专业商务平台</div></div><p style=\"margin:30px 20px;\">尊敬的【" + userName + "】：</p>" +
				"<p style=\"margin:20px 20px;\">您好！感谢您使用颐佳。</p>" +
				"<p style=\"margin:30px 20px; line-height:30px\">您正在进行邮箱绑定，请在校验码输入框中输入：【" + emailCode
				+ "】，以完成验证。</p>" +
				"<p style=\"margin:30px 20px; line-height:30px\">" +
				"<span style=\"font-weight:bold; color:#ff0000\">注意：</span>如非本人操作，请及时登录并修改密码以保证账号安全。这是一封系统邮件，不接收回信，请勿直接回复。</p></div>";
		try {
			MailOut.mailOut(email, title, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}