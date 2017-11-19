package com.piedpiper.univerrate.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public @Data
class LikeRequest extends Request {
    private String id;
    private String strategy;
}
