package com.finches.finchesservice.entities;

import com.finches.finchesservice.validators.contracts.IdNotNull;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Finches {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 3, max = 50, message = "minmax.name")
    private String name;
    @DBRef
    @NotNull
    @IdNotNull
    private Leader leader;

    public Finches(String id, String name, Leader leader) {
        this.id = id;
        this.name = name;
        this.leader = leader;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Leader getLeader() {
        return leader;
    }

    @Override
    public String toString() {
        return "Finches{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", leader=" + leader +
                '}';
    }
}
