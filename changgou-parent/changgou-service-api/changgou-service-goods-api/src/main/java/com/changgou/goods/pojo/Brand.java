package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @ClassName Brand
 * @Description 品牌pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:02:00
 */
@ApiModel(description = "Brand",value = "Brand")    //swagger注解
@Table(name="tb_brand") //跟数据库的表建立关系
public class Brand implements Serializable{

    @ApiModelProperty(value = "品牌id",required = false)
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //生成策略是自增
    @Column(name = "id")    //数据库表的列名
    private Integer id;//品牌id
    @ApiModelProperty(value = "品牌名称",required = false)
    @Column(name = "name")
    private String name;//品牌名称
    @ApiModelProperty(value = "品牌图片地址",required = false)
    @Column(name = "image")
    private String image;//品牌图片地址
    @ApiModelProperty(value = "品牌的首字母",required = false)
    @Column(name = "letter")
    private String letter;//品牌的首字母
    @ApiModelProperty(value = "排序",required = false)
    @Column(name = "seq")
    private Integer seq;//排序

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", letter='" + letter + '\'' +
                ", seq=" + seq +
                '}';
    }

    public Brand() {
    }

    public Brand(Integer id, String name, String image, String letter, Integer seq) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.letter = letter;
        this.seq = seq;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
