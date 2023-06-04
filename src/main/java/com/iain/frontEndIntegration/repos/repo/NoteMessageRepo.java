package com.iain.frontEndIntegration.repos.repo;

import com.iain.frontEndIntegration.repos.entity.NoteMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NoteMessageRepo extends JpaRepository<NoteMessageEntity, BigInteger> {
    List<NoteMessageEntity> findByNoteStatus(String noteStatus);

}
