package org.jiangnight.dexanalyze.dex;


/**
 * @author JiangNight
 * @date 2023-08-09 15:12
 * @ClassName DexStruct
 * @Description Dex结构类
 */
public class DexStruct {
    DexHeader dexHeader;
    public DexHeader GetDexHeader() {
        dexHeader = DexHeader.getDexHeaderInstance();
        return dexHeader;
    }

}