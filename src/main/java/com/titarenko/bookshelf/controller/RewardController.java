package com.titarenko.bookshelf.controller;

import com.titarenko.bookshelf.dto.RewardDto;
import com.titarenko.bookshelf.dto.RewardDtoMapper;
import com.titarenko.bookshelf.model.Reward;
import com.titarenko.bookshelf.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/reward")
public class RewardController {

    @Autowired
    private RewardService service;
    @Autowired
    private RewardDtoMapper mapper;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewReward(@RequestParam String title, @RequestParam Integer year) {
        Reward reward = new Reward();
        reward.setTitle(title);
        reward.setYear(year);
        service.save(reward);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Reward> getAllRewards() {
        return service.findAll();
    }

    @GetMapping(path = "/info/{id}")
    public @ResponseBody RewardDto getRewardInfo(@PathVariable("id") Integer id) {
        return mapper.BoToDto(service.find(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteReward(@PathVariable("id") Integer id) {
        service.delete(id);
        return "Deleted";
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateReward(@RequestBody RewardDto rewardDto) {
        Reward reward = mapper.DtoToBo(rewardDto);
        service.save(reward);
        return "Reward's id is: " + reward.getId();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createAuthor(@RequestBody RewardDto rewardDto) {
        Reward reward = mapper.DtoToBo(rewardDto);
        service.save(reward);
        return "Reward's id is: " + reward.getId();
    }
}