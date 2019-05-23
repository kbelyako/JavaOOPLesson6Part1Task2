package com.yandex.kbelyako;

import java.math.BigInteger;

public class SingleThreadSum implements Runnable {
	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private BigInteger sum;

	public SingleThreadSum(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
	}

	public Thread getThr() {
		return thr;
	}

	public BigInteger getSumm() {

		return this.sum;
	}

	private int arraySummCalc(int[] inputArray, int begin, int end) {
		int summ = 0;
		for (int i = begin; i < end; i++) {
			summ = summ + inputArray[i];
		}
		return summ;
	}

	@Override
	public void run() {
		this.sum =new BigInteger(""+ arraySummCalc(this.array, this.begin, this.end));

	}

}