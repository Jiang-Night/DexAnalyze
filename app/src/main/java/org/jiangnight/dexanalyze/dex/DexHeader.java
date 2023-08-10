package org.jiangnight.dexanalyze.dex;

/**
 * @author JiangNight
 * @date 2023-08-09 20:17
 * @ClassName
 * @Description
 */
public class DexHeader {
    private static volatile DexHeader DexHeaderInstance;
    private DexHeader(){}
    private byte[] magic;//dex版本标识
    private byte[] checksum;//adler32检验
    private byte[] signature;//SHA-1哈希值
    private byte[] fileSize;//整个文件的大小
    private byte[] headerSize;//DexHeader结构大小
    private byte[] endianTag;//字节序标记
    private byte[] linkSize;//链接段大小
    private byte[] linkOff;//链接段偏移
    private byte[] mapOff;//DexStringId的个数
    private byte[] stringIdsSize;//DexStringIds的个数
    private byte[] stringIdsOff;//DexStringId的文件偏移
    private byte[] typeIdsSize;//DexTypeId的个数
    private byte[] typeIdsOff;//DexTypeId的文件偏移
    private byte[] fieldIdsSize;//DexFieldId的个数
    private byte[] fieldIdsOff;//DexFieldId的文件偏移
    private byte[] methodIdsSize;//DexMethodId的个数
    private byte[] methodIdsOff;//DexMethodId的文件偏移
    private byte[] classDefsSize;//DexClassDef的个数
    private byte[] classDefsOff;//DexClassDef的文件偏移
    private byte[] dataSize;//数据段的大小
    private byte[] dataOff;//数据段的文件偏移

    public byte[] getMagic() {
        return magic;
    }

    public void setMagic(byte[] magic) {
        this.magic = magic;
    }

    public byte[] getChecksum() {
        return checksum;
    }

    public void setChecksum(byte[] checksum) {
        this.checksum = checksum;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getFileSize() {
        return fileSize;
    }

    public void setFileSize(byte[] fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(byte[] headerSize) {
        this.headerSize = headerSize;
    }

    public byte[] getEndianTag() {
        return endianTag;
    }

    public void setEndianTag(byte[] endianTag) {
        this.endianTag = endianTag;
    }

    public byte[] getLinkSize() {
        return linkSize;
    }

    public void setLinkSize(byte[] linkSize) {
        this.linkSize = linkSize;
    }

    public byte[] getLinkOff() {
        return linkOff;
    }

    public void setLinkOff(byte[] linkOff) {
        this.linkOff = linkOff;
    }

    public byte[] getMapOff() {
        return mapOff;
    }

    public void setMapOff(byte[] mapOff) {
        this.mapOff = mapOff;
    }

    public byte[] getStringIdsSize() {
        return stringIdsSize;
    }

    public void setStringIdsSize(byte[] stringIdsSize) {
        this.stringIdsSize = stringIdsSize;
    }

    public byte[] getStringIdsOff() {
        return stringIdsOff;
    }

    public void setStringIdsOff(byte[] stringIdsOff) {
        this.stringIdsOff = stringIdsOff;
    }

    public byte[] getTypeIdsSize() {
        return typeIdsSize;
    }

    public void setTypeIdsSize(byte[] typeIdsSize) {
        this.typeIdsSize = typeIdsSize;
    }

    public byte[] getTypeIdsOff() {
        return typeIdsOff;
    }

    public void setTypeIdsOff(byte[] typeIdsOff) {
        this.typeIdsOff = typeIdsOff;
    }

    public byte[] getFieldIdsSize() {
        return fieldIdsSize;
    }

    public void setFieldIdsSize(byte[] fieldIdsSize) {
        this.fieldIdsSize = fieldIdsSize;
    }

    public byte[] getFieldIdsOff() {
        return fieldIdsOff;
    }

    public void setFieldIdsOff(byte[] fieldIdsOff) {
        this.fieldIdsOff = fieldIdsOff;
    }

    public byte[] getMethodIdsSize() {
        return methodIdsSize;
    }

    public void setMethodIdsSize(byte[] methodIdsSize) {
        this.methodIdsSize = methodIdsSize;
    }

    public byte[] getMethodIdsOff() {
        return methodIdsOff;
    }

    public void setMethodIdsOff(byte[] methodIdsOff) {
        this.methodIdsOff = methodIdsOff;
    }

    public byte[] getClassDefsSize() {
        return classDefsSize;
    }

    public void setClassDefsSize(byte[] classDefsSize) {
        this.classDefsSize = classDefsSize;
    }

    public byte[] getClassDefsOff() {
        return classDefsOff;
    }

    public void setClassDefsOff(byte[] classDefsOff) {
        this.classDefsOff = classDefsOff;
    }

    public byte[] getDataSize() {
        return dataSize;
    }

    public void setDataSize(byte[] dataSize) {
        this.dataSize = dataSize;
    }

    public byte[] getDataOff() {
        return dataOff;
    }

    public void setDataOff(byte[] dataOff) {
        this.dataOff = dataOff;
    }

    //双重检查单例模式
    public static DexHeader getDexHeaderInstance(){
        if (DexHeaderInstance == null){
            synchronized (DexHeader.class){
                if (DexHeaderInstance==null){
                    DexHeaderInstance = new DexHeader();
                }
            }
        }
        return DexHeaderInstance;
    }
}
