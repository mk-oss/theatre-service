package com.sapient.ticketing.theatreservice.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

}
