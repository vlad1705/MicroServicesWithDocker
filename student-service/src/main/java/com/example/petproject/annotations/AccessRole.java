package com.example.petproject.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Retention(RetentionPolicy.SOURCE)
public @interface AccessRole {
    Role[] values();
}
