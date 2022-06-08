package cloud.cholewa.photographs.adapters.repository;

import cloud.cholewa.photographs.adapters.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLocationRepository extends JpaRepository<LocationEntity, Long> {
}
