package ru.kataproject.p_sm_airlines_1.util.mapper;


import ru.kataproject.p_sm_airlines_1.entity.Dto.RouteDto;
import ru.kataproject.p_sm_airlines_1.entity.Route;

/**
 * Преобзарование сущности Route в DTO и обратно
 *
 * @author Toboe512
 */
public class RouteMapper {

    public static Route mapped(RouteDto routeDto) {
        return new Route(routeDto.getId(),
                routeDto.getDestinationFrom(),
                routeDto.getDestinationTo(),
                routeDto.getDepartureDate(),
                routeDto.getArrivalDate(),
                routeDto.getNumberOfSeats(),
                routeDto.getCategory());
    }

    public static RouteDto mapped(Route route) {
        return new RouteDto(route.getId(),
                route.getDestinationFrom(),
                route.getDestinationTo(),
                route.getDepartureDate(),
                route.getArrivalDate(),
                route.getNumberOfSeats(),
                route.getCategory());
    }
}
