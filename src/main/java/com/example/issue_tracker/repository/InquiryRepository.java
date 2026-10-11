package com.example.issue_tracker.repository;

import com.example.issue_tracker.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository
        extends JpaRepository<Inquiry, Long> {
}