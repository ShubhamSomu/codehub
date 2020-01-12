package com.assignment.codehub.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;

@Service
public final class AuthSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent>
{

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) 
    {
        System.out.println(event.getAuthentication());
       // System.out.println("rowCount = "+stateService.rowCount());
    }
}