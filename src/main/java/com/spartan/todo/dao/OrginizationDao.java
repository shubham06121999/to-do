package com.spartan.todo.dao;

import com.spartan.todo.model.api.Orginization;
import com.spartan.todo.model.db.ORGINIZATION;
import com.spartan.todo.respository.OrginizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

@Repository
@Slf4j
public class OrginizationDao {
    private final OrginizationRepository orginizationRepository;

    public OrginizationDao(OrginizationRepository orginizationRepository) {
        this.orginizationRepository = orginizationRepository;
    }


    public ORGINIZATION createOrginization(Orginization data , String actionType, Date createdTime, String uuid) {


        ORGINIZATION result = saveOrginization(data,actionType,createdTime,uuid);
        return result;
    }

    public Optional<ORGINIZATION> retrievePatientbyId(String id) {
        return orginizationRepository.findById(id);
    }
    public ORGINIZATION saveOrginization(Orginization data, String ActionType , Date createdTime, String uuid) {
        ORGINIZATION orginization = new ORGINIZATION();
        orginization.setId(uuid);
        orginization.setUserId(data.getUserId());
        orginization.setName(data.getName());
        orginization.setAction(ActionType);
        orginization.setCreated_dttm(createdTime);
        orginization.setUpdateddttm(createdTime);

        return orginizationRepository.save(orginization);
    }

    public String  deletebyId(String id) {

        Optional<ORGINIZATION> table = orginizationRepository.findById(id);;
        ORGINIZATION transactionsTable = table.stream()
                .sorted(Comparator.comparing(ORGINIZATION::getUpdateddttm).reversed()).limit(1)
                .findFirst().orElse(null);
        orginizationRepository.delete(transactionsTable);
        return  "orginization has been deleted";
    }
}
