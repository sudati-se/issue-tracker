package com.example.issue_tracker.service;

import com.example.issue_tracker.entity.Inquiry;
import com.example.issue_tracker.repository.InquiryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public List<Inquiry> findAll() {
        return inquiryRepository.findAll(
                Sort.by(Sort.Direction.DESC, "createdAt")
        );
    }

    public Inquiry save(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }
}
