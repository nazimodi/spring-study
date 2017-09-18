package com.java.spring.client.hello.base;

import com.java.spring.client.hello.common.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renqingwang on 2017/9/3.
 * @version 1.0
 */
@ControllerAdvice
public abstract class BaseFacade {
    private Logger logger = LoggerFactory.getLogger(BaseFacade.class);

    @ExceptionHandler({BindException.class,
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class,
            TypeMismatchException.class,
            MissingServletRequestParameterException.class,
            MissingServletRequestPartException.class,
            HttpMessageNotReadableException.class,
            HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ResultMessage handleBadRequestException(Exception e, WebRequest webRequest) {
        List<ObjectError> errorList;
        if (e instanceof BindException) {
            errorList = ((BindException) e).getAllErrors();
        } else if (e instanceof MethodArgumentNotValidException) {
            errorList = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
        } else {
            errorList = new ArrayList<>();
        }
        StringBuilder err = new StringBuilder();
        for (ObjectError error : errorList) {
            err.append(error.getDefaultMessage()).append(" ");
        }

       /* HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);*/
        return ResultMessage.getInstance().fail(ResultMessage.FAIL_BAD_REQUEST, err.toString());
    }

    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ResultMessage handleServerInternalError(Exception e, WebRequest webRequest) {
        String err = e.getMessage();
        return ResultMessage.getInstance().fail(ResultMessage.FAIL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ResultMessage handleOtherException(Exception e, WebRequest webRequest) {
        String err = e.getMessage();
       /* HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);*/
        return ResultMessage.getInstance().fail(ResultMessage.FAIL_PARAM, err);
    }
}
