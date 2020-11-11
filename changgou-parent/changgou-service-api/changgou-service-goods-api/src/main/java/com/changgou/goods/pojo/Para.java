package com.changgou.goods.pojo;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @ClassName Para
 * @Description 参数pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:41:00
 */
@Table(name = "tb_para")    //跟数据库的表建立关系
public class Para implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //id

    @Column(name = "name")
    private String name;    //名称

    @Column(name = "options")
    private String options; //选项

    @Column(name = "seq")
    private Integer seq;    //排序

    @Column(name = "template_id")
    private Integer templateId; //模板id

    @Override
    public String toString() {
        return "Para{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", options='" + options + '\'' +
                ", seq=" + seq +
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}
