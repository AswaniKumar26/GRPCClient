package com.aswin.learning.callGRPC;

import com.aswin.learning.grpc.userGrpc;

import com.aswin.learning.grpc.User.APIResponse;
import com.aswin.learning.grpc.User.LoginRequest;
import com.aswin.learning.grpc.userGrpc;
import com.aswin.learning.grpc.User.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCCaller {
	
	ManagedChannel channel = null;
	String host ="localhost";
	int port = 10001;
	String userName;
	String password;
	userGrpc.userBlockingStub stub = null;
	private void buildChannel() {
		if(channel == null) {
			channel = ManagedChannelBuilder.forAddress(host,port).
	                  usePlaintext().build();
		}
	}
	private void buildBlockingStub () {
		if(stub == null) {
			stub = userGrpc.newBlockingStub(channel);
		}
	}
	
	private LoginRequest buildLoginMessage(String name,String pass) {
		LoginRequest req = LoginRequest.newBuilder().setUsername(name).setPassword(pass).build();
		return req;
	}
	
	
	public APIResponse login(String name, String pass) {
		LoginRequest req = buildLoginMessage(name,pass);
		APIResponse resp = stub.login(req);
		return resp;
	}
	
	public APIResponse logout() {
		Empty req = null;
		APIResponse resp = stub.logout(req);
		return resp;
	}

	public GRPCCaller() {
		buildChannel();
		buildBlockingStub();
	}
    
	

}
