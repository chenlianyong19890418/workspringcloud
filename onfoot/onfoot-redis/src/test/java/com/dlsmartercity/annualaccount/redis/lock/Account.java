package com.dlsmartercity.annualaccount.redis.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dlsmartercity.annualaccount.redis.lock.RedisLock;

public class Account {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);
	
	private String accountNo;
	
	private double balance;
	
	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		RedisLock lock = RedisLock.getInstance("account");
		try {
			lock.lock();
			if(lock.isLock()) {
				LOGGER.info(Thread.currentThread().getName() + "-------------------------------------");
				LOGGER.info("存款前账户余额:【"+this.balance+"】存款金额:【"+amount+"】");
				this.balance += amount;
				LOGGER.info("存款后账户余额:【"+this.balance+"】");
				LOGGER.info(Thread.currentThread().getName() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void withdrawals(double amount) {
		RedisLock lock = RedisLock.getInstance("account");
		try {
			lock.lock();
			if(lock.isLock()) {
				LOGGER.info(Thread.currentThread().getName() + "-------------------------------------");
				LOGGER.info("取款前账户余额:【"+this.balance+"】取款金额:【"+amount+"】");
				if(this.balance - amount > 0) {
					this.balance -= amount;
				}
				LOGGER.info("取款后账户余额:【"+this.balance+"】");
				LOGGER.info(Thread.currentThread().getName() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
