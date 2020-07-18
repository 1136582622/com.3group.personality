package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blog implements Serializable {
    private int blogid;  //id
    private String title; //标题
    private String content; //内容
    private List<String> imgName = new ArrayList<String>();
    private String imgNameStr;
    private String time;    //发表时间
    private String type;   //类型
    private int commentNum;//评论数
    private int heatNum;  //热度
    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgName() {
        return imgName;
    }

    public void setImgName(List<String> imgName) {
        this.imgName = imgName;
    }

    public String getImgNameStr() {
        return imgNameStr;
    }

    public void setImgNameStr(String imgNameStr) {
        this.imgNameStr = imgNameStr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getHeatNum() {
        return heatNum;
    }

    public void setHeatNum(int heatNum) {
        this.heatNum = heatNum;
    }
    @Override
    public String toString() {
        return "Blog{" +
                "blogid=" + blogid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgName=" + imgName +
                ", imgNameStr='" + imgNameStr + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", commentNum=" + commentNum +
                ", heatNum=" + heatNum +
                '}';
    }
}
