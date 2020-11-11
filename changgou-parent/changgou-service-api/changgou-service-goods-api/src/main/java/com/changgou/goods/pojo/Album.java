package com.changgou.goods.pojo;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @ClassName Album
 * @Description 相册管理pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 14:44:00
 */
@Table(name = "tb_album")   //跟数据库的表建立关系
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//编号

    @Column(name = "title")
    private String title;//相册名称

    @Column(name = "image")
    private String image;//相册封面

    @Column(name = "image_items")
    private String imageItems;//图片列表

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageItems='" + imageItems + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageItems() {
        return imageItems;
    }

    public void setImageItems(String imageItems) {
        this.imageItems = imageItems;
    }
}
