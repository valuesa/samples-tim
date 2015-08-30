package cn.boxfish.controller;

/**
 * Created by TIM on 2015/8/30.
 * 所有异常处理
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.ERROR)
    public String allException(Exception e) {
        return e.getMessage();
    }
}
