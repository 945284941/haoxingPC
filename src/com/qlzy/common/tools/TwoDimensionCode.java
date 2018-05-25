package com.qlzy.common.tools;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.qlzy.memberCenter.shop.action.UploadAction;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import com.swetake.util.Qrcode;
import org.apache.struts2.ServletActionContext;

import static com.qlzy.common.tools.ToolsUtil.getResourcePath;

public class TwoDimensionCode {
	
	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param imgPath 图片路径
	 */
	public static void encoderQRCode(String content, String imgPath) {

	    encoderQRCode(content, imgPath, "png", 7);
	}
	
	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param output 输出流
	 */
	public static void encoderQRCode(String content, OutputStream output) {
		encoderQRCode(content, output, "png", 7);
	}
	
	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param imgPath 图片路径
	 * @param imgType 图片类型
	 */
	public static void encoderQRCode(String content, String imgPath, String imgType) {
		encoderQRCode(content, imgPath, imgType, 7);
	}
	
	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param output 输出流
	 * @param imgType 图片类型
	 */
	public static void encoderQRCode(String content, OutputStream output, String imgType) {
		encoderQRCode(content, output, imgType, 7);
	}

	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param imgPath 图片路径
	 * @param imgType 图片类型
	 * @param size 二维码尺寸
	 */
	public static String encoderQRCode(String content, String imgPath, String imgType, int size) {
        String nnnn="";
		try {
			BufferedImage bufImg = qRCodeCommon(content, imgType, size);
			
			File imgFile = new File(imgPath);
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, imgType, imgFile);
            nnnn = UploadAction.uploadImg(imgFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
        return nnnn;
	}

	/**
	 * 生成二维码(QRCode)图片
	 * @param content 存储内容
	 * @param output 输出流
	 * @param imgType 图片类型
	 * @param size 二维码尺寸
	 */
	public static void encoderQRCode(String content, OutputStream output, String imgType, int size) {
		try {
			BufferedImage bufImg = qRCodeCommon(content, imgType, size);
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, imgType, output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成二维码(QRCode)图片的公共方法
	 * @param content 存储内容
	 * @param imgType 图片类型
	 * @param size 二维码尺寸
	 * @return
	 */
	private static BufferedImage qRCodeCommon(String content, String imgType, int size) {
		BufferedImage bufImg = null;
		try {
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
			qrcodeHandler.setQrcodeVersion(size);
			// 获得内容的字节数组，设置编码格式
			byte[] contentBytes = content.getBytes("utf-8");
			// 图片尺寸
			int imgSize = 67 + 12 * (size - 1);
			bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			// 设置背景颜色
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);

			// 设定图像颜色> BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量，不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < 800) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
			}
			gs.dispose();
			bufImg.flush();
			//ImageIO.write(bufImg, "png", new File("E:/qrcode.png"));
			/*File f = new File("jpeg");

			String suffix = f.getName().substring(f.getName().indexOf(".")+1, f.getName().length());

			System.out.println("二维码输出成功！！");

			try {

				ImageIO.write(bufImg, suffix, f);

			} catch (IOException ioe) {

				System.out.println("二维码生成失败" + ioe.getMessage());

				//return false;

			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bufImg;
	}
	
	/**
	 * 解析二维码（QRCode）
	 * @param imgPath 图片路径
	 * @return
	 */
	public static String decoderQRCode(String imgPath) {
		// QRCode 二维码图片的文件
		File imageFile = new File(imgPath);
		BufferedImage bufImg = null;
		String content = null;
		try {
			bufImg = ImageIO.read(imageFile);
			QRCodeDecoder decoder = new QRCodeDecoder();
			content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8"); 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (DecodingFailedException dfe) {
			System.out.println("Error: " + dfe.getMessage());
			dfe.printStackTrace();
		}
		return content;
	}
	
	/**
	 * 解析二维码（QRCode）
	 * @param input 输入流
	 * @return
	 */
	public static String decoderQRCode(InputStream input) {
		BufferedImage bufImg = null;
		String content = null;
		try {
			bufImg = ImageIO.read(input);
			QRCodeDecoder decoder = new QRCodeDecoder();
			content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8"); 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (DecodingFailedException dfe) {
			System.out.println("Error: " + dfe.getMessage());
			dfe.printStackTrace();
		}
		return content;
	}

    static class TwoDimensionCodeImage implements QRCodeImage {

		BufferedImage bufImg;
		
		public TwoDimensionCodeImage(BufferedImage bufImg) {
			this.bufImg = bufImg;
		}
		
		@Override
		public int getHeight() {
			return bufImg.getHeight();
		}

		@Override
		public int getPixel(int x, int y) {
			return bufImg.getRGB(x, y);
		}

		@Override
		public int getWidth() {
			return bufImg.getWidth();
		}

	}
	public static void main(String[] args) {
	    try{
            //encoderQRCode("http://www.baidu.com", new FileOutputStream(new File("E:\\lh_13.jpeg")),"png", 7);
            //先获取本项目的路径
            String savePath = ServletActionContext.getServletContext().getRealPath(
                    "")
                    + "/"; // 获取项目根路径
            savePath = savePath + ResourceUtil.getCompany_Img_Directory();
            //companyImgPath = ResourceUtil.getCompany_Img_Directory();
            File up = new File(savePath);
            if (!up.exists()) {
                up.mkdirs();
            }
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setCharacterEncoding("UTF-8"); // 务必，防止返回文件名是乱码
            encoderQRCode("http://www.baidu.com", savePath);
        }catch (Exception e){
	        e.printStackTrace();
        }

		//BufferedImage nnn = qRCodeCommon("figfdkg", "jpg", 7);
		//encoderQRCode("中阿萨德发生大发是打发斯蒂芬阿萨的发生地方", "E:\\test.jpg");
	}
}