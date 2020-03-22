package com.finches.finchesservice.mappers;

import com.finches.finchesservice.entities.Leader;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.LeaderModel;
import org.springframework.stereotype.Component;

@Component("leaderModelToLeaderMapper")
public class LeaderModelToLeaderMapper implements Mapper<LeaderModel, Leader> {
    @Override
    public Leader mapFromAToB(LeaderModel leaderModel) {
        return new Leader(leaderModel.getId(),
                leaderModel.getName(),
                leaderModel.getIp(),
                leaderModel.getNoOfFinchesAssigned(),
                leaderModel.getMaxCapacity());
    }

    @Override
    public LeaderModel mapFromBToA(Leader leader) {
        return new LeaderModel(leader.getId(),
                leader.getName(),
                leader.getIp(),
                leader.getNoOfFinchesAssigned(),
                leader.getMaxCapacity());
    }
}
