package com.finches.finchesservice.mappers;

import com.finches.finchesservice.entities.Finches;
import com.finches.finchesservice.entities.Leader;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.FinchesModel;
import com.finches.finchesservice.models.entitymodels.LeaderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("finchesModelToFinchesMapper")
public class FinchesModelToFinchesMapper implements Mapper<FinchesModel, Finches> {
    @Autowired
    @Qualifier("leaderModelToLeaderMapper")
    private Mapper<LeaderModel, Leader> leaderModelLeaderMapper;

    @Override
    public Finches mapFromAToB(FinchesModel finchesMode) {
        return new Finches(finchesMode.getId(),
                finchesMode.getName(),
                leaderModelLeaderMapper.mapFromAToB(finchesMode.getLeader()));
    }

    @Override
    public FinchesModel mapFromBToA(Finches finches) {
        return new FinchesModel(finches.getId(),
                finches.getName(),
                leaderModelLeaderMapper.mapFromBToA(finches.getLeader()));
    }
}
