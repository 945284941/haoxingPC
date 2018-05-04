package com.qlzy.common.tools;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP上传工具类
 * 
 * @author icelove
 * 
 * connectServer();
 * if(!ftp.isDirExist(savePath)){
 * 		ftp.createDir(savePath);
 * }
 * ftp.cd(savePath);
 * ftp.upload(this.file.getPath(), request.getParameter("name"));
 * ftp.closeServer();
 * 
 */
@SuppressWarnings("all")
public class FtpUtil {
	private String ip = "";
	private String username = "";
	private String password = "";
	private int port = ResourceUtil.getFtpPort();
	private String path = "";
	private FTPClient ftpClient = null;
	private OutputStream os = null;
	private FileInputStream is = null;
	//String waterPath=ResourceUtil.getWebAppPath()+"../"+"water.png";
	
	private static final int ZOOM_SMALL_WIDTH = 200;
	public static final String ZOOM_SMALL_SUFFIX = "_s";
	private static final int ZOOM_MIDDLE_WIDTH = 400;
	public static final String ZOOM_MIDDLE_SUFFIX = "_m";

	public FtpUtil(String serverIP, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
	}

	public FtpUtil(String serverIP, int port, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	/**
	 * 连接ftp服务器
	 * 
	 * @throws IOException
	 */
	public boolean connectServer() {
		ftpClient = new FTPClient();
		try {
			if (this.port != -1) {
				ftpClient.connect(this.ip, this.port);
			} else {
				ftpClient.connect(this.ip);
			}
			ftpClient.login(this.username, this.password);
			if (this.path.length() != 0) {
				ftpClient.changeWorkingDirectory(this.path);// path是ftp服务下主目录的子目录
			}
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
//			System.out.println("已登录到\"" + ftpClient.pwd() + "\"目录");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 断开与ftp服务器连接
	 * 
	 * @throws IOException
	 */
	public boolean closeServer() {
		try {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			if (ftpClient != null) {
				ftpClient.disconnect();
			}
//			System.out.println("已从服务器断开");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 检查文件夹在当前目录下是否存在
	 * 
	 * @param dir
	 * @return
	 */
	public boolean isDirExist(String dir) {
		boolean flag = false;
		try {
			ftpClient.changeWorkingDirectory("/");
			flag = ftpClient.changeWorkingDirectory(ResourceUtil.getFtpRootPath() + dir);
		} catch (Exception e) {
			return false;
		}
		return flag;
	}

	/**
	* @Title: pwd
	* @Description: 跳转到这个页面
	* @param @param dir
	* @param @return    设定文件
	* @return boolean    返回类型
	*/
	public boolean cd(String dir){
		boolean flag = false;
		try {
			ftpClient.changeWorkingDirectory("/");
			flag = ftpClient.changeWorkingDirectory(ResourceUtil.getFtpRootPath() + dir);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 在当前目录下创建文件夹
	 * 
	 * @param dir
	 * @return
	 * @throws Exception
	 */
	public boolean createDir(String dir) {
		try {
			ftpClient.changeWorkingDirectory("/");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean flag = true;
		try {
			String path = ResourceUtil.getFtpRootPath() +  dir;
			if(path != null && path.length()>0) {
				String[] paths = path.replaceAll("[\\\\/]+", "/").replaceAll("^/|/$", "").split("/");
				for(int i=0; flag&&i<paths.length; i++) {
					if(!ftpClient.changeWorkingDirectory(paths[i])) {
						flag = ftpClient.makeDirectory(paths[i]);
						if(flag) {
							ftpClient.changeWorkingDirectory(paths[i]);
						}
					}
				}
			}
		} catch (IOException e) {
			flag = false;
			throw new RuntimeException("创建远程目录失败", e);
		} finally {
			try {
				ftpClient.changeWorkingDirectory("/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * ftp上传 如果服务器段已存在名为filename的文件夹，该文件夹中与要上传的文件夹中同名的文件将被替换
	 * 
	 * @param filename
	 *            要上传的文件（或文件夹）名
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public boolean upload(String filename) {
		String newname = "";
		if (filename.indexOf("/") > -1) {
			newname = filename.substring(filename.lastIndexOf("/") + 1);
		} else {
			newname = filename;
		}
		return upload(filename, newname);
	}

	/**
	 * ftp上传 如果服务器段已存在名为newName的文件夹，该文件夹中与要上传的文件夹中同名的文件将被替换
	 * 
	 * @param fileName
	 *            要上传的文件（或文件夹）名
	 * @param newName
	 *            服务器段要生成的文件（或文件夹）名
	 * @return
	 */
	public boolean upload(String fileName, String newName) {
		boolean flag = false;
		try {
			String savefilename = new String(fileName.getBytes("ISO-8859-1"), "GBK");
			File file_in = new File(savefilename);// 打开本地待长传的文件
			if (!file_in.exists() || file_in.isDirectory()) {
				throw new Exception("此文件或文件夹[" + file_in.getName() + "]有误或不存在!");
			}
			uploadFile(file_in.getPath(), newName);

			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception e in Ftp upload(): " + e.toString());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream middle = null;
		InputStream small = null;
		try {
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
			if(Arrays.asList(ResourceUtil.getKindeditorUploadFileExts().split(",")).contains(fileExt)) {
				File file = new File(fileName);
				String name = newName.substring(0, newName.lastIndexOf("."));
				middle = ImageUtils.zoom(file, ZOOM_MIDDLE_WIDTH);
				this.upload(middle, name + ZOOM_MIDDLE_SUFFIX + "." + fileExt);
				small = ImageUtils.zoom(file, ZOOM_SMALL_WIDTH);
				this.upload(small, name + ZOOM_SMALL_SUFFIX + "." + fileExt);
			}
		} catch (Exception e) {
			System.out.println("生成图片缩略图失败");
		} finally {
			if(middle != null) {
				try {
					middle.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(small != null) {
				try {
					small.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	/**
	 * 真正用于上传的方法
	 * 
	 * @param fileName
	 * @param newName
	 * @param path
	 * @throws Exception
	 */
	@Deprecated
	public void upload(String fileName, String newName, String path)
			throws Exception {
		String savefilename = new String(fileName.getBytes("ISO-8859-1"), "GBK");
		File file_in = new File(savefilename);// 打开本地待长传的文件
		if (!file_in.exists()) {
			throw new Exception("此文件或文件夹[" + file_in.getName() + "]有误或不存在!");
		}
		if (file_in.isDirectory()) {
			if (!isDirExist(newName)) {
				createDir(newName);
			}
//			ftpClient.cd(newName);//切换到这个目录
			File sourceFile[] = file_in.listFiles();
			for (int i = 0; i < sourceFile.length; i++) {
				if (!sourceFile[i].exists()) {
					continue;
				}
				if (sourceFile[i].isDirectory()) {
					this.upload(sourceFile[i].getPath(),
							sourceFile[i].getName(), path + "/" + newName);
				} else {
					this.uploadFile(sourceFile[i].getPath(),
							sourceFile[i].getName());
				}
			}
		} else {
			uploadFile(file_in.getPath(), newName);
		}
//		ftpClient.cd(path);
	}

	/**
	 * upload 上传文件
	 * 
	 * @param filename
	 *            要上传的文件名
	 * @param newname
	 *            上传后的新文件名
	 * @return -1 文件不存在 >=0 成功上传，返回文件的大小
	 * @throws Exception
	 */
	@Deprecated
	public long uploadFile(String filename, String newname) throws Exception {
		long result = 0;
		
		FileInputStream in = null;
		try {
			File file_in = new java.io.File(filename);
			in = new FileInputStream(filename);
			upload(in, newname);
			result = file_in.length();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
		}
		
		return result;
	}
	
	public void upload(InputStream in, String newname) throws Exception {
		try {
			ftpClient.storeFile(newname, in);
		} catch (Exception e) {}
	}

	/**
	 * 从ftp下载文件到本地
	 * 
	 * @param filename
	 *            服务器上的文件名
	 * @param newfilename
	 *            本地生成的文件名
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public long downloadFile(String filename, String newfilename) {
		long result = 0;
//		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {
//			is = ftpClient.get(filename);
			java.io.File outfile = new java.io.File(newfilename);
			System.out.println(outfile.getPath());
			os = new FileOutputStream(outfile);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
				result = result + c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 取得相对于当前连接目录的某个目录下所有文件列表
	 * 
	 * @param path
	 * @return
	 */
	@Deprecated
	public List getFileList(String path) {
		List list = new ArrayList();
		DataInputStream dis;
//		try {
//			dis = new DataInputStream(ftpClient.nameList(this.path + path));
//			String filename = "";
//			while ((filename = dis.readLine()) != null) {
//				list.add(filename);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return list;
	}

	public static void main(String[] args) {
		FtpUtil ftp = new FtpUtil("127.0.0.1", "admin", "123456");
		ftp.connectServer();
//		boolean result = ftp.upload("C:/a/test_why.txt", "attached/temp11/wocao111.txt");
//		System.out.println(result ? "上传成功！" : "上传失败！");
//		List list = ftp.getFileList("test");
//		for (int i = 0; i < list.size(); i++) {
//			String name = list.get(i).toString();
//			System.out.println(name);
//		}
		ftp.cd("/attached/water");
		ftp.downloadFile("water.png", "c:/aa.jpg");
		ftp.closeServer();
		/**
		 * FTP远程命令列表 USER PORT RETR ALLO DELE SITE XMKD CDUP FEAT PASS PASV STOR
		 * REST CWD STAT RMD XCUP OPTS ACCT TYPE APPE RNFR XCWD HELP XRMD STOU
		 * AUTH REIN STRU SMNT RNTO LIST NOOP PWD SIZE PBSZ QUIT MODE SYST ABOR
		 * NLST MKD XPWD MDTM PROT
		 * 在服务器上执行命令,如果用sendServer来执行远程命令(不能执行本地FTP命令)的话，所有FTP命令都要加上\r\n
		 * ftpclient.sendServer("XMKD /test/bb\r\n"); //执行服务器上的FTP命令
		 * ftpclient.readServerResponse一定要在sendServer后调用
		 * nameList("/test")获取指目录下的文件列表 XMKD建立目录，当目录存在的情况下再次创建目录时报错 XRMD删除目录
		 * DELE删除文件
		 */
	}
}
