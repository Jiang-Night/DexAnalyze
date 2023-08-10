package org.jiangnight.dexanalyze.bean;

/**
 * @author JiangNight
 * @date 2023-08-10 13:36
 * @ClassName
 * @Description RecyclerView实体类
 */
public class Item {
    public String name;
    public String hex;

    public Item(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }
}
