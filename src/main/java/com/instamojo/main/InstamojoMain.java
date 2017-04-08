package com.instamojo.main;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderFilter;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import com.instamojo.wrapper.response.PaymentOrderListResponse;

public class InstamojoMain {

	public String CreateLink(String name,String email_id,String phone_no,String transaction_id,String discription,double amount) {
		
		PaymentOrder order = new PaymentOrder();

		order.setName(name);
		order.setEmail(email_id);
		order.setPhone(phone_no);
		order.setCurrency("INR");
		order.setAmount(amount);
		order.setDescription(discription);
		order.setRedirectUrl("http://localhost:8080/tallentview/contest");
		//order.setRedirectUrl("http://52.35.203.16/contest");
		//order.setRedirectUrl("http://www.tallentview.com/contest");
		order.setTransactionId(transaction_id);

		Instamojo api = null;
		String UserJson="";
		String order_id="";

		try {
		    // gets the reference to the instamojo api
		    api = InstamojoImpl.getApi("8asJ3dlbTXEo4cnCXxlJPZkvO835tztt4q3qBHDM",
					"gzkCBZ0dBGXTGJy09o35DDY37OXugIaoCnfRBh7uAhVyzj1wu9ax2tVl3iWsyrCVYZtg2ZJjgsehAYcInOlbohPJ7ZNNLdfggHuS8PdxrYqDLwPbcYQOPvNLlN71KtXZ",
					"https://test.instamojo.com/v2/","https://test.instamojo.com/oauth2/token/");
			/*api = InstamojoImpl.getApi("GOcTGtcwEoefX4gHTOdZXFjdqfJlIkvglGi6eETh",
					"GJKZN7Ad6uDnGcmy5tvhIvsjYhIhXxanJwxyG9kxv69F7tDB4I8hWVMlUY732rzaAZ3A5Y31rfDcRregUoq9zfqqtGp5VJsNeZEERLWR1aoMqJeO7cJjv5uClnfqt0SY"
		    		,"https://www.instamojo.com/v2/","https://www.instamojo.com/oauth2/token/");*/ //Original Payment Gateway Credentials
		  /*  api = InstamojoImpl.getApi("BxHq8awfo0sStNicCrCvmeyvGb5s1wFx093aqwts",
					"3QidnIIkfjweTbuNtpEsma0FuEYf2SvJ5ycbISSe64ScTeTe6pZoxCYk1UFTGagn6BQyeEnlRKY3O09blfXXiV7CfRYe6rHQETMab0rw9fo45V8CX6TaVbGPuxhreE7H"
		    		,"https://test.instamojo.com/v2/","https://test.instamojo.com/oauth2/token/");*/
		} catch (ConnectionException e) {
			e.printStackTrace();
		   // LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		boolean isOrderValid = order.validate();

		if (isOrderValid) {
		    try {
		        CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
		        // print the status of the payment order.
		        System.out.println(createPaymentOrderResponse.getPaymentOrder().getStatus());
		        UserJson = createPaymentOrderResponse.toString();
		        order_id = createPaymentOrderResponse.getPaymentOrder().getId();
		        System.out.println(UserJson);
		        System.out.println("order_id:::  "+order_id);
		    } catch (InvalidPaymentOrderException e) {
		       // LOGGER.log(Level.SEVERE, e.toString(), e);

		        if (order.isTransactionIdInvalid()) {
		            System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
		        }
		        if (order.isCurrencyInvalid()) {
		            System.out.println("Currency is invalid.");
		        }
		    } catch (ConnectionException e) {
		        //LOGGER.log(Level.SEVERE, e.toString(), e);
		    }
		} else {
		    // inform validation errors to the user.
		    if (order.isTransactionIdInvalid()) {
		        System.out.println("Transaction id is invalid.");
		    }
		    if (order.isAmountInvalid()) {
		      System.out.println("Amount can not be less than 9.00.");
		    }
		    if (order.isCurrencyInvalid()) {
		      System.out.println("Please provide the currency.");
		    }
		    if (order.isDescriptionInvalid()) {
		      System.out.println("Description can not be greater than 255 characters.");
		        }
		    if (order.isEmailInvalid()) {
		      System.out.println("Please provide valid Email Address.");
		    }
		    if (order.isNameInvalid()) {
		      System.out.println("Name can not be greater than 100 characters.");
		    }
		    if (order.isPhoneInvalid()) {
		      System.out.println("Phone is invalid.");
		    }
		    if (order.isRedirectUrlInvalid()) {
		      System.out.println("Please provide valid Redirect url.");
		    }
		}	
		
	return order_id;
	}
	
	public static void main(String[] args) {
		InstamojoMain instamojoMain = new InstamojoMain();
		System.out.println("payment info:: "+instamojoMain.CreateLink("","","","","",9D));
	}
	
}
