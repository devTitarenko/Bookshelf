package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Reward;
import org.springframework.stereotype.Component;

@Component
public class RewardDtoMapper {
    public RewardDto BoToDto(Reward reward) {
        RewardDto rewardDto = new RewardDto();
        rewardDto.setTitle(reward.getTitle());
        rewardDto.setYear(reward.getYear());
        return rewardDto;
    }

    public Reward DtoToBo(RewardDto rewardDto) {
        Reward reward = new Reward();
        reward.setTitle(rewardDto.getTitle());
        reward.setYear(rewardDto.getYear());
        return reward;
    }
}
