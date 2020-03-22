package com.finches.finchesservice.services.business;

import com.finches.finchesservice.constents.ErrorMapping;
import com.finches.finchesservice.entities.Finches;
import com.finches.finchesservice.exceptions.apiexceptions.DataIntegrityException;
import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.FinchesModel;
import com.finches.finchesservice.repository.FinchesRepository;
import com.finches.finchesservice.services.contracts.business.FinchesService;
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
public class FinchesServiceImpl implements FinchesService {
    @Autowired
    private FinchesRepository finchesRepository;
    @Autowired
    private LeaderService leaderService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    @Qualifier("finchesModelToFinchesMapper")
    private Mapper<FinchesModel, Finches> finchesModelFinchesMapper;

    @Override
    public FinchesModel save(@Valid FinchesModel model) {
        verifyIdExists(model);
        checkAlreadyNameExists(model);
        leaderService.IncrementAssignedFinchesCountByOne(model.getLeader());
        Finches finches = finchesRepository.save(finchesModelFinchesMapper.mapFromAToB(model));
        return finchesModelFinchesMapper.mapFromBToA(finches);
    }

    @Override
    public FinchesModel update(@Valid FinchesModel model) {
        makeSureIdPresent(model);
        checkValidIdIsValid(model.getId());
        checkAlreadyNameExists(model);
        Finches finches = finchesRepository.save(finchesModelFinchesMapper.mapFromAToB(model));
        return finchesModelFinchesMapper.mapFromBToA(finches);
    }

    @Override
    public List<FinchesModel> getAll() {
        List<FinchesModel> finchesModels = new ArrayList<>();
        finchesRepository.findAll().forEach(finches -> finchesModels.add(finchesModelFinchesMapper.mapFromBToA(finches)));
        return finchesModels;
    }

    @Override
    public FinchesModel getById(String id) {
        Finches finches = finchesRepository.findById(id).orElseThrow(() -> new NoDataFoundException(ErrorMapping.NO_DATA_FOUND(httpServletRequest)));
        return finchesModelFinchesMapper.mapFromBToA(finches);
    }

    @Override
    public String delete(String id) {
        checkValidIdIsValid(id);
        Finches finches = new Finches(id);
        finchesRepository.delete(finches);
        return id;
    }

    private void checkValidIdIsValid(String id) {
        if (!finchesRepository.existsById(id)) {
            throw new NoDataFoundException(ErrorMapping.NO_DATA_FOUND(httpServletRequest));
        }
    }

    private void checkAlreadyNameExists(FinchesModel model) {
        Finches finches = new Finches(null, model.getName(), null);
        Example<Finches> finchesExample = Example.of(finches);
        if (!finchesRepository.findAll(finchesExample).isEmpty()) {
            throw new DuplicateException(ErrorMapping.NAME_EXISTS(httpServletRequest));
        }
    }

    private void verifyIdExists(FinchesModel finchesModel) {
        if (finchesModel.getId() != null) {
            throw new DataIntegrityException(ErrorMapping.ID_IN_SAVE(httpServletRequest));
        }
    }

    private void makeSureIdPresent(FinchesModel finchesModel) {
        if (finchesModel.getId() == null) {
            throw new DataIntegrityException(ErrorMapping.ID_IS_NULL(httpServletRequest));
        }
    }


}
