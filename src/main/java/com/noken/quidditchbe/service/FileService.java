package com.noken.quidditchbe.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService<T, U> {

    T mapAndSave(MultipartFile file);

    T getById(U id);

}
