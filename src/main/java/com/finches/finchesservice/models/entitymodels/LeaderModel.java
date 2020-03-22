package com.finches.finchesservice.models.entitymodels;

import com.finches.finchesservice.entities.Leader;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class LeaderModel {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 3, max = 50, message = "minmax.name")
    private String name;
    @Pattern(regexp = "", message = "invalid.ip")
    private String ip;
    private Integer noOfFinchesAssigned;
    @NotNull(message = "notnull")
    private Integer maxCapacity;

    public LeaderModel() {
    }

    public LeaderModel(String id) {
        this.id = id;
    }

    public LeaderModel(String id, String name, String ip, Integer noOfFinchesAssigned, Integer maxCapacity) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.noOfFinchesAssigned = noOfFinchesAssigned;
        this.maxCapacity = maxCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getNoOfFinchesAssigned() {
        return noOfFinchesAssigned;
    }

    public void setNoOfFinchesAssigned(Integer noOfFinchesAssigned) {
        this.noOfFinchesAssigned = noOfFinchesAssigned;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leader leader = (Leader) o;
        return Objects.equals(getId(), leader.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "LeaderModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", noOfFinchesAssigned=" + noOfFinchesAssigned +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
