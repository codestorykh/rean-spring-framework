package com.rean.service;

import com.rean.dto.StudentRequest;
import com.rean.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @Author dawnt
 * @Date 4/2/2022 9:39 AM
 * @Version 1.0
 */

@Service
@RequiredArgsConstructor
public class StudentService {
    private final KieContainer kieContainer;

    public StudentResponse studentResponse(StudentRequest studentRequest) {
        StudentResponse studentResp = new StudentResponse();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("studentResp", studentResp);
        kieSession.insert(studentRequest);
        kieSession.fireAllRules();
        kieSession.dispose();;
        return studentResp;
    }
}
