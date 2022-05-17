package pl.zapas.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.Location;
import pl.zapas.repository.LocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> findAll() {return locationRepository.findAll();}

    public Location findLocationById(Long id) {return locationRepository.findById(id).orElseThrow();}
}
