package com.rean.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RatingLimitService {

    public Bucket bucket(String userType) {
        return Bucket
                .builder()
                .addLimit(getBucketBandwidth(userType))
                .build();
    }

    public Bandwidth getBucketBandwidth(String arg) {
        if("GOLDA".equals(arg))
            return Bandwidth.classic(5, Refill.intervally(5, Duration.ofMinutes(1)));
        return Bandwidth.classic(2, Refill.intervally(2, Duration.ofMinutes(1)));
    }
}
