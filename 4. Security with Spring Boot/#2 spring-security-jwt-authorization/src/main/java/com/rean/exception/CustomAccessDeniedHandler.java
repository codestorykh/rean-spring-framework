package com.rean.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        CustomMessageException customMessageException = new CustomMessageException();
        customMessageException.setMessage("The request can't access the resources.");
        customMessageException.setCode(String.valueOf(HttpStatus.FORBIDDEN.value()));

        var msgJson = objectMapper.writeValueAsString(customMessageException);

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(String.valueOf(MediaType.APPLICATION_JSON));
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msgJson);
    }
}
