package com.fpt.shopflow.redis.model;


import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("RedisHash")
public class RedisToken {

    private String jwtId;

    @TimeToLive(unit = TimeUnit.DAYS)
    private Long expiredTime;
}
