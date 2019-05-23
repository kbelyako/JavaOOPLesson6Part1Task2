package com.yandex.kbelyako;

import java.math.BigInteger;

public class MultiThreadSum {

	private BigInteger summ;
	private int[] array;
	private int threadNumber;

	public MultiThreadSum(int[] array, int threadNumber) {
		super();
		this.array = array;
		this.threadNumber = threadNumber;
		calcSumm(array, threadNumber);
	}

	public BigInteger getSumm() {

		return this.summ;
	}

	private void calcSumm(int[] array, int threadNumber) {
		SingleThreadSum[] threadarray = new SingleThreadSum[threadNumber];
		BigInteger summ = new BigInteger ("0");
		for (int i = 0; i < threadarray.length; i++) {
			int size = array.length / threadNumber;
			int begin = size * i;
			int end = ((i + 1) * size);
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadarray[i] = new SingleThreadSum(array, begin, end);

		}
		for (int i = 0; i < threadarray.length; i++) {
			try {
				threadarray[i].getThr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			summ = summ.add(new BigInteger (""+threadarray[i].getSumm()));
		}

		this.summ = summ;

	}

}