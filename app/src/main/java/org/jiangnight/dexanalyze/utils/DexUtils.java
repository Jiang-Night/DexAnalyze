package org.jiangnight.dexanalyze.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author JiangNight
 * @date 2023-08-09 14:24
 * @ClassName DexUtils
 * @Description Dex操作工具类
 */

public class DexUtils {
    /***
     *
     * @param DexPath /sdcard + /DexPath
     * @return 返回dex文件字节
     */
    private  byte[] dexSrc; //dex字节数据
    private int len;//dex字节数据大小
    private int RemainSize;//剩余需要读的大小

    public int getRemainSize() {
        return RemainSize;
    }

    public void setRemainSize(int remainSize) {
        RemainSize = remainSize;
    }

    public int getLen() {
        return len;
    }

    public  void setDexSrc(byte[] dexSrc) {
        this.dexSrc = dexSrc;
        this.len = dexSrc.length;
    }

    public byte[] GetDex(String DexPath){
        String path = getSDPath() + DexPath;
        File file = new File(path);
        byte[] srcByte = null;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            outputStream = new FileOutputStream(file);
            outputStream.write(b);
            srcByte = b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (srcByte == null) {
            LogUtils.LOG("获取失败 字节为空");
        }
        LogUtils.LOG("file.length()=="+file.length());
        return srcByte;
    }

    public String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist)
            sdDir = Environment.getExternalStorageDirectory();
        return sdDir.toString();
    }



    /***
     *
     * @param start 起始位置
     * @param length 需要读的长度
     * @return 读出来的结果
     */
    public byte[] ReadByte(int start,int length){
        if (dexSrc==null || start > dexSrc.length || (start + length) > dexSrc.length || start < 0 || length < 0){
            return null;
        }
        byte[] result = new byte[length];
        for (int i = 0; i <length ; i++) {
            result[i] =  dexSrc[i+start];
        }
        this.RemainSize -= length;
        return result;
    }

    public int byteToInt(byte[] res) {
        int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00)
                | ((res[2] << 24) >>> 8) | (res[3] << 24);
        return targets;
    }

    public String bytesToHexString(byte[] src){
        //byte[] src = reverseBytes(src1);
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv+" ");
        }
        return stringBuilder.toString();
    }

}
