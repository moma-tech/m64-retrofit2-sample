package com.moma.sample.retrofit2.caller;

import java.lang.annotation.Annotation;

/**
 * HttpMethodConstants
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
public interface HttpMethodConstants {
  Class<? extends Annotation> GET = retrofit2.http.GET.class;
  Class<? extends Annotation> POST = retrofit2.http.POST.class;
}
