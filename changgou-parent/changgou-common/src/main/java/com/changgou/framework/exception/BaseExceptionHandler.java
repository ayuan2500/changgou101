package com.changgou.framework.exception;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @ClassName BaseExceptionHandler
 * @Description 全局异常处理类，只要有@RequestMapping注解的方法出现的所有异常都会被捕获
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/10 11:26:00
 */
@ControllerAdvice    //标记该类是一个全局异常处理类
public class BaseExceptionHandler {
    //异常处理，当controller的修改了@RequestMapping的方法出现了错误，该方法就会被执行，并返回给前端页面
    @ExceptionHandler(value = Exception.class)    //修饰方法，表示该方法为异常处理的方法，value = Exception.class 当出现value指定异常的时候才进行处理
    @ResponseBody
    public Result error(Exception e) {
        //捕获异常，并处理返回
        e.printStackTrace();//这里将来要用日志进行输出而不是打印堆栈
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
