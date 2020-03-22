package com.finches.finchesservice.services.business;

import com.finches.finchesservice.constents.ErrorMapping;
import com.finches.finchesservice.entities.Leader;
import com.finches.finchesservice.exceptions.apiexceptions.DataIntegrityException;
import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.exceptions.apiexceptions.MaximumCapacityReachedException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.exceptions.apiexceptions.UnableToPerformUpdateExceptions;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.LeaderModel;
import com.finches.finchesservice.repository.LeaderRepository;
import com.finches.finchesservice.services.contracts.business.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderRepository leaderRepository;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    @Qualifier("leaderModelToLeaderMapper")
    private Mapper<LeaderModel, Leader> leaderModelLeaderMapper;

    @Override
    public LeaderModel save(@Valid LeaderModel model) {
        verifyIdExists(model);
        checkAlreadyNameExists(model);
        Leader leader = leaderRepository.save(leaderModelLeaderMapper.mapFromAToB(model));
        return leaderModelLeaderMapper.mapFromBToA(leader);
    }

    @Override
    public LeaderModel update(@Valid LeaderModel model) {
        makeSureIdPresent(model);
        checkValidIdIsValid(model.getId());
        makeSureNoChangeInAssignedFinches(model);
        checkCapacityIsReducedLessThanConnectedFinches(model);
        Leader leader = leaderRepository.save(leaderModelLeaderMapper.mapFromAToB(model));
        return leaderModelLeaderMapper.mapFromBToA(leader);
    }

    @Override
    public List<LeaderModel> getAll() {
        List<LeaderModel> leaderModels = new ArrayList<>();
        leaderRepository.findAll().forEach(leader -> leaderModels.add(leaderModelLeaderMapper.mapFromBToA(leader)));
        return leaderModels;
    }

    @Override
    public LeaderModel getById(String id) {
        Leader leader = leaderRepository.findById(id).orElseThrow(() -> new NoDataFoundException(ErrorMapping.NO_DATA_FOUND(httpServletRequest)));
        return leaderModelLeaderMapper.mapFromBToA(leader);
    }

    @Override
    public String delete(String id) {
        checkValidIdIsValid(id);
        Leader leader = new Leader(id);
        leaderRepository.delete(leader);
        return id;
    }

    @Override
    public Integer IncrementAssignedFinchesCountByOne(LeaderModel leaderModel) {
        LeaderModel leader = getById(leaderModel.getId());
        checkEnoughCapacityAvailable(leader);
        leader.setNoOfFinchesAssigned(leader.getNoOfFinchesAssigned() + 1);
        return update(leaderModel).getNoOfFinchesAssigned();
    }

    private void checkEnoughCapacityAvailable(LeaderModel leader) {
        if (leader.getNoOfFinchesAssigned() >= leader.getMaxCapacity()) {
            throw new MaximumCapacityReachedException(ErrorMapping.MAX_CAPACITY_REACHED(httpServletRequest));
        }
    }

    private void checkAlreadyNameExists(LeaderModel model) {
        Leader leader = new Leader(null, model.getName(), null, null, null);
        Example<Leader> leaderExample = Example.of(leader);
        if (!leaderRepository.findAll(leaderExample).isEmpty()) {
            throw new DuplicateException(ErrorMapping.NAME_EXISTS(httpServletRequest));
        }
    }

    private void checkValidIdIsValid(String id) {
        if (!leaderRepository.existsById(id)) {
            throw new NoDataFoundException(ErrorMapping.NO_DATA_FOUND(httpServletRequest));
        }
    }

    private void verifyIdExists(LeaderModel leaderModel) {
        if (leaderModel.getId() != null) {
            throw new DataIntegrityException(ErrorMapping.ID_IN_SAVE(httpServletRequest));
        }
    }

    private void makeSureIdPresent(LeaderModel leaderModel) {
        if (leaderModel.getId() == null) {
            throw new DataIntegrityException(ErrorMapping.ID_IS_NULL(httpServletRequest));
        }
    }

    private void makeSureNoChangeInAssignedFinches(LeaderModel leaderModel) {
        if (leaderRepository.findById(leaderModel.getId()).get().getNoOfFinchesAssigned() != leaderModel.getNoOfFinchesAssigned()) {
            throw new UnableToPerformUpdateExceptions(ErrorMapping.CAPACITY_LESS_THAN_FINCHES_ASSIGNED(httpServletRequest));
        }
    }

    private void checkCapacityIsReducedLessThanConnectedFinches(LeaderModel leaderModel) {
        if (leaderRepository.findById(leaderModel.getId()).get().getNoOfFinchesAssigned() < leaderModel.getMaxCapacity()) {
            throw new UnableToPerformUpdateExceptions(ErrorMapping.CAPACITY_LESS_THAN_FINCHES_ASSIGNED(httpServletRequest));
        }
    }


}
