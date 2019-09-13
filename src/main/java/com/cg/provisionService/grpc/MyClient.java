package com.cg.provisionService.grpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.cg.grpc.FetchserviceGrpc;
import com.cg.grpc.FindProvision;
import com.cg.grpc.GetPage;
import com.cg.grpc.GetResults;
import com.cg.provisionService.domain.Composite;
import com.cg.provisionService.domain.CustomGetResult;
import com.cg.provisionService.domain.Customresponse;
import com.cg.provisionService.domain.Provision;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class MyClient {

	private FetchserviceGrpc.FetchserviceBlockingStub stub;

	@PostConstruct
	private void init() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext(true).build();
		stub = FetchserviceGrpc.newBlockingStub(channel);
	}

	public Customresponse fetch(long timestamp, int page, int size) {
		FindProvision fin = FindProvision.newBuilder().setTimestamp(timestamp).setPage(page).setSize(size).build();

		List<Provision> pro = new ArrayList<Provision>();
		Customresponse res = new Customresponse();

		int count = stub.fetch(fin).getResultCount();
		GetPage getpage = stub.fetch(fin);

		for (int i = 0; i < count; i++) {
			System.out.println("inside for loop");
			Provision pi = new Provision();
			Composite p = new Composite();
			p.setCodigo(getpage.getResult(i).getCodigo());
			p.setCod_sociedad(getpage.getResult(i).getCodSocieded());
			Date date = new Date(getpage.getResult(i).getTimestamp());
			p.setPeriodo(date);
			pi.setKey(p);
			pro.add(pi);

		}
		res.setProvision(pro);
		res.setTotalElements(getpage.getTotalelements());

		return res;

	}

}
