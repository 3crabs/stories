package tech.threecrabs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\u0005"}, d2 = {"Ltech/threecrabs/IndexClient;", "", "index", "Lio/micronaut/http/HttpResponse;", "", "stories"})
@io.micronaut.http.client.annotation.Client(value = "/")
public abstract interface IndexClient {
    
    @org.jetbrains.annotations.NotNull()
    @io.micronaut.http.annotation.Get()
    public abstract io.micronaut.http.HttpResponse<java.lang.String> index();
}