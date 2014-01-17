package com.android.javanative;

public class NativeLib {

	  static {
	    System.loadLibrary("ndk_demo");
	  }
	  
	  /** 
	   * Adds two integers, returning their sum
	   */
	  public native int add( int v1, int v2 );
	  
	  /**
	   * Returns Hello World string
	   */
	  public native String hello();
	}
