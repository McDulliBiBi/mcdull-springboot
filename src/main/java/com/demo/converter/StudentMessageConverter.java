package com.demo.converter;

import com.demo.entity.Student;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Component
public class StudentMessageConverter implements HttpMessageConverter<Student> {
    private String mcdullMediaType = "application/x-mcdull";

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 本MessageConverter支持的
     *
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Student.class)
                && (null == mediaType || mcdullMediaType.equals(mediaType.toString()));
    }

    /**
     * 服务器支持的自定义的格式
     *
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes(mcdullMediaType);
    }

    @Override
    public Student read(Class<? extends Student> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * 自定义MessageConverter返回给客户端的内容
     *
     * @param student
     * @param contentType
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write(Student student, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = student.getName() + ";" + student.getAge();

        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}
