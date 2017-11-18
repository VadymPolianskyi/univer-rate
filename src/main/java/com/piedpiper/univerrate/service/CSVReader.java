package com.piedpiper.univerrate.service;

import com.piedpiper.univerrate.dao.entity.UniversityEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReader {

    @Value("${csv.file.name}")
    private String csvFile;

    private final static String SPLITER = ";";



    public List<UniversityEntity> parseUniversities() {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            List<UniversityEntity> universities = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                line = line.replaceAll(",", ";");
                line = line.replaceAll("; ", ",");

                String[] university = line.split(SPLITER);

                universities.add(new UniversityEntity(null, university[1], university[2],university[5],
                        university[6], university[7],university[8],university[9]));
            }
            return universities;
        } catch (IOException e) {
            throw new RuntimeException(); //todo: create custom UniversityParsingException;
        }
    }
}
