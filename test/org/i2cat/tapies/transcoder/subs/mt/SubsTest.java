package org.i2cat.tapies.transcoder.subs.mt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SubsTest {
	private void launchMultipleThreads() {
		new Thread(new ThreadTest(0)).start();
		new Thread(new ThreadTest(1)).start();
		new Thread(new ThreadTest(2)).start();
		new Thread(new ThreadTest(3)).start();
		new Thread(new ThreadTest(4)).start();
	}

	public static void main(String[] args) {
		new SubsTest().launchMultipleThreads();
	}
}

class ThreadTest implements Runnable {

	private RandomAccessFile raf = null;
	private int id;

	public void run() {
		String line = "";
		try {
			line = raf.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Thread " + this.id + " says" + line);
		int i =0;
		while (i<1) {
			try {
				line = this.raf.readLine();
				System.out.println("Thread " + this.id + " says" + line);
				i++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ThreadTest(int id) {
		try {
			this.id = id;
			raf = new RandomAccessFile("rsc/subs/beautiful_mind_spanish.sub",
					"r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
