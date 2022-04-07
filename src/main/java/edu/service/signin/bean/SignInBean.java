package edu.service.signin.bean;

public class SignInBean {

    private int id;

    private int userId;

    private int activityId;

    private long createTime;

    public SignInBean(int id, int userId, int activityId, long createTime) {
        this.id = id;
        this.userId = userId;
        this.activityId = activityId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
