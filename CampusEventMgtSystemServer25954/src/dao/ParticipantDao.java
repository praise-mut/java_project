package dao;

import model.Participant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import model.Event;

public class ParticipantDao {

    public String addParticipant(Participant participant) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(participant);
            tx.commit();
            session.close();
            return "DATA SAVED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateParticipant(Participant participant) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(participant);
            tx.commit();
            session.close();
            return "DATA UPDATED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteParticipant(Participant participant) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(participant);
            tx.commit();
            session.close();
            return "DATA DELETED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Participant getParticipantById(Participant participant) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Participant p = (Participant) session.get(Participant.class, participant.getId());
            session.close();
            return participant;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Participant> getAllParticipants() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Participant> participants = session.createQuery("SELECT p FROM Participant p").list();
            session.close();
            return participants;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
