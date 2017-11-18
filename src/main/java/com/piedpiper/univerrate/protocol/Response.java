package com.piedpiper.univerrate.protocol;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable{
    private int code = HttpStatus.OK.value();
    private String message = "OK";
}
