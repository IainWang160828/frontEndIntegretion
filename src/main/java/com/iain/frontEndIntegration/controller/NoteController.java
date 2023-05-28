package com.iain.frontEndIntegration.controller;

import com.iain.frontEndIntegration.controller.constant.ApiConstant;
import com.iain.frontEndIntegration.controller.dto.NoteListDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = ApiConstant.V1)
@CrossOrigin
public class NoteController {

    @GetMapping(value = ApiConstant.GET_NOTE_LIST)
    public List<NoteListDto> getNoteListDto(){
        List<NoteListDto> noteListDtos = new ArrayList<>();
        NoteListDto noteListDto1 = new NoteListDto();
        noteListDto1.setId("1");
        noteListDto1.setNoteMessgae("出去上班");

        NoteListDto noteListDto2 = new NoteListDto();
        noteListDto2.setId("2");
        noteListDto2.setNoteMessgae("中午吃饭");

        NoteListDto noteListDto3 = new NoteListDto();
        noteListDto3.setId("3");
        noteListDto3.setNoteMessgae("下班回家");

        noteListDtos.add(noteListDto1);
        noteListDtos.add(noteListDto2);
        noteListDtos.add(noteListDto3);

        return noteListDtos;
    }
}
