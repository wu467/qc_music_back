package top.wwqi.model.entity;

import java.io.Serializable;

/**
 * 系统通知栏实体
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 4227364879546435623L;

    private Integer id;
    private String content;
    private Boolean showNotice; //是否展示该条通知

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getShowNotice() {
        return showNotice;
    }

    public void setShowNotice(Boolean showNotice) {
        this.showNotice = showNotice;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", showNotice=" + showNotice +
                '}';
    }
}
