package edu.sspu.bike.model;

import java.io.Serializable;

/**
 * 用于封装后端返回前端数据对象,返回restful风格返回值
 *
 * @auther 杨亚龙
 * @date 2019/11/4 15:47
 */
public class ResultInfo implements Serializable {
    private boolean flag=false; //后端返回结果正常为true，发生异常返回false
    private Object data;    //后端返回结果数据对象
    private String errorMsg;

    public ResultInfo() {
    }

    /**
     * 有参构造方法
     *
     * @param flag
     */
    public ResultInfo(boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(Object data, String errorMsg) {
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public Object getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
