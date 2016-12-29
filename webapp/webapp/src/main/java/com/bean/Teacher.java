package com.bean;

/**
 * Created by 聪 on 2016/12/14.
 */
public class Teacher {

   /* JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
        TABLE：使用一个特定的数据库表格来保存主键。
        SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
        IDENTITY：主键由数据库自动生成（主要是自动增长型）
        AUTO：主键由程序控制。
   */

    private Integer id;
    //教室工号
    private int teachNO;

    private String teachName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTeachNO() {
        return teachNO;
    }

    public void setTeachNO(int teachNO) {
        this.teachNO = teachNO;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

}
