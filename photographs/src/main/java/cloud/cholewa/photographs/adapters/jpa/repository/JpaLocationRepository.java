package cloud.cholewa.photographs.adapters.jpa.repository;

import cloud.cholewa.photographs.adapters.jpa.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLocationRepository extends JpaRepository<LocationEntity, Long> {
}
