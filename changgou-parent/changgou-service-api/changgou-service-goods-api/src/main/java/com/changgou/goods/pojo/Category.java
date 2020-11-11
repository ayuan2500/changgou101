package com.changgou.goods.pojo;

import javax.persistence.*;

/***
 * @ClassName Category
 * @Description 商品分页pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 17:21:00
 */
@Table(name = "tb_category")    //跟数据库的表建立关系
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //分类id

    @Column(name = "name")  //跟数据库的列建立关系
    private String name;    //分类名称

    @Column(name = "goods_num")
    private Integer goodsNum;   //商品数量

    @Column(name = "is_show")
    private String isShow;  //是否显示：0不显示，1显示

    @Column(name = "is_menu")
    private String isMenu;  //是否导航：0不导航，1导航

    @Column(name = "seq")
    private Integer seq;    //排序

    @Column(name = "parent_id")
    private Integer parentId;   //上级id

    @Column(name = "template_id")
    private Integer templateId; //模板id

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsNum=" + goodsNum +
                ", isShow='" + isShow + '\'' +
                ", isMenu='" + isMenu + '\'' +
                ", seq=" + seq +
                ", parentId=" + parentId +
                ", templateId=" + templateId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}
