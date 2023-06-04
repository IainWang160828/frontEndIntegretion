package com.iain.frontEndIntegration.service;

import com.iain.frontEndIntegration.controller.dto.NoteListDto;
import com.iain.frontEndIntegration.repos.entity.NoteMessageEntity;

import java.math.BigInteger;
import java.util.List;

public interface INoteMessageService {
    NoteListDto deleteOneNoteMessage(BigInteger id);

    NoteListDto saveOneNoteMessage(String noteMessage);

    List<NoteListDto> findAllAvaliableEntity();
}
