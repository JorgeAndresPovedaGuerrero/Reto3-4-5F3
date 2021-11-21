package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.crudrepository.ReservationsCrudRepository;
import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.model.Reservation;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

        @Autowired
        private ReservationsCrudRepository reservationsCrudRepository;

        public List<Reservation> getAll(){

            return (List<Reservation>) reservationsCrudRepository.findAll();
        }
        public Optional<Reservation> getReservation(int idReservation){

            return reservationsCrudRepository.findById(idReservation);
        }
        public Reservation save(Reservation reservation){

            return reservationsCrudRepository.save(reservation);
        }
        public void delete(Reservation reservation){

            reservationsCrudRepository.delete(reservation);
        }
        
                
        public List<Reservation> ReservacionStatusRepositorio (String status){
         return reservationsCrudRepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return reservationsCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<CountClient> getClientesRepositorio(){
         List<CountClient> res = new ArrayList<>();
         List<Object[]> report = reservationsCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }




}
