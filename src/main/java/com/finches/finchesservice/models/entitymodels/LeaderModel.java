package com.finches.finchesservice.models.entitymodels;

import java.util.Objects;

public class LeaderModel {
    private String id;
    private String name;
    private String ip;

    public LeaderModel(String id, String name, String ip) {
        this.id = id;
        this.name = name;
        this.ip = ip;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaderModel leader = (LeaderModel) o;
        return Objects.equals(getId(), leader.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Leader{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
