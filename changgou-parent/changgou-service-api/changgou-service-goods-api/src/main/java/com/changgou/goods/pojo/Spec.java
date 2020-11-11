package com.changgou.goods.pojo;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @ClassName Spec
 * @Description 规格pojo类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:25:00
 */
@Table(name = "tb_spec")    //跟数据库的表建立关系
public class Spec implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //id

    @Column(name = "name")
    private String name;    //参数名称

    @Column(name = "options")
    private String options; //规则选项

    @Column(name = "seq")
    private Integer seq;    //排序

    @Column(name = "template_id")
    private Integer templateId; //模板id

    @Override
    public String toString() {
        return "Spec{" +
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
