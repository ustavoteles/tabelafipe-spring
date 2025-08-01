package com.teles.tabelafipe.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record Data(
        @JsonProperty("codigo") String code,
        @JsonProperty("nome") String name
) {
}