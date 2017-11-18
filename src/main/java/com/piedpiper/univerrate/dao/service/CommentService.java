package com.piedpiper.univerrate.dao.service;

import com.piedpiper.univerrate.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
}
