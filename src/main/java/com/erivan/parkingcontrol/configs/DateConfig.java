package com.erivan.parkingcontrol.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration //classe de configuração do spring
public class DateConfig {
    //criando um padrão global
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //data no padrão internacional para separar ele coloca a letra T e depois Z que é para falar que é UTC
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER); //as datas vão assumir o padrão que foi criado
        return new ObjectMapper()
                .registerModule(module);
    }
}
