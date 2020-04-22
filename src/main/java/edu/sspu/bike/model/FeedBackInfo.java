package edu.sspu.bike.model;

/**
 * 反馈信息类
 *
 * @auther 杨亚龙
 * @date 2019/11/8 22:47
 */
public class FeedBackInfo {
    private int id;
    private String content;     //内容
    private String stuId;
    private String name;

    public FeedBackInfo() {
    }

    public FeedBackInfo(String content, String stuId, String name) {
        this.content = content;
        this.stuId = stuId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FeedBackInfo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
