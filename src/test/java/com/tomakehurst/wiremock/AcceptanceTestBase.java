package com.tomakehurst.wiremock;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.tomakehurst.wiremock.client.WireMock;
import com.tomakehurst.wiremock.testsupport.WireMockTestClient;

public class AcceptanceTestBase {

	protected static WireMockServer wireMockServer;
	protected static WireMockTestClient testClient;
	
	@BeforeClass
	public static void setupServer() {
		wireMockServer = new WireMockServer();
		wireMockServer.start();
		testClient = new WireMockTestClient();
		WireMock.configure();
	}
	
	@AfterClass
	public static void serverShutdown() {
		wireMockServer.stop();
	}
	
	@Before
	public void init() throws InterruptedException {
		WireMock.reset();
	}

}