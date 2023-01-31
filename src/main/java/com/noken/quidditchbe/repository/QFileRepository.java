package com.noken.quidditchbe.repository;

import com.noken.quidditchbe.domain.QFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QFileRepository extends JpaRepository<QFile, String> {
}
