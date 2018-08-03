package com.dlsmartercity.annualaccount.redis.lock;

public class Productor implements Runnable {
	
	private Account account;
	
	public Productor(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		this.account.deposit(100);
	}

}
