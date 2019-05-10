package com.bjsxt.java8;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6093576387399269007L;

	private long start;
	private long end;

	private static final long THRESGOLD = 10000;

	@Override
	protected Long compute() {
		long length = end - start;
		if (length <= THRESGOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}else {
			long middle= (start+end)/2;
			ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
			left.fork();//拆分子任务，同时压入线程队列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
			right.fork();
			return left.join()+right.join();
		}
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public ForkJoinCalculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	public ForkJoinCalculate() {
		super();
	}

}
