package com.activitiesBackend.activitiesBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activitiesBackend.activitiesBackend.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
