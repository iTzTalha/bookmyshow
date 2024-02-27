package com.bitforge.bookmyshow.repositories;

import com.bitforge.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> ids);

    @Override
    ShowSeat save(ShowSeat showSeat);
}
