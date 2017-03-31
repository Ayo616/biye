package main.springapp.model;


import javax.persistence.*;
import java.io.Serializable;

/* *
 * 设备中的传感器数值和开关状态
 */

@Entity
public class Dfactor implements Serializable{

    private static final long serialVersionUID = 3921004226042659427L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "temperature")
    private Long temperature;

    @Column(name = "humidity")
    private Long humidity;

    @Column(name = "illumination")
    private Long illumination;

    @Column(name = "pm")
    private Long pm;

    @Column(name = "smoke")
    private  Long smoke;

    @Column(name = "room_light")
    private  Boolean room_light;

    @Column(name = "hall_light")
    private  Boolean hall_light;

    @Column(name = "airconditioner")
    private  Boolean airconditioner;

    @Column(name = "window")
    private  Boolean window;

    @Column(name = "video")
    private  Boolean video;

    @Column(name = "intelligence")
    private  Boolean intelligence;

    @Column(name = "rfid")
    private  Boolean rfid;

    @Column(name = "loops")
    private  Boolean loops;


    public Dfactor() {
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