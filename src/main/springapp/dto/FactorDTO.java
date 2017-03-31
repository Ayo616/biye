package main.springapp.dto;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class FactorDTO {


    private Long id;


    private Long temperature;


    private Long humidity;


    private Long illumination;


    private Long pm;

    private  Long smoke;


    private  Boolean room_light;


    private  Boolean hall_light;


    private  Boolean airconditioner;


    private  Boolean window;


    private  Boolean video;


    private  Boolean intelligence;


    private  Boolean rfid;


    private  Boolean loops;

    public FactorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getIllumination() {
        return illumination;
    }

    public void setIllumination(Long illumination) {
        this.illumination = illumination;
    }

    public Long getPm() {
        return pm;
    }

    public void setPm(Long pm) {
        this.pm = pm;
    }

    public Long getSmoke() {
        return smoke;
    }

    public void setSmoke(Long smoke) {
        this.smoke = smoke;
    }

    public Boolean getRoom_light() {
        return room_light;
    }

    public void setRoom_light(Boolean room_light) {
        this.room_light = room_light;
    }

    public Boolean getHall_light() {
        return hall_light;
    }

    public void setHall_light(Boolean hall_light) {
        this.hall_light = hall_light;
    }

    public Boolean getAirconditioner() {
        return airconditioner;
    }

    public void setAirconditioner(Boolean airconditioner) {
        this.airconditioner = airconditioner;
    }

    public Boolean getWindow() {
        return window;
    }

    public void setWindow(Boolean window) {
        this.window = window;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Boolean getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Boolean intelligence) {
        this.intelligence = intelligence;
    }

    public Boolean getRfid() {
        return rfid;
    }

    public void setRfid(Boolean rfid) {
        this.rfid = rfid;
    }

    public Boolean getLoops() {
        return loops;
    }

    public void setLoops(Boolean loops) {
        this.loops = loops;
    }
}
