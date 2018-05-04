package com.qlzy.common.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qlzy.exception.ApplicationException;

/**
 * 文件操作类
 * 
 * @author Huifeng Wang
 * 
 */
public class FileUtil {

	private static final Logger logger = Logger.getLogger(FileUtil.class);

	private static final int BUFFER = 1024;

	/**
	 * 功 能: 拷贝文件(只能拷贝文件)
	 * 
	 * @param strSourceFileName
	 *            指定的文件全路径名
	 * @param strDestDir
	 *            拷贝到指定的文件夹
	 * @return 如果成功true;否则false
	 */
	public boolean copyTo(String strSourceFileName, String strDestDir) {
		File fileSource = new File(strSourceFileName);
		File fileDest = new File(strDestDir);

		// 如果源文件不存或源文件是文件夹
		if (!fileSource.exists() || !fileSource.isFile()) {
			logger.debug("源文件[" + strSourceFileName + "],不存在或是文件夹!");
			return false;
		}

		// 如果目标文件夹不存在
		if (!fileDest.isDirectory() || !fileDest.exists()) {
			if (!fileDest.mkdirs()) {
				logger.debug("目录文件夹不存，在创建目标文件夹时失败!");
				return false;
			}
		}

		try {
			String strAbsFilename = strDestDir + File.separator
					+ fileSource.getName();

			FileInputStream fileInput = new FileInputStream(strSourceFileName);
			FileOutputStream fileOutput = new FileOutputStream(strAbsFilename);

			logger.debug("开始拷贝文件:");

			int count = -1;

			long nWriteSize = 0;
			long nFileSize = fileSource.length();

			byte[] data = new byte[BUFFER];

			while (-1 != (count = fileInput.read(data, 0, BUFFER))) {

				fileOutput.write(data, 0, count);

				nWriteSize += count;

				long size = (nWriteSize * 100) / nFileSize;
				long t = nWriteSize;

				String msg = null;

				if (size <= 100 && size >= 0) {
					msg = "\r拷贝文件进度:   " + size + "%   \t" + "\t   已拷贝:   " + t;
					logger.debug(msg);
				} else if (size > 100) {
					msg = "\r拷贝文件进度:   " + 100 + "%   \t" + "\t   已拷贝:   " + t;
					logger.debug(msg);
				}

			}

			fileInput.close();
			fileOutput.close();

			logger.debug("拷贝文件成功!");
			return true;

		} catch (Exception e) {
			logger.debug("异常信息：[");
			logger.error(e);
			logger.debug("]");
			return false;
		}
	}
	/**
	 * 功 能: 拷贝文件(只能拷贝文件)
	 * 
	 * @param strSourceFileName
	 *            指定的文件全路径名
	 * @param strDestDir
	 *            拷贝到指定的文件夹
	 * @return 如果成功true;否则false
	 */
	public static boolean copyFile(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.exists() || !srcFile.isFile() || !srcFile.canRead()) {
			throw new FileNotFoundException(srcFile.getAbsolutePath());
		}
		if (!destFile.exists()) {
			if (destFile.getParentFile() != null) {
				destFile.getParentFile().mkdirs();
			}
			destFile.createNewFile();
		} else if (destFile.isDirectory()) {
			destFile = new File(destFile, srcFile.getName());
		}

		if (srcFile.equals(destFile)) {
			return false;
		}

		FileChannel src = null;
		FileChannel dst = null;

		try {
			src = new FileInputStream(srcFile).getChannel();
			dst = new FileOutputStream(destFile).getChannel();
			long total = src.size();
			long curr = 0L;
			do {
				// curr += src.transferTo(curr, total - curr, dst);
				curr += dst.transferFrom(src, curr, total - curr);
			} while (curr < total);
		} finally {
			if (src != null) {
				try {
					src.close();
				} catch (Exception e) {
				}
			}
			if (dst != null) {
				try {
					dst.close();
				} catch (Exception e) {
				}
			}
			destFile.setLastModified(srcFile.lastModified());
		}
		return true;
	}
	/**
	 * 复制文件夹下所有文件到指定的文件夹
	 * @param srcFile
	 * @param destFile
	 * @return
	 * @throws IOException
	 */
	public static void copyFileRecursively(File src, File dst)
			throws IOException {
		if (src == null) {
			throw new IllegalArgumentException("src null");
		}

		if (dst == null) {
			throw new IllegalArgumentException("dst null");
		}

		if (src.equals(dst)) {
			return;
		}

		if (!src.exists() || !src.canRead()) {
			throw new IllegalStateException("File: " + src.getAbsolutePath()
					+ " can't read or exist");
		}

		if (src.isDirectory() && dst.isFile()) {
			throw new IllegalStateException("File: " + src.getAbsolutePath()
					+ " is directory while File: " + dst.getAbsolutePath()
					+ " is file");
		}

		if (!dst.exists() && dst.isDirectory()) {
			System.out.println("create dst >>> " + dst.getAbsolutePath());
			dst.getParentFile().mkdirs();
			dst.mkdir();
		}

		if (src.isDirectory()) {
			File[] files = src.listFiles();
			for (File file : files) {
				copyFileRecursively(file, new File(dst, file.getName()));
			}
		} else {
			System.out.println("copy from {" + src.getAbsolutePath() + " to "
					+ dst.getAbsolutePath() + "}");
			copyFile(src, dst);
		}
	}

	/**
	 * 删除指定的文件
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
			logger.debug("错误: " + strFileName + "不存在!");
			return false;
		}

		return fileDelete.delete();
	}

	/**
	 * 移动文件(只能移动文件)
	 * 
	 * @param strSourceFileName
	 *            是指定的文件全路径名
	 * @param strDestDir
	 *            移动到指定的文件夹中
	 * @return 如果成功true; 否则false
	 */
	public boolean moveFile(String strSourceFileName, String strDestDir) {
		if (copyTo(strSourceFileName, strDestDir))
			return delete(strSourceFileName);
		else
			return false;
	}

	/**
	 * 创建文件夹
	 * 
	 * @param strDir
	 *            要创建的文件夹名称
	 * @return 如果成功true;否则false
	 */
	public boolean makedir(String strDir) {
		File fileNew = new File(strDir);

		if (!fileNew.exists()) {
			logger.debug("文件夹不存在--创建文件夹");
			return fileNew.mkdirs();
		} else {
			logger.debug("文件夹存在");
			return true;
		}
	}

	/**
	 * 删除文件夹
	 * 
	 * @param strDir
	 *            要删除的文件夹名称
	 * @return 如果成功true;否则false
	 */
	public boolean rmdir(String strDir) {
		File rmDir = new File(strDir);
		if (rmDir.isDirectory() && rmDir.exists()) {
			String[] fileList = rmDir.list();

			for (int i = 0; i < fileList.length; i++) {
				String subFile = strDir + File.separator + fileList[i];
				File tmp = new File(subFile);
				if (tmp.isFile())
					tmp.delete();
				else if (tmp.isDirectory())
					rmdir(subFile);
				else {
					logger.debug("error!");
				}
			}
			rmDir.delete();
		} else
			return false;
		return true;
	}
	
	/**
	 * 功能说明：附件下载
	 * 
	 * @param request
	 * @param response
	 * @param accessoryPath
	 *            附件相对路径
	 * @param fileName
	 *            下载的附件名称
	 * @param isOnLine
	 *            是否在线打开
	 * @throws ApplicationException
	 * @time Dec 7, 2010 11:18:39 AM
	 */
	public static String downloadFile(HttpServletRequest request,
			HttpServletResponse response,String fileName, boolean isOnLine)
			throws ApplicationException {
		String path="../download/"+fileName;//从页面获取要下载的文件的相对路径
		String filePath = ResourceUtil.getWebAppPath()+path;
		FileInputStream fis = null;
		BufferedInputStream bufInStream = null;
		OutputStream outStream = null;
		try {
			File file = new File(filePath);
			if (!file.exists())
				throw new ApplicationException("对不起，文件" + fileName + "找不到.");
			fis = new FileInputStream(file);
			bufInStream = new BufferedInputStream(fis);
			String nameStr = new String(fileName.getBytes("GBK"), "ISO8859-1")
					+ "\"";
			response.reset();
			if (isOnLine) {// 在线打开方式
				URL u = new URL("file:///" + filePath);
				response.setContentType(u.openConnection().getContentType());
				response.setHeader("Content-Disposition", "inline; filename="
						+ nameStr);
			} else {// 纯下载方式
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + nameStr);
			}
			byte[] buffer = new byte[10240];
			int len = 0;
			outStream = response.getOutputStream();
			while ((len = bufInStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, len);
				outStream.flush();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (bufInStream != null)
					bufInStream.close();
				// if(outStream != null)
				// outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		File t=new File("E:\\test1");
		File s=new File("E:\\test2");
		copyFileRecursively(t,s);
	}
}
