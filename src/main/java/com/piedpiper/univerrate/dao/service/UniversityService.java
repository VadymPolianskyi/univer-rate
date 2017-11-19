package com.piedpiper.univerrate.dao.service;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import com.piedpiper.univerrate.dao.repository.UniversityRepository;
import com.piedpiper.univerrate.service.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository repository;
    private final CSVReader csvReader;

    @PostConstruct
    public void init() {
        if (!(repository.findAll().size() > 0)) {
            List<UniversityEntity> universities = csvReader.parseUniversities();
            repository.save(universities);
        }
    }

    @Autowired
    public UniversityService(UniversityRepository repository, CSVReader csvReader) {
        this.repository = repository;
        this.csvReader = csvReader;
    }

    public List<UniversityEntity> getByCity(String city, Pageable pageable) {
        return repository.findByAddressIsLike("%" + city.toUpperCase() + ",%", pageable).getContent();
    }

    public UniversityEntity getById(String id) {
        return repository.findOne(id);
    }


    public List<UniversityEntity> getTop10() {
        return repository.findTop10();
    }

    public UniversityEntity save(UniversityEntity entity) {
        return repository.save(entity);
    }
}
