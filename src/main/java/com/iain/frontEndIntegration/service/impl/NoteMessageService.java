package com.iain.frontEndIntegration.service.impl;

import com.iain.frontEndIntegration.controller.dto.NoteListDto;
import com.iain.frontEndIntegration.enums.NoteStatusEnum;
import com.iain.frontEndIntegration.repos.entity.NoteMessageEntity;
import com.iain.frontEndIntegration.repos.repo.NoteMessageRepo;
import com.iain.frontEndIntegration.service.INoteMessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteMessageService implements INoteMessageService {

    private final NoteMessageRepo noteMessageRepo;

    @Override
    public NoteListDto deleteOneNoteMessage(BigInteger id) {
        Optional<NoteMessageEntity> noteMessageEntityOpt = noteMessageRepo.findById(id);
        if(noteMessageEntityOpt.isPresent()){
            NoteMessageEntity noteMessageEntity = noteMessageEntityOpt.get();
            noteMessageEntity.setNoteStatus(NoteStatusEnum.N.name());
            noteMessageEntity.setUpdatedBy("SYS");
            noteMessageEntity.setUpdatedDatetime(LocalDateTime.now());
            noteMessageRepo.saveAndFlush(noteMessageEntity);
            NoteListDto noteListDto = new NoteListDto();
            noteListDto.setId(noteMessageEntity.getId().toString());
            noteListDto.setNoteMessage(noteMessageEntity.getNoteMessage());
            return noteListDto;
        }else{
            return new NoteListDto();
        }


    }

    @Override
    public NoteListDto saveOneNoteMessage(String noteMessage) {
        NoteMessageEntity noteMessageEntity = new NoteMessageEntity();
        noteMessageEntity.setUpdatedDatetime(LocalDateTime.now());
        noteMessageEntity.setUpdatedBy("SYS");
        noteMessageEntity.setNoteMessage(noteMessage);
        noteMessageEntity.setCreateDatetime(LocalDateTime.now());
        noteMessageEntity.setCreatedBy("SYS");
        noteMessageEntity.setNoteStatus(NoteStatusEnum.Y.name());
        NoteMessageEntity noteMessageEntityUpdated = noteMessageRepo.saveAndFlush(noteMessageEntity);
        NoteListDto noteListDto = new NoteListDto();
        noteListDto.setId(noteMessageEntityUpdated.getId().toString());
        noteListDto.setNoteMessage(noteMessageEntityUpdated.getNoteMessage());
        return noteListDto;
    }

    @Override
    public List<NoteListDto> findAllAvaliableEntity() {
        List<NoteMessageEntity> noteMessageEntities = noteMessageRepo.findByNoteStatus(NoteStatusEnum.Y.name());
        List<NoteListDto> noteListDtos = new ArrayList<>();
        if(!CollectionUtils.isEmpty(noteMessageEntities)){
            noteListDtos = noteMessageEntities.stream().map(noteMessageEntity -> {
                NoteListDto noteListDto = new NoteListDto();
                noteListDto.setId(noteMessageEntity.getId().toString());
                noteListDto.setNoteMessage(noteMessageEntity.getNoteMessage());
                return noteListDto;
            }).collect(Collectors.toList());
        }
        return noteListDtos;
    }
}
