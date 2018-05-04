package com.qlzy.common.tools.imageUtil;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @Description
 * @author WangHuifeng
 * @date 2012-9-25 上午11:44:51
 */
public class ZoomImage {
    private static final Log log = LogFactory.getLog(ZoomImage.class);
    
    /**
     * 
     * @param filePath(E:/cfimg/userImg/NBCANH5PIOWX/9GZJO8QN1QWX.jpg)
     * @param outPutDir(E:/cfimg/userImg/NBCANH5PIOWX/9GZJO8QN1QWX-60-60.jpg)
     * @param height
     * @param width
     * @param replace 是否覆盖已有文件
     * @return 生成文件名
     * @throws Exception
     * @throws FileNotFoundException
     */
    public static void zoomImage(String filePath, String outPutFile, 
            int width, int height, boolean replace) 
            throws Exception, FileNotFoundException {
        File inPutFile = new File(filePath);
        File outPut = new File(outPutFile);
        zoomImage(inPutFile, outPut, width, height, replace);
    }
    
    public static void zoomImage(File inPutFile, File outPutFile, 
            int width, int height, boolean replace) 
            throws Exception, FileNotFoundException {
        if (!inPutFile.isFile()) {
            log.error("文件不存在:" + inPutFile);
            throw new FileNotFoundException("文件不存在:" + inPutFile);
        }
        if (!outPutFile.exists() || replace) {
            zoomImage(inPutFile, outPutFile, height, width);
        }
    }
    
    /**
     * 按指定大小缩放图片
     * @param inPutFile
     * @param outPutFile
     * @param height
     * @param width
     * @throws Exception
     */
    public static void zoomImage(File inPutFile, File outPutFile, 
            int width, int height) throws Exception {
        BufferedImage source = ImageIO.read(inPutFile);
        if (source == null) {
            return;
        }
        double hx = (double)height / source.getHeight();
        double wy = (double)width / source.getWidth();
        if (hx < wy) {
            wy = hx;
            width = (int)(source.getWidth() * wy);
        } else {
            hx = wy;
            height = (int)(source.getHeight() * hx);
        }
        
        int type = source.getType();
        BufferedImage target = null;
        if (type == BufferedImage.TYPE_CUSTOM) { // handmade
            ColorModel cm = source.getColorModel();
            WritableRaster raster = 
                cm.createCompatibleWritableRaster(width, height);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else {
            target = new BufferedImage(width, height, type);
        }
        Graphics2D g = target.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        g.drawRenderedImage(source, AffineTransform.getScaleInstance(wy, hx));
        g.dispose();

        try {
            ImageIO.write(target, "JPEG", outPutFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String arg[]) throws Exception {
        zoomImage("d:\\5.png", "d:\\61.jpg",170, 170, false);
    }
}