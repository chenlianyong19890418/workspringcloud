package com.dlsmartercity.annualaccount.redis.lock;

public class Consumer implements Runnable {
	
	private Account account;
	
	public Consumer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.withdrawals(2000);
	}

}
