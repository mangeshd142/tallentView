package com.tallentview.contest.Dao;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tallentview.contest.model.PaymentBean;
import com.tallentview.tallentview.hibernateconf.HibernateDaoImpl;

public class PaymentDao {
	
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	//context.registerShutdownHook();
	HibernateDaoImpl hibdaoimpl = (HibernateDaoImpl)context.getBean("sessionfactory");
	
	public String setPaymentInfo(long userId,long contestId){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		PaymentBean paymentBean = new PaymentBean();
		
		paymentBean.setUser_id(userId);
		paymentBean.setContest_id(contestId);
		
		ses.save(paymentBean);
		ses.beginTransaction().commit();
		ses.evict(paymentBean);
		ses.clear();
		ses.clear();
		
	return paymentBean.getTransaction_id();
	}
	
	public void updatePaymentInfo(String transaction_id, String order_id, String payment_id,String time, String status,double amount){
		context.registerShutdownHook();
		Session ses = hibdaoimpl.getSessionfactory().openSession();
		
		PaymentBean paymentBean = (PaymentBean) ses.get(PaymentBean.class, transaction_id);
		
		paymentBean.setOrder_id(order_id);
		paymentBean.setPayment_id(payment_id);
		paymentBean.setTime(time);
		paymentBean.setStatus(status);
		paymentBean.setAmount(amount);
		
		ses.update(paymentBean);
		ses.beginTransaction().commit();
		ses.evict(paymentBean);
		ses.clear();
		ses.close();
	}

}
