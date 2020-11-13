﻿package com.haoyun.automationtesting.page;

import com.haoyun.automationtesting.framework.Config;
import com.haoyun.automationtesting.framework.ExcelOperate;
import com.haoyun.automationtesting.framework.action;
import com.haoyun.automationtesting.framework.log;
import com.haoyun.automationtesting.test.aadomain.MainStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 公共方法以及公共控件的封装
 * 
 * @author lisheng
 *
 */
public class PM {
	public static WebDriver driver = MainStart.driver;

	public PM(WebDriver driver) {
		super();
		// action.driver = driver;
		// driver = mainStart.driver;
	}

	// public PM() {
	// driver = MainStart.driver;
	// }
	//
	// static {
	// driver = MainStart.driver;
	// }
	/** 时间随机数，不会重复，返回当天日期。格式“20170828120101” **/
	public static String sjs = MainStart.timenow;// 随机数14位
	public static String sjs6 = new SimpleDateFormat("sssSSS")
			.format(new Date());
	
	public static String nowTime = new SimpleDateFormat("MMddHHmmss").format(new Date());

	/** 基础数据名称：自动化+6位随机数 **/
	public static String jcsjmc = "自动化" + sjs6;

	/***
	 * 首次登陆
	 * 
	 * @throws Exception
	 */
	public static void Login_sc() throws Exception {// 首次登陆

		// 登陆
		String username = ExcelOperate.getexcel_sheet0(6, 4);
		String pw = ExcelOperate.getexcel_sheet0(6, 5);
		action.sleep(1);
		MainStart.driver.findElement(By.xpath("//*[@type='text']")).clear();
		MainStart.driver.findElement(By.xpath("//*[@type='text']")).sendKeys(
				username);
		MainStart.driver.findElement(By.xpath("//*[@type='password']")).clear();
		MainStart.driver.findElement(By.xpath("//*[@type='password']"))
				.sendKeys(pw);
		MainStart.driver.findElement(By.id("loginBtn")).click();
		
		//PM.normalize_texts_clicks("登 录");
//		action.isplay_text("智慧用电安全监控系统", 10);
		 action.sleep(3);

	}

	/***
	 * 退出登录
	 * 
	 * @throws Exception
	 */
	public static void Logout() throws Exception {// 退出登录
		// action.sleep(1);
		// action.actions_moveto(By.xpath("//*[@title='退出系统']"));
		MainStart.driver.navigate().refresh();
		action.sleep(5);
		MainStart.driver.findElement(
				By.xpath("//*[@class='toolbar']//*[@title='退出系统']")).click();
		action.sleep(2);
		PM.normalize_texts_clicks("确定");
		action.sleep(1);
		action.JS_wait(200);

	}

	/***
	 * 登陆
	 * 
	 * 1/登录后验证登录是否成功，如果不成功停止测试 2如果已经登录就先退出
	 */
	public static void Login(String username, String password) throws Exception {// 登陆
		// 登陆
		MainStart.driver.navigate().refresh();
		action.sleep(2);
		if (action.isdisplay(By.xpath("//*[@title='退出系统']"), 10)) {
			Logout();
			action.sleep(1);
			action.JS_wait(200);
		}

		MainStart.driver.findElement(By.xpath("//*[@type='text']")).clear();
		MainStart.driver.findElement(By.xpath("//*[@type='text']")).sendKeys(
				username);
		MainStart.driver.findElement(By.xpath("//*[@type='password']")).clear();
		MainStart.driver.findElement(By.xpath("//*[@type='password']"))
				.sendKeys(password);
		PM.normalize_texts_clicks("登录");
		action.sleep(1);
		action.JS_wait(200);
		if (action.isdisplay(By.xpath("//*[@title='退出系统']"), 10)) {

		} else {
			log.logWarn("登录失败:" + username);

		}

	}
	
	/***/
	
	/** 点击修改（人员管理）按钮 */
	public static void click_XGRY() throws Exception {//

		PM.normalize_text1_clicks("修改");
		Thread.sleep(1000);
	}
	
	/** 点击新增（人员管理）按钮 */
	public static void click_XZRY() throws Exception {//

		PM.normalize_texts_clicks("新增");
		Thread.sleep(1000);
	}

	/** 点击搜索按钮 */
	public static void click_SS() throws Exception {//

		PM.normalize_texts_clicks("搜索");
		Thread.sleep(1000);
	}

	/** 点击清空按钮 */
	public static void click_QK() throws Exception {//

		PM.normalize_texts_clicks("清空");
		Thread.sleep(1000);
	}

	/** 点击确定按钮 */
	public static void click_QD() throws Exception {//

		PM.normalize_texts_clicks("确定");
		Thread.sleep(1000);
	}

	/** 点击删除按钮 */
	public static void click_SC() throws Exception {//

		PM.normalize_texts_clicks("删除");
		Thread.sleep(1000);
	}

	/** 点击新建按钮 */
	public static void click_XJ() throws Exception {//

		PM.normalize_texts_clicks("新建");
		Thread.sleep(1000);
	}

	/** 点击新增按钮 */
	public static void click_XZ() throws Exception {//

		PM.normalize_texts_clicks("新增");
		Thread.sleep(1000);
	}

	/** 点击修改按钮 */
	public static void click_XG() throws Exception {//

		PM.normalize_texts_clicks("修改");
		Thread.sleep(1000);
	}

	/** 点击全部按钮 */
	public static void click_QB() throws Exception {//

		PM.normalize_texts_clicks("全部");
		Thread.sleep(1000);
	}

	/** 点击编辑按钮 */
	public static void click_BJ() throws Exception {//

		PM.normalize_texts_clicks("编辑");
		Thread.sleep(1000);
	}

	/** 点击详情按钮 */
	public static void click_XQ() throws Exception {//
		PM.normalize_texts_clicks("详情");
		Thread.sleep(2000);

	}

	/** 点击启用按钮 */
	public static void click_QY() throws Exception {//

		PM.normalize_texts_clicks("启用");
		Thread.sleep(2000);
	}

	/** 点击禁用按钮 */
	public static void click_JY() throws Exception {//

		PM.normalize_texts_clicks("禁用");
		Thread.sleep(2000);
	}

	/** 点击提交按钮 */
	public static void click_TJ() throws Exception {//

		PM.normalize_texts_clicks("提交");
		Thread.sleep(4000);
	}

	/** 点击查询按钮 */
	public static void click_CX() throws Exception {//

		PM.normalize_texts_clicks("查询");
		Thread.sleep(2000);
	}

	/** 点击重置按钮 */
	public static void click_CZ() throws Exception {//

		PM.normalize_texts_clicks("重置");
		Thread.sleep(2000);
	}

	/** 点击导入按钮 */
	public static void click_DR() throws Exception {//

		PM.normalize_texts_clicks("导入");
		Thread.sleep(2000);
	}

	/** 点击导出按钮 */
	public static void click_DC() throws Exception {//

		PM.normalize_texts_clicks("导出");
		Thread.sleep(2000);
	}

	/** 点击取消按钮 */
	public static void click_QX() throws Exception {//

		PM.normalize_texts_clicks("取消");
		Thread.sleep(1000);
	}

	/** 清除操作：文本旁边的输入框内容 */
	public static void clear(String text) throws Exception {//
		action.isdisplay(
				By.xpath("//*[normalize-space(text()) and normalize-space(.)='"
						+ text + "']/following::input[1]"), 10);
		MainStart.driver.findElement(
				By.xpath("//*[normalize-space(text()) and normalize-space(.)='"
						+ text + "']/following::input[1]")).clear();
		Thread.sleep(100);
	}

	/** 清除操作：修改人员姓名时清空文本框 */
	public static void clear1(String text) throws Exception {//
//		action.isdisplay(
//				By.xpath("//*[normalize-space(text()) and normalize-space(.)='"
//						+ text + "']/following::input[1]"), 10);
		MainStart.driver.findElement(
				By.xpath("//input[@data-id='CONTROL_TEXT_35']")).clear();
		Thread.sleep(100);
	}
	
	/** 清除操作：修改下单的单价时清空文本框 */
	public static void clear2() throws Exception {
	
//		driver.switchTo().frame("fix-page-iframe");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'fix-page-iframe')]")));
		
//		WebElement iframe=driver.findElement(By.xpath("//*[@id='fix-page-iframe']"));
//		driver.switchTo().frame(iframe);
//		driver.switchTo().frame(iframe);

		MainStart.driver.findElement(
				By.xpath("//*[normalize-space(text()) and normalize-space(.)='货物单价（元）']//following::input[1]")).clear();
		Thread.sleep(100);
	}
	
	/** 清除操作：修改下单数量时清空文本框 */
	public static void clear3() throws Exception {
		
//		driver.switchTo().frame("fix-page-iframe");
//		driver.findElement(By.xpath("//*[@id='fix-page-iframe']"));
		WebElement iframe=driver.findElement(By.xpath("//*[@id='fix-page-iframe']"));
		driver.switchTo().frame(iframe);

		MainStart.driver.findElement(
				By.xpath("//*[normalize-space(text()) and normalize-space(.)='下单数量']//following::input[1]")).clear();
		Thread.sleep(100);
	}
	
	
	/** 弹出窗口中的控件-点击操作：文本左边的单选框 ，如果有多个选择第一个 */
	public static void pop_click_textradio(String text) throws Exception {//

		MainStart.driver
				.findElements(
						By.xpath("//*[normalize-space(text()) and normalize-space(.)='"
								+ text
								+ "']/preceding::label[@role='radio'][1]"))
				.get(0).click();
		Thread.sleep(100);
		action.JS_wait(200);
	}

	/** 弹出窗口中的控件点击操作：文本左边的span，如果有多个选择第一个 */
	public static void pop_click_textspan(String text) throws Exception {//

		MainStart.driver
				.findElements(
						By.xpath("//*[@role='tooltip']//*[normalize-space(text()) and normalize-space(.)='"
								+ text + "']/preceding::span[1]")).get(0)
				.click();
		Thread.sleep(100);
		action.JS_wait(200);
	}

	/**
	 * 
	 * 下拉框中的控件点击操作：点击下拉框中文字,如果有多个就依次点击
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * */
	public static void pop_click_text(String text) throws Exception {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + text + "']"), 5)) {
		int size = 0;

		try {
			action.isdisplay(
					By.xpath("//*[@role='tooltip' or @class='el-scrollbar']//*[normalize-space(text()) and normalize-space(.)='"
							+ text + "']"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath("//*[@role='tooltip' or @class='el-scrollbar']//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).size();
			// log.logInfo("normalize_texts_clicks:size:"+size);
		} catch (Exception e) {
		}

		if (size == 0) {
			log.logWarn("页面中没有找到文字:" + text + ",可能不是必选项");
		}

		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath("//*[@role='tooltip' or @class='el-scrollbar']//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).get(i).isDisplayed()) {
				Thread.sleep(100);
				try {
					MainStart.driver
							.findElements(
									By.xpath("//*[@role='tooltip' or @class='el-scrollbar']//*[normalize-space(text()) and normalize-space(.)='"
											+ text + "']")).get(i).click();
				} catch (Exception e) {
					// e.printStackTrace();
					// log.logWarn("有多个，当前没找到第："+ i+"个");
				}
				// break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}

	/**
	 * 菜单名称
	 * 
	 * @param text
	 * @throws Exception
	 */
	public static void menu_text(String text) throws Exception {//
		Thread.sleep(200);
		action.JS_MoveWebElement(By
				.xpath("//a[@data-text='" + text + "']"));
		action.isdisplay(
				By.xpath("//a[@data-text='" + text + "']"), 10);
		MainStart.driver
				.findElement(
						By.xpath("//a[@data-text='" + text + "']")).click();
		Thread.sleep(1000);
		action.JS_wait(200);
	}



	// /**
	// * 弹出窗口-页面中文字旁边的输入框
	// *
	// * @param string
	// * 页面中文字
	// * @param string2
	// * 输入的内如
	// * @throws InterruptedException
	// * @throws ParseException
	// */
	// public static void pop_normalize_input_sendkeys(String string, String
	// string2)
	// throws InterruptedException, ParseException {
	// action.JS_wait(200);
	// WebElement dr = driver.findElement(By
	// .xpath("//*[@class='el-dialog__body']//*[normalize-space(text()) and normalize-space(.)='"
	// + string + "']/following::input[1]"));
	// dr.clear();
	// dr.sendKeys(string2);
	// Thread.sleep(100);
	// action.JS_wait(200);
	// }

	// /**
	// * 弹出窗口-点击页面中文字旁边的输入框
	// *
	// * @param string
	// * 页面中文字
	// * @throws InterruptedException
	// * @throws ParseException
	// */
	// public static void pop_normalize_input_click(String string)
	// throws InterruptedException, ParseException {
	// action.JS_wait(200);
	// WebElement dr = driver.findElement(By
	// .xpath("//*[@class='el-dialog__body']//*[normalize-space(text()) and normalize-space(.)='"
	// + string + "'][1]/following::input[1]"));
	// dr.click();
	// Thread.sleep(100);
	// action.JS_wait(200);
	// }

	// /**
	// * 弹出窗口-页面中文字旁边的选择框el-dialog__body
	// *
	// * @param string
	// * 页面中文字
	// * @param string2
	// * 下拉框中选择的内容
	// * @throws InterruptedException
	// * @throws ParseException
	// */
	// public static void pop_normalize_select_sendkeys(String string, String
	// string2)
	// throws InterruptedException, ParseException {
	// action.JS_wait(200);
	// WebElement dr = driver.findElement(By
	// .xpath("//*[@class='el-dialog__body']//*[normalize-space(text()) and normalize-space(.)='"
	// + string + "']/following::select[1]"));
	// new Select(dr).selectByVisibleText(string2);
	// Thread.sleep(100);
	// action.JS_wait(200);
	// }

	// *[@class="el-dialog__body"]

	/**
	 * 
	 * 下拉框操作：文本后面的选择框,如果有多个就依次选择
	 * 
	 * @param string
	 *            页面中文字
	 * @param string2
	 *            下拉框中选择的内容
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static void normalize_selects_sendkeys(String string, String string2)
			throws InterruptedException, ParseException {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + string + "']/following::select[1]"), 5)) {
		int size = 0;
		MainStart.driver.manage().timeouts()
				.implicitlyWait(2, TimeUnit.SECONDS);
		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ string + "']/following::select[1]"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']/following::select[1]"))
					.size();

		} catch (Exception e) {

		}
		MainStart.driver.manage().timeouts()
				.implicitlyWait(Config.appiumconfig_waitTime, TimeUnit.SECONDS);
		// log.logInfo("元素个数：" + size);
		if (size == 0) {
			log.logWarn("页面中没有找到select文字:" + string + ",可能不是必选项");
		}
		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']/following::select[1]"))
					.get(i).isDisplayed()) {
				WebElement dr = MainStart.driver
						.findElements(
								By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
										+ string + "']/following::select[1]"))
						.get(i);
				new Select(dr).selectByVisibleText(string2);
				break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}

	/**
	 * 
	 * 点击：页面文字,如果有多个就依次选择
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * */
	public static void normalize_texts_clicks(String text) throws Exception {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + text + "']"), 5)) {
		int size = 0;

		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ text + "']"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).size();
			log.logInfo("text"+text);
			 log.logInfo("normalize_texts_clicks:size:"+size);
		} catch (Exception e) {
		}

		if (size == 0) {
			log.logWarn("页面中没有找到文字:" + text + ",可能不是必选项");
		}

		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).get(i).isDisplayed()) {
				Thread.sleep(100);
				try {
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ text + "']")).get(i).click();
				} catch (Exception e) {
					// e.printStackTrace();
					// log.logWarn("有多个，当前没找到第："+ i+"个");
				}
				// break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}
	/**
	 * 
	 * 点击：页面文字,如果有多个就点击第一个
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * */
	public static void normalize_text_clicks(String text) throws Exception {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + text + "']"), 5)) {
		int size = 0;

		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ text + "']"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).size();
			log.logInfo("text"+text);
			 log.logInfo("normalize_texts_clicks:size:"+size);
		} catch (Exception e) {
		}

		if (size == 0) {
			log.logWarn("页面中没有找到文字:" + text + ",可能不是必选项");
		}

		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).get(i).isDisplayed()) {
				Thread.sleep(100);
				try {
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ text + "']")).get(i).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();
					// log.logWarn("有多个，当前没找到第："+ i+"个");
				}
				// break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}
	/**
	 * 点击：页面中文字后面的输入框,如果有多个就依次点击
	 * 
	 * @param string
	 *            页面中文字
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static void normalize_inputs_clicks(String string)
			throws InterruptedException, ParseException {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + string + "']/following::input[1]"), 5)) {
		int size = 0;
		MainStart.driver.manage().timeouts()
				.implicitlyWait(2, TimeUnit.SECONDS);
		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ string + "']/following::input[1]"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']/following::input[1]"))
					.size();

		} catch (Exception e) {

		}
		MainStart.driver.manage().timeouts()
				.implicitlyWait(Config.appiumconfig_waitTime, TimeUnit.SECONDS);
		if (size == 0) {
			log.logWarn("页面中没有找到input旁的文字:" + string + ",可能不是必选项");
		}
		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']/following::input[1]"))
					.get(i).isDisplayed()) {
				try {
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ string + "']/following::input[1]"))
							.get(i).click();
				} catch (Exception e) {
					// log.logWarn("有多个，当前没找到第："+ i+"个");
				}
				// break;
			}

		}
		Thread.sleep(100);
		action.JS_wait(200);
	}

	/**
	 * 输入：文本后面的输入框,如果有多个就依次点击
	 * 
	 * @param string
	 *            页面中文字
	 * @param string2
	 *            输入的内容
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static void normalize_inputs_sendkeys(String string, String string2)
			throws InterruptedException, ParseException {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + string + "']/following::input[1]"), 5)) {
		int size = 0;
		MainStart.driver.manage().timeouts()
				.implicitlyWait(2, TimeUnit.SECONDS);
		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ string + "']//following::input[1]"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']//following::input[1]"))
					.size();

			// log.logInfo("normalize_inputs_sendkeys:size:"+size);
		} catch (Exception e) {

		}
		MainStart.driver.manage().timeouts()
				.implicitlyWait(Config.appiumconfig_waitTime, TimeUnit.SECONDS);
		if (size == 0) {
			log.logWarn("页面中没有找到input旁的文字:" + string + ",可能不是必选项");
		}
		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ string + "']//following::input[1]"))
					.get(i).isDisplayed()) {

				try {
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ string
											+ "']//following::input[1]"))
							.get(i).clear();
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ string
											+ "']//following::input[1]"))
							.get(i).sendKeys(string2);
				} catch (Exception e1) {

				}
				// break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}

	/***
	 * 返回首页（每个用例的第一个步骤）
	 * 
	 * @throws Exception
	 *             1、判断是否登录状态，如未登录重新登。
	 * @throws Exception
	 *             2、判断是否有弹出窗口，如果有就通过刷新页面的方式去掉弹出框。
	 * @throws Exception
	 *             3、判断首页菜单是否存在，如不存在就刷新再登录一次系统，否则停止执行。
	 */
	public static void return_sy() throws Exception {// 返回首页

		if (action.isdisplay(By.xpath("//*[@type='password']"), 1)) {
			String username = ExcelOperate.getexcel_sheet0(6, 4);
			String pw = ExcelOperate.getexcel_sheet0(6, 5);
			PM.Login(username, pw);
			action.sleep(1);
			action.JS_wait(200);
		}
		try {
//			if (action.isdisplay(By.id("logoutBtn"), 10)) {    默认
			if (action.isdisplay(By.xpath("//*[contains(text(),'首页')]"), 10)) {
				MainStart.driver.navigate().refresh();
				action.sleep(1);
				action.JS_wait(200);

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.logWarn("无法看到首页，刷新再登录一次！");
			MainStart.driver.navigate().refresh();
			action.sleep(1);
			String username = ExcelOperate.getexcel_sheet0(6, 4);
			String pw = ExcelOperate.getexcel_sheet0(6, 5);
			PM.Login(username, pw);
			if (action.isdisplay(By.xpath("//*[@title='退出系统']"), 2)) {
			} else {
				log.logWarn("再登录也不能正常进入首页，退出执行！");
				System.exit(0);
			}

		}
		Thread.sleep(100);
		action.JS_wait(10);
	}

	/**
	 * 获取页面表单下面数据条数（例子：共7条）
	 * 
	 * @param n
	 *            第n个
	 * @return
	 */
	public static String getPaginationTotal(int n) {
		String total = "";
		try {

			String pagination__total = MainStart.driver
					.findElements(
							By.xpath("//*[@class='el-pagination__total']"))
					.get(n).getText();
			// log.logInfo("pagination__total:"+pagination__total);
			int length = pagination__total.trim().length();
			total = (String) pagination__total.subSequence(2, length - 2);
			// log.logInfo("total:"+total);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			return total;
		}

	}

	/**
	 * 表单中,找到含有特定文字的那一行,点击行按钮
	 * 
	 * @param text
	 *            特定文字
	 * @param buttonType
	 *            一行中的第几个按钮(角色管理中对应的是:按钮类型：1是权限，2是修改，3是删除)
	 * */
	public static void click_TableRowButton(String text, String buttonType) {
		try {
			String str = new StringBuffer(
					"//*[@class='el-table__body']//*[normalize-space(text())  and  normalize-space(.)='")
					.append(text).append("']").append("/following::button[")
					.append(buttonType).append("]").toString();

			int size = MainStart.driver.findElements(By.xpath(str)).size();
			for (int i = 0; i < size; i++) {
				action.sleep(1);
				if (MainStart.driver.findElements(By.xpath(str)).get(i)
						.isDisplayed()) {
					MainStart.driver.findElements(By.xpath(str)).get(i).click();
				}
				action.sleep(1);
			}
		} catch (Exception e) {
			log.logWarn("click_TableRowButton方法未点击到按钮!");
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * 列表中第一个修改按钮
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * */
	public static void normalize_text1_clicks(String text) throws Exception {
		Thread.sleep(100);
		// if (action.isdisplay(By
		// .xpath(".//*[normalize-space(text()) and normalize-space(.)='"
		// + text + "']"), 5)) {
		int size = 0;

		try {
			action.isdisplay(
					By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
							+ text + "']"), 5);
			size = MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).size();
			log.logInfo("text"+text);
			 log.logInfo("normalize_texts_clicks:size:"+size);
		} catch (Exception e) {
		}

		if (size == 0) {
			log.logWarn("页面中没有找到文字:" + text + ",可能不是必选项");
		}

		for (int i = 0; i < size; i++) {

			if (MainStart.driver
					.findElements(
							By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).get(i).isDisplayed()) {
				Thread.sleep(100);
				try {
					MainStart.driver
							.findElements(
									By.xpath(".//*[normalize-space(text()) and normalize-space(.)='"
											+ text + "']")).get(i).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();
					// log.logWarn("有多个，当前没找到第："+ i+"个");
				}
				// break;
			}

		}

		Thread.sleep(100);
		action.JS_wait(200);
	}
	
	/**
	 * 点击弹窗搜索框，输入搜索内容
	 */
	public static void normalize_clickAndSendkeys(String text){
		try {
			action.findElement_sendkeys(By.xpath("//form[@id='searchform']/descendant::input"), text);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击弹窗搜索框后的搜索小图标
	 */
	public static void normalize_searchIcon(){
		try {
			action.findElement_click(By.xpath("//form[@id='searchform']/descendant::button"));
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否执行此操作，是
	 */
	public static void normalize_yes(){
		try {
			action.findElement_click(By.xpath("//div/a[1][contains(text(),'是')]"));
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否执行此操作，否
	 */
	public static void normalize_no(){
		try {
			action.findElement_click(By.xpath("//div/a[2][contains(text(),'否')]"));
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 弹窗底部的【确定】按钮
	 */
	public static void normalize_bottom_QD(){
		try {
			action.findElement_click(
					By.xpath("//body/div[1]//button[contains(text(),'确定')]"));
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * 弹窗底部的【取消】按钮
	 */
	public static void normalize_bottom_QX(){
		try {
			action.findElement_click(
					By.xpath("//body/div[1]//button[contains(text(),'取消')]"));
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * option 下拉选择 (主要用于产品基础信息模块)
	 * text :下拉选项中的内容,如果有多个，依次点击
	 */
	public static void option_select(String text){
		int size=0;
		try {
			action.findElement_click(
					By.xpath("//option[normalize-space(text()) and normalize-space(.)='"
									+ text + "']"));
			size = MainStart.driver
					.findElements(
							By.xpath("//option[normalize-space(text()) and normalize-space(.)='"
									+ text + "']")).size();

		} catch (InterruptedException e) {
			if (size <= 0) {
				log.logWarn("下拉选择中没有找到文字:" + text + ",请重新定位");
			}else{
				log.logInfo("找到"+size+"个"+text+"==========");
				
				for (int i = 0; i < size; i++) {

					if (MainStart.driver
							.findElements(
									By.xpath("//option[normalize-space(text()) and normalize-space(.)='"
									+ text + "']"))
							.get(i).isDisplayed()) {

						try {
							MainStart.driver
									.findElements(
											By.xpath("//option[normalize-space(text()) and normalize-space(.)='"
									+ text + "']"))
									.get(i).clear();
							MainStart.driver
									.findElements(
											By.xpath("//option[normalize-space(text()) and normalize-space(.)='"
									+ text + "']"))
									.get(i).click();
						} catch (Exception e1) {

						}
						// break;
					}
				}
			}
			
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 弹窗选择底部确定按钮
	 */
	public static void pop_QD(){
		int size=0;
		try {
			action.findElement_click(By.xpath("//button[@ng-click='save()']"));
			size = MainStart.driver
					.findElements(
							By.xpath("//button[@ng-click='save()']")).size();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			if (size <= 0) {
				log.logWarn("没有找到确定按钮,请重新定位");
			}else{
				log.logInfo("找到"+size+"个【确定】按钮==========");
				
			}
			e.printStackTrace();
		}
	}

	/**
	 * 鼠标点击屏幕中的某一个点（用于关闭下拉多选框）
	 */
	public static void mouse_click(int x,int y){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.mouseMove(500, 500);
		robot.delay(1000);
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
	}
/**
	 * 分支提交测试
	 */
}
