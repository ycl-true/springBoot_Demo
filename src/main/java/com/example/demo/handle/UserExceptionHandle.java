package com.example.demo.handle;

import com.example.demo.bo.Result;
import com.example.demo.exception.UserException;
import com.example.demo.util.ApplyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandle {
    Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userEx = (UserException) e;
            return ApplyUtil.getResult(userEx.getCode(), e.getMessage(), null);
        }
        logger.error("系统异常 {}", e);
        // 系统异常
        return ApplyUtil.getResult(-1, e.getMessage(), null);
    }
}
