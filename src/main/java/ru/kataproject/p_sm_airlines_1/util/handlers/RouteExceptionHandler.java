package ru.kataproject.p_sm_airlines_1.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kataproject.p_sm_airlines_1.entity.Dto.ErrorResponseDto;
import ru.kataproject.p_sm_airlines_1.util.exceptions.RouteNotFoundException;

@ControllerAdvice
public class RouteExceptionHandler extends AbstractExceptionHandler {

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> routeExceptionHandler(final RouteNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
}
