package com.iain.frontEndIntegration.controller;

import com.iain.frontEndIntegration.controller.constant.ApiConstant;
import com.iain.frontEndIntegration.controller.dto.NoteListDto;
import com.iain.frontEndIntegration.service.INoteMessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = ApiConstant.V1)
@CrossOrigin
@AllArgsConstructor
public class NoteController {

    private INoteMessageService noteMessageService;

    @GetMapping(value = ApiConstant.GET_NOTE_LIST)
    public List<NoteListDto> getNoteListDto(){
        return noteMessageService.findAllAvaliableEntity();
    }

    @PostMapping(value = ApiConstant.ADD_ONE_NOTE)
    public @ResponseBody NoteListDto addOneNote(@RequestBody NoteListDto noteListDto){
        return noteMessageService.saveOneNoteMessage(noteListDto.getNoteMessage());
    }

    @PostMapping(value = ApiConstant.DELETE_ONE_NOTE)
    public NoteListDto deleteOneNote(@RequestBody NoteListDto noteListDto){
        return noteMessageService.deleteOneNoteMessage(BigInteger.valueOf(Long.parseLong(noteListDto.getId())));
    }
}
