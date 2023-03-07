package org.stepdefinition;

import org.Pojo.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass {
	
	@Before(order=1)
	//precondition
	private void precondition2() {
		lanchBrowser();
		System.out.println("launch the browser");
		

	}
	@Before(order=2)
	private void precondition4() {
	
		windowmaximize();
		System.out.println("max the window");

	}
	@Before(order=3)
	private void precondition() {
		System.out.println("precondition 3");

	}
	@After(order=19)
	//postConditin
	private void postCondition1() {
		System.out.println("take screenschot of scenrios");
	}
	@After(order=1)
	//postCondition
		private void postCondition2() {
			CloseEntireBrowser();
			System.out.println("close entire browser");
		}
		

}
