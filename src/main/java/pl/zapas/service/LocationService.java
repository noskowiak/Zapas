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

    public List<Location> findAll() {
        return locationRepository.findAll();
    }



    public Location findLocationById(Long id) {return locationRepository.findById(id).orElseThrow();}

    public Location save(Location location) {return locationRepository.save(location);}

    public Location findLocationByName(String name) {return locationRepository.findLocationByName(name);}

    // TODO: 17.05.2022 saveLocation, updateName 

}
