package com.iain.frontEndIntegration.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoteListDto implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("noteMessage")
    private String noteMessage;

}