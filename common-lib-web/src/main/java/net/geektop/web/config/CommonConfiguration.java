package net.geektop.web.config;

import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.config
 * @date 2020/10/13 11:50
 */
@Configuration
public class CommonConfiguration {

//  /** 默认日期时间格式 */
//  public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//  /** 默认日期格式 */
//  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
//  /** 默认时间格式 */
//  public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

  @Bean
  public OptimisticLockerInnerInterceptor optimisticLockerInterceptor() {
    return new OptimisticLockerInnerInterceptor();
  }

  @Bean
  public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
    final ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
    SimpleModule module = new SimpleModule();
    module.addSerializer(Long.class, ToStringSerializer.instance);
    module.addSerializer(Long.TYPE, ToStringSerializer.instance);
    module.addSerializer(BigDecimal.class, ToStringSerializer.instance);
    objectMapper.registerModule(module);

//    final JavaTimeModule javaTimeModule = new JavaTimeModule();
//    javaTimeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
//    javaTimeModule.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
//    javaTimeModule.addSerializer(LocalTime.class,new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
//    javaTimeModule.addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
//    javaTimeModule.addDeserializer(LocalDate.class,new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
//    javaTimeModule.addDeserializer(LocalTime.class,new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
//    objectMapper.registerModule(javaTimeModule);
    return objectMapper;
  }
}
