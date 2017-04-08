package com.instamojo.main;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;

public class GetOrderDetails {
public  PaymentOrderDetailsResponse getOrderDetails(String orderId) {
	//ce7e72be224e490a869959840cdb5415
	String status ="";
	PaymentOrderDetailsResponse paymentOrderDetailsResponse = new PaymentOrderDetailsResponse();
try {
	    Instamojo api;
	    api= InstamojoImpl.getApi("8asJ3dlbTXEo4cnCXxlJPZkvO835tztt4q3qBHDM",
				"gzkCBZ0dBGXTGJy09o35DDY37OXugIaoCnfRBh7uAhVyzj1wu9ax2tVl3iWsyrCVYZtg2ZJjgsehAYcInOlbohPJ7ZNNLdfggHuS8PdxrYqDLwPbcYQOPvNLlN71KtXZ",
				"https://test.instamojo.com/v2/","https://test.instamojo.com/oauth2/token/");
	    /*api = InstamojoImpl.getApi("GOcTGtcwEoefX4gHTOdZXFjdqfJlIkvglGi6eETh",
		"GJKZN7Ad6uDnGcmy5tvhIvsjYhIhXxanJwxyG9kxv69F7tDB4I8hWVMlUY732rzaAZ3A5Y31rfDcRregUoq9zfqqtGp5VJsNeZEERLWR1aoMqJeO7cJjv5uClnfqt0SY"
		,"https://www.instamojo.com/v2/","https://www.instamojo.com/oauth2/token/");*/ //Original Payment Gateway Credentials

	     paymentOrderDetailsResponse = api.getPaymentOrderDetails(orderId);
	   // PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetailsByTransactionId(orderId);

	    // print the status of the payment order.
	    status = paymentOrderDetailsResponse.getStatus();
	    System.out.println(status);
	    
	    System.out.println(paymentOrderDetailsResponse.toString());
	} catch (ConnectionException e) {
	   // LOGGER.log(Level.SEVERE, e.toString(), e);
	}
return paymentOrderDetailsResponse;
}


public static void main(String[] args) {
	GetOrderDetails details = new GetOrderDetails();
	details.getOrderDetails("ff808181570125e301570127af720003");
}
}
