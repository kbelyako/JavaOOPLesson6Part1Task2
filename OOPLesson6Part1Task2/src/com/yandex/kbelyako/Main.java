//Написать код для многопоточного подсчета суммы элементов
//массива целых чисел. Сравнить скорость подсчета с простым
//алгоритмом.

package com.yandex.kbelyako;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] array = new int[200000000];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}

		long tstart = System.currentTimeMillis();
		BigInteger basicsumm = arraySummCalc(array, 0, array.length);
		long tend = System.currentTimeMillis();
		System.out.println(" Summ is " + basicsumm + " Calculated by one thread method, calculation time is " + (tend - tstart)
				+ " ms");

		tstart = System.currentTimeMillis();
		MultiThreadSum test = new MultiThreadSum(array, 4);
		BigInteger multisumm = test.getSumm();
		tend = System.currentTimeMillis();
		System.out.println(" Summ is " + multisumm + " Calculated by multi thread method, calculation time is " + (tend - tstart)
				+ " ms");
	}

	static BigInteger arraySummCalc(int[] inputArray, int begin, int end) {
		BigInteger summ = new BigInteger("0");;
		for (int i = begin; i  < end; i++) {
			summ = summ.add(new BigInteger("" +inputArray[i]));
		}

		return summ;
	}

}
