package com.codepro.monitoringspringprometheusgraphana.model;

public record Post(Integer id,
                   Integer userId,
                   String title,
                   String body) {
}
