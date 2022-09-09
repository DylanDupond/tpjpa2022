package jpa;

import Repository.MeetingRepository;
import model.Meeting;
import model.Teacher;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		User/ Teacher creation
		 */
		User user1 = new User();
		user1.setFirstName("Dylan");
		user1.setLastName("Dupond");
		user1.setLogin("login");
		user1.setMdp("mdp");

		User user2 = new User();
		user2.setFirstName("Flamine");
		user2.setLastName("Sebti");
		user2.setLogin("login");
		user2.setMdp("mdp");

		Teacher teacher1 = new Teacher();
		teacher1.setFirstName("Olivier");
		teacher1.setLastName("Barais");
		teacher1.setLogin("ILove");
		teacher1.setMdp("TAA");

		Teacher teacher2 = new Teacher();
		teacher2.setFirstName("Marc");
		teacher2.setLastName("Bousse");
		teacher2.setLogin("ILove");
		teacher2.setMdp("Alternance");

		MeetingRepository repository = new MeetingRepository();
		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			manager.persist(user1);
			manager.persist(teacher1);
			manager.persist(teacher2);
			repository.addMeeting(Meeting.builder()
							.start(Timestamp.valueOf("2022-09-05 10:00:00"))
							.end(Timestamp.valueOf("2022-09-05 11:00:00"))
							.url("1Creneau")
							.title("M2 ILA")
							.user(user1)
							.teacher(teacher1)
					.build(),manager);
			repository.addMeeting(Meeting.builder()
					.start(Timestamp.valueOf("2022-09-06 10:00:00"))
					.end(Timestamp.valueOf("2022-09-06 11:00:00"))
					.url("2Creneau")
					.title("M2 ILA")
					.user(user1)
					.teacher(teacher2)
					.build(),manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		//System.out.println(repository.getAllMeetings(manager).get(0).toString());
		System.out.println(repository.gettMeetingsByIdProf(manager, teacher2.getId()).toString());

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
