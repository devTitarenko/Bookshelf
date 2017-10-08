package com.titarenko.bookshelf.service;

import com.titarenko.bookshelf.model.Reward;
import com.titarenko.bookshelf.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    @Autowired
    private RewardRepository repository;

    public Reward find(Integer id) {
        return repository.findOne(id);
    }

    public Iterable<Reward> findAll() {
        return repository.findAll();
    }

    public void save(Reward reward) {
        repository.save(reward);
    }

    public void delete(Integer reward) {
        repository.delete(reward);
    }
}