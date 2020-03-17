package com.finches.finchesservice.services.business;

import com.finches.finchesservice.constents.messages.CommonErrorMessages;
import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.UserJwtDetails;
import com.finches.finchesservice.repository.UserDetailsRepository;
import com.finches.finchesservice.services.contracts.business.UserDetailsService;
import com.finches.finchesservice.services.contracts.common.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    @Qualifier("userDetailsModelToUserDetailsMapper")
    private Mapper<UserDetailsModel, UserDetails> userDetailsModelToUserDetailsMapper;
    @Autowired
    @Qualifier("userDetailsToUserJwtDetailsMapper")
    private Mapper<UserDetails, UserJwtDetails> userDetailsToUserJwtDetailsMapper;
    @Autowired
    private PasswordValidator passwordValidator;

    @Override
    public UserJwtDetails getUserDataForAuthenticationByUserName(LoginRequest loginRequest) throws NoDataFoundException, InvalidCredentialsException {
        UserDetails userDetails = userDetailsRepository.getByUserName(loginRequest.getUserName().toLowerCase());
        if (userDetails == null) {
            throw new NoDataFoundException(CommonErrorMessages.NO_DATA_FOUND);
        }
        if (!passwordValidator.checkPasswordsAreSame(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new InvalidCredentialsException(CommonErrorMessages.INVALID_CREDENTIALS);
        }
        return userDetailsToUserJwtDetailsMapper.mapFromAToB(userDetails);
    }

    @Override
    public UserJwtDetails getUserDataForAuthenticationByEncodedId(String encodedId) throws NoDataFoundException {
        UserDetails userDetails = userDetailsRepository.getById(encodedId);
        if (userDetails == null) {
            throw new NoDataFoundException(CommonErrorMessages.NO_DATA_FOUND);
        }
        return userDetailsToUserJwtDetailsMapper.mapFromAToB(userDetails);
    }

    @Override
    public UserDetailsModel save(UserDetailsModel userDetails) {
        UserDetails savedUserDetails = userDetailsRepository.save(userDetailsModelToUserDetailsMapper.mapFromAToB(userDetails));
        return userDetailsModelToUserDetailsMapper.mapFromBToA(savedUserDetails);
    }
}
