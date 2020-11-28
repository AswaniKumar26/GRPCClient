package com.aswin.learning.grpc.clientmain;

import com.aswin.learning.callGRPC.GRPCCaller;
import com.aswin.learning.grpc.User.APIResponse;

public class GRPCClient {

	public static void main(String[] args) {
		GRPCCaller call = new GRPCCaller();
		APIResponse resp = call.login("RAM", "RAM1");
		System.out.println(resp.getResponsemessage());
		resp= call.logout();
		System.out.println(resp.getResponsemessage());
	}

}
