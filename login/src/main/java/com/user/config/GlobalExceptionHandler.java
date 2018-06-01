package com.user.config;

import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    全局异常捕获
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResultMessage<String> appExceptionHandler(HttpServletRequest request, AppException e) {
        ResultMessage<String> resultMessage = new ResultMessage<>(e.getCode(), e.getMsg());
        resultMessage.setData(e.getMessage());
        return resultMessage;
    }

    @ExceptionHandler(value = Exception.class)
    public ResultMessage<String> defaultHandler(HttpServletRequest request, Exception e) {
        ResultMessage<String> resultMessage = new ResultMessage<>(ReturnCode.ERROR, ReturnCode.ERROR_MSG);
        resultMessage.setData(e.getMessage());
        return resultMessage;
    }
}
