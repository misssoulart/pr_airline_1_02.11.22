package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.RouteController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.RouteDto;
import ru.kataproject.p_sm_airlines_1.service.RouteService;
import ru.kataproject.p_sm_airlines_1.util.mapper.RouteMapper;

/**
 * Контроллер для работы с Route
 *
 * @author Toboe512
 */
@Log4j2
@RestController
public class RouteControllerImpl implements RouteController {
    private final RouteService routeService;

    public RouteControllerImpl(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public ResponseEntity<RouteDto> getRouteById(Long id) {
        log.info("execute getRouteById method");
        RouteDto route = RouteMapper.mapped(routeService.getRouteById(id));
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> createRoute(RouteDto route) {
        log.info("execute createRoute method");
        routeService.saveRoute(RouteMapper.mapped(route));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateRoute(RouteDto route) {
        log.info("execute updateRoute method");
        routeService.updateRoute(RouteMapper.mapped(route));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteRoute(Long id) {
        log.info("execute deleteRoute method");
        routeService.deleteRoute(routeService.getRouteById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
