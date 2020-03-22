package com.finches.finchesservice.models.entitymodels;

import com.finches.finchesservice.validators.contracts.IdNotNull;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FinchesModel {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 3, max = 50, message = "minmax.name")
    private String name;
    @DBRef
    @NotNull(message = "notnull")
    @IdNotNull
    private LeaderModel leader;

    public FinchesModel(String id, String name, LeaderModel leader) {
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

    public LeaderModel getLeader() {
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
