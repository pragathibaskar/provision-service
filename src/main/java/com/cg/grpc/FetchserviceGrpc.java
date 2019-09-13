package com.cg.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.17.1)",
    comments = "Source: FindProvision.proto")
public final class FetchserviceGrpc {

  private FetchserviceGrpc() {}

  public static final String SERVICE_NAME = "com.cg.grpc.Fetchservice";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cg.grpc.FindProvision,
      com.cg.grpc.GetPage> getFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetch",
      requestType = com.cg.grpc.FindProvision.class,
      responseType = com.cg.grpc.GetPage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cg.grpc.FindProvision,
      com.cg.grpc.GetPage> getFetchMethod() {
    io.grpc.MethodDescriptor<com.cg.grpc.FindProvision, com.cg.grpc.GetPage> getFetchMethod;
    if ((getFetchMethod = FetchserviceGrpc.getFetchMethod) == null) {
      synchronized (FetchserviceGrpc.class) {
        if ((getFetchMethod = FetchserviceGrpc.getFetchMethod) == null) {
          FetchserviceGrpc.getFetchMethod = getFetchMethod = 
              io.grpc.MethodDescriptor.<com.cg.grpc.FindProvision, com.cg.grpc.GetPage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.cg.grpc.Fetchservice", "fetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cg.grpc.FindProvision.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cg.grpc.GetPage.getDefaultInstance()))
                  .setSchemaDescriptor(new FetchserviceMethodDescriptorSupplier("fetch"))
                  .build();
          }
        }
     }
     return getFetchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FetchserviceStub newStub(io.grpc.Channel channel) {
    return new FetchserviceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FetchserviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FetchserviceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FetchserviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FetchserviceFutureStub(channel);
  }

  /**
   */
  public static abstract class FetchserviceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetch(com.cg.grpc.FindProvision request,
        io.grpc.stub.StreamObserver<com.cg.grpc.GetPage> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cg.grpc.FindProvision,
                com.cg.grpc.GetPage>(
                  this, METHODID_FETCH)))
          .build();
    }
  }

  /**
   */
  public static final class FetchserviceStub extends io.grpc.stub.AbstractStub<FetchserviceStub> {
    private FetchserviceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchserviceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchserviceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchserviceStub(channel, callOptions);
    }

    /**
     */
    public void fetch(com.cg.grpc.FindProvision request,
        io.grpc.stub.StreamObserver<com.cg.grpc.GetPage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FetchserviceBlockingStub extends io.grpc.stub.AbstractStub<FetchserviceBlockingStub> {
    private FetchserviceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchserviceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchserviceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchserviceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cg.grpc.GetPage fetch(com.cg.grpc.FindProvision request) {
      return blockingUnaryCall(
          getChannel(), getFetchMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FetchserviceFutureStub extends io.grpc.stub.AbstractStub<FetchserviceFutureStub> {
    private FetchserviceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchserviceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchserviceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchserviceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cg.grpc.GetPage> fetch(
        com.cg.grpc.FindProvision request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FetchserviceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FetchserviceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH:
          serviceImpl.fetch((com.cg.grpc.FindProvision) request,
              (io.grpc.stub.StreamObserver<com.cg.grpc.GetPage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FetchserviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FetchserviceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cg.grpc.FindProvisionOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fetchservice");
    }
  }

  private static final class FetchserviceFileDescriptorSupplier
      extends FetchserviceBaseDescriptorSupplier {
    FetchserviceFileDescriptorSupplier() {}
  }

  private static final class FetchserviceMethodDescriptorSupplier
      extends FetchserviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FetchserviceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FetchserviceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FetchserviceFileDescriptorSupplier())
              .addMethod(getFetchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
