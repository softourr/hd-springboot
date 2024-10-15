package com.sample.file13.repository;

import com.sample.file13.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileEntity, Long> {

}
