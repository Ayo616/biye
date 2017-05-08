package main.springapp.dto;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class UserDevicedDTO {

    private long user_id;
    
    private long device_id;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }
}
