package org.sid.radarservicequeryside.repositories;

import org.sid.radarservicequeryside.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarRepository extends JpaRepository<Radar,String> {
}
