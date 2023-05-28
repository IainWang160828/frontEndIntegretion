package com.iain.frontEndIntegration.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NoteListDto implements Serializable {

    private String id;

    private String noteMessgae;

}
