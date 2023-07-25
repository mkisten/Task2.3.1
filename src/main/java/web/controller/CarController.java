package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {
    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Peugeot", "White", 307));
        cars.add(new Car("Opel", "Black", 171));
        cars.add(new Car("BMW", "Grey", 7));
        cars.add(new Car("Lexus", "Red", 8));
        cars.add(new Car("VW", "Yelow", 777));
        cars = CarService.carsCount(cars, allCars);
        model.addAttribute("list", cars);

        return "cars";
    }
}



