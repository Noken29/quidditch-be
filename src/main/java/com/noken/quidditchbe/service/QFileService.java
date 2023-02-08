package com.noken.quidditchbe.service;

import com.noken.quidditchbe.domain.QFile;
import com.noken.quidditchbe.domain.exception.NotFoundException;
import com.noken.quidditchbe.repository.QFileRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class QFileService implements FileService<QFile, String> {

    @Autowired
    private QFileRepository qFileRepository;

    @Override
    @SneakyThrows
    public QFile mapAndSave(MultipartFile file) {
        return qFileRepository.save(QFile.builder()
                .data(file.getBytes())
                .name(file.getName())
                .type(file.getContentType())
                .build());
    }

    @Override
    @SneakyThrows
    public QFile getById(String id) {
        Optional<QFile> qFileOptional = qFileRepository.findById(id);
        if (qFileOptional.isEmpty())
            throw new NotFoundException("QFile with id: " + id + " not found.");
        return qFileOptional.get();
    }

}
