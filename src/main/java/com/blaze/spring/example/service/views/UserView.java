package com.blaze.spring.example.service.views;

import com.blaze.spring.example.domain.User;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.time.ZonedDateTime;

@EntityView (User.class)
public interface UserView {
    @IdMapping
    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    ZonedDateTime getCreatedDate();

    ZonedDateTime getUpdatedDate();
}