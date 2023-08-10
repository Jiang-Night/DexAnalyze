package org.jiangnight.dexanalyze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import org.jiangnight.dexanalyze.adapter.MyAdapter;
import org.jiangnight.dexanalyze.bean.Item;
import org.jiangnight.dexanalyze.dex.DexHeader;
import org.jiangnight.dexanalyze.dex.DexStruct;
import org.jiangnight.dexanalyze.utils.DexUtils;
import org.jiangnight.dexanalyze.utils.LogUtils;
import org.jiangnight.dexanalyze.utils.PermissionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiangNight
 * @date 2023-08-09 12:06
 * @ClassName MainActivity
 * @Description 主启动类
 */


public class MainActivity extends AppCompatActivity{

    DexUtils dexUtils;//dex操作类
    DexStruct dexStruct;//dex结构获取
    DexHeader dexHeader;//Header结构
    RecyclerView mRecyclerView;
    List<Item> list = new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionHelper.checkPermission(this);//获取文件访问权限
        init();//初始化
        int TotalSize = dexUtils.getLen();//文件总大小
        dexUtils.setRemainSize(TotalSize);

        byte magic[] = dexUtils.ReadByte(0,8);
        dexHeader.setMagic(magic);
        addItem("magic",magic);
        LogUtils.LOG("magic  size->"+dexUtils.getRemainSize() +"data->"+dexUtils.bytesToHexString(magic));

        byte[] checksumByte = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setChecksum(checksumByte);
        addItem("checksumByte",checksumByte);
        LogUtils.LOG("checksumByte  size->"+dexUtils.getRemainSize()+"data->"+dexUtils.bytesToHexString(checksumByte));

        byte[] signature = dexUtils.ReadByte(dexUtils.getRemainSize(),20);
        dexHeader.setSignature(signature);
        addItem("signature",signature);
        LogUtils.LOG("signature  size->"+dexUtils.getRemainSize()+"data->"+dexUtils.bytesToHexString(signature));

        byte[] fileSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setFileSize(fileSize);
        addItem("fileSize",fileSize);

        byte[] headerSize  = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setHeaderSize(headerSize);
        addItem("headerSize",headerSize);

        byte[] endianTag = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(endianTag);
        addItem("endianTag",endianTag);

        byte[] linkSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(linkSize);
        addItem("linkSize",linkSize);

        byte[] linkOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(linkOff);
        addItem("linkOff",linkOff);

        byte[] mapOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(mapOff);
        addItem("mapOff",mapOff);

        byte[] stringIdsSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(stringIdsSize);
        addItem("stringIdsSize",stringIdsSize);

        byte[] stringIdsOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(stringIdsOff);
        addItem("stringIdsOff",stringIdsOff);

        byte[] typeIdsSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(typeIdsSize);
        addItem("typeIdsSize",typeIdsSize);

        byte[] typeIdsOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(typeIdsOff);
        addItem("typeIdsOff",typeIdsOff);

        byte[] fieldIdsSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(fieldIdsSize);
        addItem("fieldIdsSize",fieldIdsSize);

        byte[] fieldIdsOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(fieldIdsOff);
        addItem("fieldIdsOff",fieldIdsOff);

        byte[] methodIdsSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(methodIdsSize);
        addItem("methodIdsSize",methodIdsSize);

        byte[] methodIdsOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(methodIdsOff);
        addItem("methodIdsOff",methodIdsOff);

        byte[] classDefsSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(classDefsSize);
        addItem("classDefsSize",classDefsSize);

        byte[] classDefsOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(classDefsOff);
        addItem("classDefsOff",classDefsOff);

        byte[] dataSize = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(dataSize);
        addItem("dataSize",dataSize);

        byte[] dataOff = dexUtils.ReadByte(dexUtils.getRemainSize(),4);
        dexHeader.setEndianTag(dataOff);
        addItem("dataOff",dataOff);

        MyAdapter myAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(myAdapter);
    }


    private void init(){
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(this);//初始化RecyclerView
        mRecyclerView.setLayoutManager(layoutManager);
        dexUtils = new DexUtils();
        dexStruct = new DexStruct();
        dexHeader =  dexStruct.GetDexHeader();
        byte[] dexSrc = dexUtils.GetDex("/Dex/classes.dex");
        dexUtils.setDexSrc(dexSrc);
    }


    public void addItem(String name,byte[] src){
        Item item = new Item(name, dexUtils.bytesToHexString(src));
        list.add(item);
    }

}