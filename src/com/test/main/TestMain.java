package com.test.main;

import com.test.util.ChannelNotifySlack;

public class TestMain {
	
	// Get Your WEB HOOK URL at [MyWorkspace].slack.com 
	// ( https://my.slack.com/services/new/incoming-webhook/ )
	// 1. Choose a channel
	// 2. Add Incoming WebHooks integration, get Webhook URL
	
	final String _WEBHOOK_URL = " https://hooks.slack.com/services/xxxxxsxxx/xxxsxxxxx";
	

	public static void main(String[] args) {
		TestMain m = new TestMain();
		
		// build the message
		StringBuffer sb = new StringBuffer();
		
		for ( int i = 0 ; i < 1001; i++) {
			sb.append("message send to api^^^한글," + i);
			m.run(sb);
			sb.delete(0, sb.length());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	void run(StringBuffer sb) {

		ChannelNotifySlack ln = new ChannelNotifySlack();

		// send the message to notify
		try {

			// postNotify(String _WEBHOOK_URL,String textMessage,String botName)
			int resultCode = ln.postNotify(_WEBHOOK_URL, sb.toString(),"alert-bot");
			switch ( resultCode ) {
				case 200:
					System.out.println("send success");
					break;
				default:
					System.out.println("send fail, status: " + resultCode);
					break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( "Error Message : " + e.getMessage() );
		}

	}
}
