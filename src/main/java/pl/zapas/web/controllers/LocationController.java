package pl.zapas.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.Location;
import pl.zapas.service.LocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    private ResponseEntity<List<Location>> getAllLocations() {return ResponseEntity.ok(locationService.findAll());}

    @GetMapping("/{id}")
        public ResponseEntity<Location> getLocationBySymbol(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.findLocationById(id));
    }

    @PostMapping
    ResponseEntity<Location> save(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.save(location));
    }

}
