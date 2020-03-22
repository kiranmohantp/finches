package com.finches.finchesservice.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Leader {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 3, max = 50, message = "minmax.name")
    private String name;
    @Pattern(regexp = "", message = "invalid.ip")
    private String ip;
    private Integer noOfFinchesAssigned;
    @NotNull(message = "notnull")
    private Integer maxCapacity;

    public Leader() {
    }

    public Leader(String id) {
        this.id = id;
    }

    public Leader(String id, String name, String ip, Integer noOfFinchesAssigned, Integer maxCapacity) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.noOfFinchesAssigned = noOfFinchesAssigned;
        this.maxCapacity = maxCapacity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public Integer getNoOfFinchesAssigned() {
        return noOfFinchesAssigned;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
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
