package dao;

import model.Event;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EventDao {

    public String addEvent(Event event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(event);
            tx.commit();
            session.close();
            return "DATA SAVED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateEvent(Event event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(event);
            tx.commit();
            session.close();
            return "DATA UPDATED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteEvent(Event event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(event);
            tx.commit();
            session.close();
            return "DATA DELETED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Event getEventById(Event event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Event e = (Event) session.get(Event.class, event.getId());
            session.close();
            return event;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> getAllEvents() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Event> events = session.createQuery("SELCECT e FROM Event e").list();

            session.close();
            return events;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
