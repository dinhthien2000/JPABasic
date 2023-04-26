package stu.nvt.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import stu.nvt.java.entities.Student;

public class StudentDao {
	
	public Student createStudent(Student student) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			
			
			transaction.begin();
			
			em.persist(student);
			
			transaction.commit();
			
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public Student updateStudent(Student student) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			
			
			transaction.begin();
			
			em.merge(student);
			
			transaction.commit();
			
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public Boolean removeStudent(String id) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			

			transaction.begin();
			
			em.remove(id);
			
			transaction.commit();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	
	public Boolean removeStudent(int id) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			

			transaction.begin();
			
			Query query = em.createNamedQuery("Student.findById");
			query.setParameter("id", id);
			
			Student student = (Student) query.getSingleResult();
			
			em.remove(student);
			
			transaction.commit();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public Student findByIdStudent(int id) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		
		
		try {
			
			Query query = em.createNamedQuery("Student.findById");
			query.setParameter("id", id);
			Student student = (Student) query.getSingleResult();
			
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			em.close();
		}
		
	}
	
	public List<Student> findAllStudent() {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JavaSTU");
		EntityManager em = managerFactory.createEntityManager();
		
		
		try {
			
			Query query = em.createNamedQuery("Student.findAll");

			@SuppressWarnings("unchecked")
			List<Student> list =  query.getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			em.close();
		}
		
	}
	
	
	
}
