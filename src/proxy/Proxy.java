package src.proxy;

import src.classes.user.User;
import java.time.DayOfWeek;
import java.time.LocalTime;
import src.classes.classrooms.Classroom;
import src.classes.classrooms.LabClassroom;
import src.classes.reservation.Reservation;

interface IReservation {
    public void makeReservation(User u, Classroom room, DayOfWeek day, LocalTime start, LocalTime end);
}

class ReservationService implements IReservation {
    public void makeReservation(User u, Classroom room, DayOfWeek day, LocalTime start, LocalTime end) {
        Reservation reserva = new Reservation(day, start, end);
        room.reserve(reserva, u);
    }
}

class Proxy implements IReservation {
    private ReservationService reservationService;

    public Proxy() {
        this.reservationService = new ReservationService();
    }

    public void makeReservation(User u, Classroom room, DayOfWeek day, LocalTime start, LocalTime end) {
        if (u.getRole().equals("aluno") && room instanceof LabClassroom) {
            System.out.println("Acesso negado: alunos nao podem reservar salas de laboratorio.");
            return;
        }
        reservationService.makeReservation(u, room, day, start, end);
    }
}

