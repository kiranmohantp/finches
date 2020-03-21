package com.finches.finchesservice.services.business;

import com.finches.finchesservice.models.entitymodels.LeaderModel;
import com.finches.finchesservice.repository.LeaderRepository;
import com.finches.finchesservice.services.contracts.business.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderRepository leaderRepository;

    @Override
    public LeaderModel save(LeaderModel model) {
        return null;
    }

    @Override
    public LeaderModel update(LeaderModel model) {
        return null;
    }

    @Override
    public List<LeaderModel> getAll() {
        return null;
    }

    @Override
    public LeaderModel getById(String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
