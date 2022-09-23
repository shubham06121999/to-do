package com.spartan.todo.services;

import com.spartan.todo.dao.OrginizationDao;
import com.spartan.todo.model.api.Orginization;
import com.spartan.todo.model.db.ORGINIZATION;
import com.spartan.todo.model.enums.ActionType;
import com.spartan.todo.respository.OrginizationRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrginizationServices {

    private final OrginizationDao orginizationDao;
    private final OrginizationRepository orginizationRepository;

    public OrginizationServices(OrginizationDao orginizationDao, OrginizationRepository orginizationRepository) {
        this.orginizationDao = orginizationDao;
        this.orginizationRepository = orginizationRepository;
    }

    public Orginization createOrginization(Orginization data){
        ORGINIZATION orginization = createAndPublish(data, ActionType.CREATE.getValue());
        Orginization  response =  setresponse(orginization);
        return response;
    }

    private ORGINIZATION createAndPublish(Orginization data, String actionType) {

        ORGINIZATION  response =  orginizationDao.createOrginization(data,actionType, new Date(), UUID.randomUUID().toString());

        return  response;
    }
    private Orginization setresponse(ORGINIZATION data){
        Orginization response = new Orginization();
        response.setId(data.getId());
        response.setName(data.getName());
        response.setUserId(data.getUserId());
        return response;

    }

    public Orginization retiveById(String Id){
        Optional<ORGINIZATION> table = orginizationDao.retrievePatientbyId(Id);
        ORGINIZATION transactionsTable = table.stream()
                .sorted(Comparator.comparing(ORGINIZATION::getUpdateddttm).reversed()).limit(1)
                .findFirst().orElse(null);
        Orginization response = setresponse(transactionsTable);
        return  response;
    }

    public String DeleteOrginization(String id){
        String response =  orginizationDao.deletebyId(id);
        return  response;
    }


}
